package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.service.TypeHddService;

public class TypeHddEditor extends PropertyEditorSupport {

	private final TypeHddService typehddService;

	public TypeHddEditor(TypeHddService typehddService) {
		this.typehddService = typehddService;
	}

//	@Override
//	public void setAsText(String text) throws IllegalArgumentException {
//		TypeProcessor typeprocessor = typeprocessorService.findOne(Integer
//				.valueOf(text));
//		setValue(typeprocessor);
//	}
}