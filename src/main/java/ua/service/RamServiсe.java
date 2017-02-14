package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Ram;
import ua.form.RamForm;
import ua.form.filter.RamFilterForm;

public interface RamServiñe {
	
	void save(RamForm ramGb);

	Ram findByName(String ramGb);

	void delete(String ramGb);

	List<Ram> findAll();

	void delete(int id);
	
	RamForm findOne(int id);

	Ram findOne1(int id);

	Page<Ram> findAll(Pageable pageable);

	Page<Ram> findAll(Pageable pageable, RamFilterForm form);
}