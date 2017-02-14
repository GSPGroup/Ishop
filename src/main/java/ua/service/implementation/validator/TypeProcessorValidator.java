package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.TypeProcessorForm;
import ua.service.TypeProcessorService;

public class TypeProcessorValidator implements Validator {

	private final TypeProcessorService typeprocessorService;
//	private static final Pattern p = Pattern.compile("^[a-z]{1,15}$");

	public TypeProcessorValidator(TypeProcessorService typeprocessorService) {
		this.typeprocessorService = typeprocessorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return TypeProcessorForm.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		TypeProcessorForm form = (TypeProcessorForm) target;
		if(form.getId()==0)if(typeprocessorService.findByName(form.getName())!=null){
			errors.rejectValue("name", "", "TypeProcessor already exists");
		}
//		Matcher m = p.matcher(form.getName());
//		if(!m.matches()){
//			errors.rejectValue("name", "", "name format is a-z ");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
	}
}
