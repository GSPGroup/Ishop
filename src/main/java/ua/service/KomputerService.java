package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Komputer;
import ua.form.KomputerForm;
import ua.form.filter.KomputerFilterForm;

public interface KomputerService {

	void save(KomputerForm komputer);

	Komputer findByName(String name);

	void delete(String name);

	List<Komputer> findAll();

	void delete(int id);

	Komputer findOne1(int id);
	
	KomputerForm findOne(int id);

	Page<Komputer> findAll(Pageable pageable);

	Page<Komputer> findAll(Pageable pageable, KomputerFilterForm form);

}
