package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.ÑoreProcessor;
import ua.service.ÑoreProcessorService;

public class ÑoreProcessorEditor extends PropertyEditorSupport {

	private final ÑoreProcessorService coreprocessorService;

	public ÑoreProcessorEditor(ÑoreProcessorService coreprocessorService) {
		this.coreprocessorService = coreprocessorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ÑoreProcessor coreprocessor = coreprocessorService.findOne1(Integer.valueOf(text));
		setValue(coreprocessor);
	}
}