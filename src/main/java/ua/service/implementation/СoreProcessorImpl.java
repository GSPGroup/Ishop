package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.�oreProcessor;
import ua.form.�oreProcessorForm;
import ua.form.filter.�oreProcessorFilterForm;
import ua.repository.�oreProcessorRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.�oreProcessorService;
import ua.service.implementation.specification.�oreProcessorFilterAdapter;

@Service
@Transactional
public class �oreProcessorImpl implements �oreProcessorService {
	
	@Autowired
	private FileWriter fileWriter;

	@Autowired
	private �oreProcessorRepository coreprocessorRepository;

	@Override
	public void save(�oreProcessorForm form) {
		�oreProcessor entity = new �oreProcessor();
		entity.setCore(Integer.valueOf(form.getCore()));
		entity.setId(form.getId());
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setPath(form.getPath());
		entity.setVersion(form.getVersion());
		coreprocessorRepository.saveAndFlush(entity);
		String extension = fileWriter.write(Folder.�OREPPROCESSOR, form.getFile(), entity.getId());
		if(extension!=null){
			entity.setVersion(form.getVersion()+1);
			entity.setPath(extension);
			coreprocessorRepository.save(entity);
			}
	}


	@Override
	public List<�oreProcessor> findAll() {
		return coreprocessorRepository.findAll();
	}

	@Override
	public void delete(int id) {
		coreprocessorRepository.delete(id);
	}

	@Override
	public �oreProcessorForm findOne(int id) {
		�oreProcessor entity = coreprocessorRepository.findOne(id);
		�oreProcessorForm form = new �oreProcessorForm();
		form.setCore(String.valueOf(entity.getCore()));
		form.setId(entity.getId());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setPath(entity.getPath());
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public Page<�oreProcessor> findAll(Pageable pageable) {
		return coreprocessorRepository.findAll(pageable);
	}


	@Override
	public Page<�oreProcessor> findAll(Pageable pageable, �oreProcessorFilterForm form) {
		return coreprocessorRepository.findAll((new �oreProcessorFilterAdapter(form)), pageable);
	}

	@Override
	public �oreProcessor findOne1(int id) {
		return coreprocessorRepository.findOne(id);
	}

	@Override
	public �oreProcessor findByName(String ramGb) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(String ramGb) {
		// TODO Auto-generated method stub
		
	}

	

	
}