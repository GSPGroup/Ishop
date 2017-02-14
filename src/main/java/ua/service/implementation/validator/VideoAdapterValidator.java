package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.VideoAdapterForm;
import ua.service.VideoAdapterService;

public class VideoAdapterValidator implements Validator {

	private final VideoAdapterService videoadapterService;
//	private static final Pattern p = Pattern.compile("^[a-z]{1,15}$");

	public VideoAdapterValidator(VideoAdapterService videoadapterService) {
		this.videoadapterService = videoadapterService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return VideoAdapterForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		VideoAdapterForm form = (VideoAdapterForm) target;
		if (form.getId() == 0)
			if (videoadapterService.findByName(form.getName()) != null) {
				errors.rejectValue("name", "", "VideoAdapter already exists");
			}
//		Matcher m = p.matcher(form.getName());
//		if(!m.matches()){
//			errors.rejectValue("name", "", "name format is a-z ");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can`t be empty");
	}
}
