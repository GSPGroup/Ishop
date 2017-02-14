package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Processor;
import ua.service.ProcessorService;

public class ProcessorEditor extends PropertyEditorSupport {

	private final ProcessorService processorService;

	public ProcessorEditor(ProcessorService processorService) {
		this.processorService = processorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Processor processor = processorService.findOne1(Integer.valueOf(text));
		setValue(processor);
	}
}