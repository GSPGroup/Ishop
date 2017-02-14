package ua.service.implementation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.RamForm;
import ua.service.RamServiñe;

public class RamValidator implements Validator {

	private final RamServiñe ramService;
	private static final Pattern p = Pattern.compile("^[0-9]{1,2}$");

	public RamValidator(RamServiñe ramService) {
		this.ramService = ramService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return RamForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RamForm form = (RamForm) target;
		if(form.getId()==0)if(ramService.findByName(form.getRamGb())!=null){
			errors.rejectValue("ramGb", "", "ÑoreProcessor already exists");
		}
		Matcher m = p.matcher(form.getRamGb());
		if(!m.matches()){
			errors.rejectValue("ramGb", "", "core format is 1 to 99");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ramGb", "", "Can`t be empty");
	}
}
