package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Processor;
import ua.form.ProcessorForm;
import ua.form.filter.ProcessorFilterForm;


public interface ProcessorService {

	void save(ProcessorForm processor);

	Processor findByName(String name);

	void delete(String name);

	List<Processor> findAll();

	void delete(int id);
	
	ProcessorForm findOne(int id);

	Processor findOne1(int id);

	Page<Processor> findAll(Pageable pageable);

	Page<Processor> findAll(Pageable pageable, ProcessorFilterForm form);


}
