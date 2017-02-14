package ua.service.implementation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Komputer;
import ua.form.KomputerForm;
import ua.form.filter.KomputerFilterForm;
import ua.repository.HddRepository;
import ua.repository.KomputerRepository;
import ua.repository.ProcessorRepository;
import ua.repository.RamRepository;
import ua.repository.VideoAdapterRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.KomputerService;
import ua.service.implementation.specification.KomputerFilterAdapter;

@Service
@Transactional
public class KomputerImpl implements KomputerService {
	
	@Autowired
	private FileWriter fileWriter;

	@Resource
	private KomputerRepository komputerRepository;
	
	@Autowired
	private HddRepository hddRepository;
	
	@Resource
	private ProcessorRepository processorRepository;
	
	@Autowired
	private RamRepository RamRepository;

	@Autowired
	private VideoAdapterRepository videoadapterRepository;

	@Override
	public void save(KomputerForm form) {
		Komputer entity = new Komputer();
		entity.setHdd((form.getHdd()));
		entity.setRam(form.getRam());
		entity.setVideoadapter(form.getVideoadapter());
		entity.setProcessor(form.getProcessor());
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setId(form.getId());
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setPath(form.getPath());
		entity.setVersion(form.getVersion());
		komputerRepository.saveAndFlush(entity);
		String extension = fileWriter.write(Folder.KOMPUTER, form.getFile(), entity.getId());
		if(extension!=null){
			entity.setVersion(form.getVersion()+1);
			entity.setPath(extension);
			komputerRepository.save(entity);
			}
	}

	@Override
	public List<Komputer> findAll() {
		return komputerRepository.findAll();
	}

	@Override
	public void delete(int id) {
		komputerRepository.delete(id);
	}

	@Override
	public Komputer findOne1(int id) {
		return komputerRepository.findOne(id);
	}

	@Override
	public Page<Komputer> findAll(Pageable pageable) {
		return komputerRepository.findAll(pageable);
	}


	@Override
	public Page<Komputer> findAll(Pageable pageable, KomputerFilterForm form) {
		return komputerRepository.findAll(new KomputerFilterAdapter(form), pageable);
	}


	@Override
	public Komputer findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public KomputerForm findOne(int id) {
		Komputer entity = komputerRepository.findOne(id);
		KomputerForm form = new KomputerForm();
		form.setHdd((entity.getHdd()));
		form.setRam(entity.getRam());
		form.setVideoadapter(entity.getVideoadapter());
		form.setProcessor(entity.getProcessor());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setId(entity.getId());
		form.setPath(entity.getPath());
		form.setVersion(entity.getVersion());
		return form;
	}
}
