package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Ram;
import ua.form.RamForm;
import ua.form.filter.RamFilterForm;
import ua.repository.RamRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.RamServiñe;
import ua.service.implementation.specification.RamFilterAdapter;

@Service
@Transactional
public class RamImpl implements RamServiñe {

	@Autowired
	private RamRepository ramGbRepository;
	
	@Autowired
	private FileWriter fileWriter;

	

//	@Override
//	public Ram findByName(String ramGb) {
//		return ramGbRepository.findByName(ramGb);
//	}
//
//	@Override
//	public void delete(String ramGb) {
//		ramGbRepository.delete(ramGb);
//	}

	@Override
	public List<Ram> findAll() {
		return ramGbRepository.findAll();
	}

	@Override
	public void delete(int id) {
		ramGbRepository.delete(id);
	}

	@Override
	public Ram findOne1(int id) {
		return ramGbRepository.findOne(id);
	}

	@Override
	public Page<Ram> findAll(Pageable pageable) {
		return ramGbRepository.findAll(pageable);
	}


	@Override
	public Page<Ram> findAll(Pageable pageable, RamFilterForm form) {
		return ramGbRepository.findAll(new RamFilterAdapter(form), pageable);
	}

	@Override
	public Ram findByName(String ramGb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String ramGb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(RamForm form) {
		Ram entity = new Ram();
		entity.setRamGb(Integer.valueOf(form.getRamGb()));
		entity.setId(form.getId());
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setPath(form.getPath());
		entity.setVersion(form.getVersion());
		ramGbRepository.saveAndFlush(entity);
		String extension = fileWriter.write(Folder.RAM, form.getFile(), entity.getId());
		if(extension!=null){
			entity.setVersion(form.getVersion()+1);
			entity.setPath(extension);
			ramGbRepository.save(entity);
			}
	}
	
	

	@Override
	public RamForm findOne(int id) {
		Ram entity = ramGbRepository.findOne(id);
		RamForm form = new RamForm();
		form.setRamGb(String.valueOf(entity.getRamGb()));
		form.setId(entity.getId());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setPath(entity.getPath());
		form.setVersion(entity.getVersion());
		return form;
	}

}