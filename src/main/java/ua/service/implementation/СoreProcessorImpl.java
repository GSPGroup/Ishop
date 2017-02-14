package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.ÑoreProcessor;
import ua.form.ÑoreProcessorForm;
import ua.form.filter.ÑoreProcessorFilterForm;
import ua.repository.ÑoreProcessorRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.ÑoreProcessorService;
import ua.service.implementation.specification.ÑoreProcessorFilterAdapter;

@Service
@Transactional
public class ÑoreProcessorImpl implements ÑoreProcessorService {
	
	@Autowired
	private FileWriter fileWriter;

	@Autowired
	private ÑoreProcessorRepository coreprocessorRepository;

	@Override
	public void save(ÑoreProcessorForm form) {
		ÑoreProcessor entity = new ÑoreProcessor();
		entity.setCore(Integer.valueOf(form.getCore()));
		entity.setId(form.getId());
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setPath(form.getPath());
		entity.setVersion(form.getVersion());
		coreprocessorRepository.saveAndFlush(entity);
		String extension = fileWriter.write(Folder.ÑOREPPROCESSOR, form.getFile(), entity.getId());
		if(extension!=null){
			entity.setVersion(form.getVersion()+1);
			entity.setPath(extension);
			coreprocessorRepository.save(entity);
			}
	}


	@Override
	public List<ÑoreProcessor> findAll() {
		return coreprocessorRepository.findAll();
	}

	@Override
	public void delete(int id) {
		coreprocessorRepository.delete(id);
	}

	@Override
	public ÑoreProcessorForm findOne(int id) {
		ÑoreProcessor entity = coreprocessorRepository.findOne(id);
		ÑoreProcessorForm form = new ÑoreProcessorForm();
		form.setCore(String.valueOf(entity.getCore()));
		form.setId(entity.getId());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setPath(entity.getPath());
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public Page<ÑoreProcessor> findAll(Pageable pageable) {
		return coreprocessorRepository.findAll(pageable);
	}


	@Override
	public Page<ÑoreProcessor> findAll(Pageable pageable, ÑoreProcessorFilterForm form) {
		return coreprocessorRepository.findAll((new ÑoreProcessorFilterAdapter(form)), pageable);
	}

	@Override
	public ÑoreProcessor findOne1(int id) {
		return coreprocessorRepository.findOne(id);
	}

	@Override
	public ÑoreProcessor findByName(String ramGb) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(String ramGb) {
		// TODO Auto-generated method stub
		
	}

	

	
}