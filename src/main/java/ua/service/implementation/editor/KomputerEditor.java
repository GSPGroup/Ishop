//package ua.service.implementation.editor;
//
//import java.beans.PropertyEditorSupport;
//
//import ua.entity.Komputer;
//import ua.service.KomputerService;
//
//public class KomputerEditor extends PropertyEditorSupport {
//
//	private final KomputerService komputerServi�e;
//
//	public KomputerEditor(KomputerService komputerServi�e) {
//		this.komputerServi�e = komputerServi�e;
//	}
//
//	@Override
//	public void setAsText(String text) throws IllegalArgumentException {
//		Komputer komp = komputerServi�e.findOne1(Integer.valueOf(text));
//		System.out.println(komp);
//		System.out.println(komp.toString());
//		setValue(komp);
//	}
//}