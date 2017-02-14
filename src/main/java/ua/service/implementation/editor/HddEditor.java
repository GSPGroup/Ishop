package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Hdd;
import ua.service.HddService;

public class HddEditor extends PropertyEditorSupport {

	private final HddService hddGbService;

	public HddEditor(HddService hddGbService) {
		this.hddGbService = hddGbService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Hdd hddGb = hddGbService.findOne1(Integer
				.valueOf(text));
		setValue(hddGb);
	}
}