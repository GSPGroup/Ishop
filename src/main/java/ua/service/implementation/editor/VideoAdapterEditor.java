package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.VideoAdapter;
import ua.service.VideoAdapterService;

public class VideoAdapterEditor extends PropertyEditorSupport {

	private final VideoAdapterService videoadapterService;

	public VideoAdapterEditor(VideoAdapterService videoadapterService) {
		this.videoadapterService = videoadapterService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		VideoAdapter videoadapter = videoadapterService.findOne1(Integer.valueOf(text));
		setValue(videoadapter);
	}
}