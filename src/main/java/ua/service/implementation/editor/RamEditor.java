package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Ram;
import ua.service.RamServi�e;

public class RamEditor extends PropertyEditorSupport {

	private final RamServi�e ramServi�e;

	public RamEditor(RamServi�e ramServi�e) {
		this.ramServi�e = ramServi�e;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Ram ram = ramServi�e.findOne1(Integer.valueOf(text));
		setValue(ram);
	}
}