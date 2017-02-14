package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.�oreProcessor;
import ua.service.�oreProcessorService;

public class �oreProcessorEditor extends PropertyEditorSupport {

	private final �oreProcessorService coreprocessorService;

	public �oreProcessorEditor(�oreProcessorService coreprocessorService) {
		this.coreprocessorService = coreprocessorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		�oreProcessor coreprocessor = coreprocessorService.findOne1(Integer.valueOf(text));
		setValue(coreprocessor);
	}
}