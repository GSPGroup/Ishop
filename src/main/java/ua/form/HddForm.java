package ua.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.TypeHdd;

public class HddForm {

	private int id;

	private TypeHdd typeHdd;

	private String hddGb;
	
private String price;
	
	private int version;
	
	private String path;
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeHdd getTypeHdd() {
		return typeHdd;
	}

	public void setTypeHdd(TypeHdd typeHdd) {
		this.typeHdd = typeHdd;
	}

	public String getHddGb() {
		return hddGb;
	}

	public void setHddGb(String hddGb) {
		this.hddGb = hddGb;
	}

}
