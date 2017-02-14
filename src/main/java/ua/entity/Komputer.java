package ua.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Komputer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Hdd hdd;

	private OpticalDrive opticaldrive;

	@ManyToOne(fetch = FetchType.LAZY)
	private Ram ram;

	@ManyToOne(fetch = FetchType.LAZY)
	private VideoAdapter videoadapter;

	@ManyToOne(fetch = FetchType.LAZY)
	private Processor processor;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Orders order;
	

	private int price;

	private int version;

	private String path;
	
	

//	public Orders getOrder() {
//		return order;
//	}
//
//	public void setOrder(Orders order) {
//		this.order = order;
//	}

	public int getPrice() {
		return price;
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

	public void setPrice(int price) {
		this.price = price;
	}

	public Komputer() {
		super();
	}

	public Komputer(int id, Hdd hdd, Ram ram, VideoAdapter videoadapter,
			Processor processor, int price) {
		super();
		this.id = id;
		this.hdd = hdd;
		this.ram = ram;
		this.videoadapter = videoadapter;
		this.processor = processor;
		this.price = price;
	}

	public Komputer(int id, Hdd hdd, OpticalDrive opticaldrive, Ram ram,
			VideoAdapter videoadapter, Processor processor,
			List<User> komputers, int price) {
		super();
		this.id = id;
		this.hdd = hdd;
		this.opticaldrive = opticaldrive;
		this.ram = ram;
		this.videoadapter = videoadapter;
		this.processor = processor;
		// this.komputers = komputers;
		this.price = price;
	}

	public Komputer(Hdd hdd, Ram ram, VideoAdapter videoadapter,
			Processor processor) {
		super();
		this.hdd = hdd;
		this.ram = ram;
		this.videoadapter = videoadapter;
		this.processor = processor;
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

	public OpticalDrive getOpticaldrive() {
		return opticaldrive;
	}

	public void setOpticaldrive(OpticalDrive opticaldrive) {
		this.opticaldrive = opticaldrive;
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

	//
	// public List<User> getKomputers() {
	// return komputers;
	// }
	//
	// public void setKomputers(List<User> komputers) {
	// this.komputers = komputers;
	// }

	

	// public void setPrice(String valueOf) {
	//
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Komputer other = (Komputer) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
