package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.ÑoreProcessor;
import ua.form.ÑoreProcessorForm;
import ua.form.filter.ÑoreProcessorFilterForm;


public interface ÑoreProcessorService {

	void save(ÑoreProcessorForm coreprocessor);
	
	ÑoreProcessor findByName(String ramGb);

	void delete(String ramGb);


	List<ÑoreProcessor> findAll();

	void delete(int id);

	ÑoreProcessorForm findOne(int id);
	
	ÑoreProcessor findOne1(int id);
	

	Page<ÑoreProcessor> findAll(Pageable pageable);

	Page<ÑoreProcessor> findAll(Pageable pageable, ÑoreProcessorFilterForm form);


}
