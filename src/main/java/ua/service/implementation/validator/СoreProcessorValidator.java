package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.�oreProcessorForm;
import ua.service.�oreProcessorService;

public class �oreProcessorValidator implements Validator {

	private final �oreProcessorService coreprocessorService;
//	private static final Pattern p = Pattern.compile("^[0-9]{1,2}$");

	public �oreProcessorValidator(�oreProcessorService coreprocessorService) {
		this.coreprocessorService = coreprocessorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return �oreProcessorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		�oreProcessorForm form = (�oreProcessorForm) target;
		if(form.getId()==0)if(coreprocessorService.findByName(form.getCore())!=null){
			errors.rejectValue("core", "", "�oreProcessor already exists");
		}
//		Matcher m = p.matcher(form.getCore());
//		if(!m.matches()){
//			errors.rejectValue("core", "", "core format is 1 to 99");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "core", "", "Can`t be empty");
	}
}
