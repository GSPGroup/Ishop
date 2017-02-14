package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Ram;
import ua.service.RamServiñe;

public class RamEditor extends PropertyEditorSupport {

	private final RamServiñe ramServiñe;

	public RamEditor(RamServiñe ramServiñe) {
		this.ramServiñe = ramServiñe;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Ram ram = ramServiñe.findOne1(Integer.valueOf(text));
		setValue(ram);
	}
}