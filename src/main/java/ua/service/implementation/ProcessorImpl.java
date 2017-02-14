package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Processor;
import ua.form.ProcessorForm;
import ua.form.filter.ProcessorFilterForm;
import ua.repository.ProcessorRepository;
import ua.repository.TypeProcessorRepository;
import ua.repository.ÑoreProcessorRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.ProcessorService;
import ua.service.implementation.specification.ProcessorFilterAdapter;

@Service
@Transactional
public class ProcessorImpl implements ProcessorService {
	
	@Autowired
	private FileWriter fileWriter;

	@Autowired
	private ProcessorRepository processorRepository;
	
	@Autowired
	private ÑoreProcessorRepository coreprocessorRepository;
	
	@Autowired
	private TypeProcessorRepository typeprocessorRepository;

	@Override
	public void save(ProcessorForm form) {
		Processor entity = new Processor();
		entity.setId(form.getId());
		entity.setTypeprocessor(form.getTypeprocessor());
		entity.setCoreprocessor(form.getCoreprocessor());
		entity.setName(form.getTypeprocessor().getName()+" "+ form.getCoreprocessor().getCore()+" cores ");
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setPath(form.getPath());
		entity.setVersion(form.getVersion());
		processorRepository.saveAndFlush(entity);
		String extension = fileWriter.write(Folder.PROC, form.getFile(), entity.getId());
		if(extension!=null){
			entity.setVersion(form.getVersion()+1);
			entity.setPath(extension);
			processorRepository.save(entity);
			}
	}

	@Override
	public List<Processor> findAll() {
		return processorRepository.findAll();
	}

	@Override
	public void delete(int id) {
		processorRepository.delete(id);
	}

	@Override
	public ProcessorForm findOne(int id) {
		Processor entity = processorRepository.findOne(id);
		ProcessorForm form = new ProcessorForm();
		form.setId(entity.getId());
		form.setTypeprocessor(entity.getTypeprocessor());
		form.setCoreprocessor(entity.getCoreprocessor());
		form.setName(entity.getName());
		form.setId(entity.getId());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setPath(entity.getPath());
		form.setVersion(entity.getVersion());
		return form;
	}

	@Override
	public Page<Processor> findAll(Pageable pageable) {
		return processorRepository.findAll(pageable);
	}


	@Override
	public Page<Processor> findAll(Pageable pageable, ProcessorFilterForm form) {
		return processorRepository.findAll(new ProcessorFilterAdapter(form), pageable);
	}


	@Override
	public Processor findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Processor findOne1(int id) {
		return processorRepository.findOne(id);
	}

}