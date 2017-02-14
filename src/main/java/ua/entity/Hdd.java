package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes = { @Index(columnList = "hddGb") })
public class Hdd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private TypeHdd typeHdd;

	private int hddGb;

	public TypeHdd getTypeHdd() {
		return typeHdd;
	}
	
private int price;
	
	private int version;
	
	private String path;
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	public Hdd(int id, TypeHdd typeHdd, int hddGb, List<Komputer> komputers) {
		super();
		this.id = id;
		this.typeHdd = typeHdd;
		this.hddGb = hddGb;
		this.komputers = komputers;
	}

	public Hdd() {
		super();
	}

	public void setTypeHdd(TypeHdd typeHdd) {
		this.typeHdd = typeHdd;
	}

	public Hdd(int hdd) {
		this.hddGb = hdd;
	}

	public List<Komputer> getKomputers() {
		return komputers;
	}

	public void setKomputers(List<Komputer> komputers) {
		this.komputers = komputers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHddGb() {
		return hddGb;
	}

	public void setHddGb(int hddGb) {
		this.hddGb = hddGb;
	}

	@OneToMany(mappedBy = "hdd")
	private List<Komputer> komputers = new ArrayList<Komputer>();

}
