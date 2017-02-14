package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.form.KomputerForm;
import ua.service.KomputerService;

public class KomputerValidator implements Validator {

	private final KomputerService komputerService;
//	private static final Pattern p = Pattern.compile("^[a-z]{1,15}$");

	public KomputerValidator(KomputerService komputerService) {
		this.komputerService = komputerService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return KomputerForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		KomputerForm form = (KomputerForm) target;
//		if(form.getId()==0)if(processorService.findByName(form.getName())!=null){
//			errors.rejectValue("name", "", "Processor already exists");
//		}
//		Matcher m = p.matcher(form.getName());
//		if(!m.matches()){
//			errors.rejectValue("name", "", "name format is a-z ");
//		}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
	}
}
