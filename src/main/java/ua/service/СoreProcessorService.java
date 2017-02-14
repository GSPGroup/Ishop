package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.�oreProcessor;
import ua.form.�oreProcessorForm;
import ua.form.filter.�oreProcessorFilterForm;


public interface �oreProcessorService {

	void save(�oreProcessorForm coreprocessor);
	
	�oreProcessor findByName(String ramGb);

	void delete(String ramGb);


	List<�oreProcessor> findAll();

	void delete(int id);

	�oreProcessorForm findOne(int id);
	
	�oreProcessor findOne1(int id);
	

	Page<�oreProcessor> findAll(Pageable pageable);

	Page<�oreProcessor> findAll(Pageable pageable, �oreProcessorFilterForm form);


}
