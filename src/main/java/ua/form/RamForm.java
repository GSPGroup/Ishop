package ua.form;

import org.springframework.web.multipart.MultipartFile;


public class RamForm {

	private int id;

	private String ramGb;
	
	private String path;
	
	private int version;
	
	private MultipartFile file;
	
	private String price;
	

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRamGb() {
		return ramGb;
	}

	public void setRamGb(String ramGb) {
		this.ramGb = ramGb;
	}




}
