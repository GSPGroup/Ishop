package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.TypeProcessor;
import ua.form.TypeProcessorForm;
import ua.form.filter.TypeProcessorFilterForm;


public interface TypeProcessorService {

	void save(TypeProcessorForm typeprocessor);

	TypeProcessor findByName(String name);

	void delete(String name);

	List<TypeProcessor> findAll();

	void delete(int id);
	
	TypeProcessorForm findOne(int id);

	TypeProcessor findOne1(int id);

	Page<TypeProcessor> findAll(Pageable pageable);

	Page<TypeProcessor> findAll(Pageable pageable, TypeProcessorFilterForm form);


}
