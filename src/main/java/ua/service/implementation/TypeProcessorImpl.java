package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.TypeProcessor;
import ua.form.TypeProcessorForm;
import ua.form.filter.TypeProcessorFilterForm;
import ua.repository.TypeProcessorRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.TypeProcessorService;
import ua.service.implementation.specification.TypeProcessorFilterAdapter;

@Service
@Transactional
public class TypeProcessorImpl implements TypeProcessorService {
	
	@Autowired
	private FileWriter fileWriter;

	@Autowired
	private TypeProcessorRepository typeprocessorRepository;

	@Override
	public void save(TypeProcessorForm form) {
		TypeProcessor entity = new TypeProcessor();
		entity.setName(form.getName());
		entity.setId(form.getId());
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setPath(form.getPath());
		entity.setVersion(form.getVersion());
		typeprocessorRepository.saveAndFlush(entity);
		String extension = fileWriter.write(Folder.TYPEPROCESSOR, form.getFile(), entity.getId());
		if(extension!=null){
			entity.setVersion(form.getVersion()+1);
			entity.setPath(extension);
			typeprocessorRepository.save(entity);
			}
	}

	@Override
	public TypeProcessor findByName(String name) {
		return typeprocessorRepository.findByName(name);
	}

	@Override
	public void delete(String name) {
		typeprocessorRepository.delete(name);
	}

	@Override
	public List<TypeProcessor> findAll() {
		return typeprocessorRepository.findAll();
	}

	@Override
	public void delete(int id) {
		typeprocessorRepository.delete(id);
	}

	@Override
	public TypeProcessor findOne1(int id) {
		return typeprocessorRepository.findOne(id);
	}

	@Override
	public Page<TypeProcessor> findAll(Pageable pageable) {
		return typeprocessorRepository.findAll(pageable);
	}


	@Override
	public Page<TypeProcessor> findAll(Pageable pageable, TypeProcessorFilterForm form) {
		return typeprocessorRepository.findAll(new TypeProcessorFilterAdapter(form), pageable);
	}


	@Override
	public TypeProcessorForm findOne(int id) {
		TypeProcessor entity = typeprocessorRepository.findOne(id);
		TypeProcessorForm form = new TypeProcessorForm();
		form.setName(entity.getName());
		form.setId(entity.getId());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setPath(entity.getPath());
		form.setVersion(entity.getVersion());
		return form;
	}

}