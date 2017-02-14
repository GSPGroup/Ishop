package ua.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.TypeProcessor;
import ua.entity.ÑoreProcessor;

public class ProcessorForm {

	private int id;

	private ÑoreProcessor coreprocessor;

	private TypeProcessor typeprocessor;

	private String name;

	private String price;

	private int version;

	private String path;

	private MultipartFile file;
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ÑoreProcessor getCoreprocessor() {
		return coreprocessor;
	}

	public void setCoreprocessor(ÑoreProcessor coreprocessor) {
		this.coreprocessor = coreprocessor;
	}

	public TypeProcessor getTypeprocessor() {
		return typeprocessor;
	}

	public void setTypeprocessor(TypeProcessor typeprocessor) {
		this.typeprocessor = typeprocessor;
	}

	public String getName(ÑoreProcessor coreprocessor,
			TypeProcessor typeprocessor) {
		return name = typeprocessor.getName() + ", "
				+ Integer.toString(coreprocessor.getCore()) + " core ";
	}

	public void setName(ÑoreProcessor coreprocessor, TypeProcessor typeprocessor) {

		this.name = typeprocessor.getName() + ", "
				+ Integer.toString(coreprocessor.getCore()) + " core ";
	}

}
