package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.TypeProcessor;
import ua.service.TypeProcessorService;

public class TypeProcessorEditor extends PropertyEditorSupport {

	private final TypeProcessorService typeprocessorService;

	public TypeProcessorEditor(TypeProcessorService typeprocessorService) {
		this.typeprocessorService = typeprocessorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		TypeProcessor typeprocessor = typeprocessorService.findOne1(Integer
				.valueOf(text));
		setValue(typeprocessor);
	}
}