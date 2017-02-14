package ua.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Hdd;
import ua.entity.Processor;
import ua.entity.Ram;
import ua.entity.VideoAdapter;

public class KomputerForm {

	private int id;

	private Hdd hdd;

//	private OpticalDrive opticaldrive;

	private Ram ram;

	private VideoAdapter videoadapter;

	private Processor processor;

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

	public Hdd getHdd() {
		return hdd;
	}

	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public VideoAdapter getVideoadapter() {
		return videoadapter;
	}

	public void setVideoadapter(VideoAdapter videoadapter) {
		this.videoadapter = videoadapter;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

//	public void setPrice(int parseInt) {
//		this.price = Integer.parseInt(price);		
//	}


	
}
