package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.HddForm;
import ua.service.HddService;

public class HddValidator implements Validator {

	private final HddService hddGbService;
//	private static final Pattern p = Pattern.compile("^[0-9]{1,4}$");

	public HddValidator(HddService hddGbService) {
		this.hddGbService = hddGbService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return HddForm.class.equals(clazz);
	}
	
	

	@Override
	public void validate(Object target, Errors errors) {
		HddForm form = (HddForm) target;
		if(form.getId()==0)if(hddGbService.findByName(form.getHddGb())!=null){
			errors.rejectValue("hddGb", "", "Hdd already exists");
		}
//		Matcher m = p.matcher(form.getHddGb());
//		if(!m.matches()){
//			errors.rejectValue("hddGb", "", "hddGb format is 1 to 99");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hddGb", "", "Can`t be empty");
	}
}
