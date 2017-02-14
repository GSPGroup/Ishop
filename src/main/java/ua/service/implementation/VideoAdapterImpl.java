package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.VideoAdapter;
import ua.form.VideoAdapterForm;
import ua.form.filter.VideoAdapterFilterForm;
import ua.repository.VideoAdapterRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.VideoAdapterService;
import ua.service.implementation.specification.VideoAdapterFilterAdapter;

@Service
@Transactional
public class VideoAdapterImpl implements VideoAdapterService {
	
	@Autowired
	private FileWriter fileWriter;

	@Autowired
	private VideoAdapterRepository videoadapterRepository;

	@Override
	public void save(VideoAdapterForm form) {
		VideoAdapter entity = new VideoAdapter();
		entity.setName(form.getName());
		entity.setId(form.getId());
		entity.setPrice(Integer.valueOf(form.getPrice()));
		entity.setPath(form.getPath());
		entity.setVersion(form.getVersion());
		videoadapterRepository.saveAndFlush(entity);
		String extension = fileWriter.write(Folder.VIDEOADAPTER, form.getFile(), entity.getId());
		if(extension!=null){
			entity.setVersion(form.getVersion()+1);
			entity.setPath(extension);
			videoadapterRepository.save(entity);
			}
	}
	
	@Override
	public VideoAdapter findByName(String name) {
		return videoadapterRepository.findByName(name);
	}

	@Override
	public void delete(String name) {
		videoadapterRepository.delete(name);
	}

	@Override
	public List<VideoAdapter> findAll() {
		return videoadapterRepository.findAll();
	}

	@Override
	public void delete(int id) {
		videoadapterRepository.delete(id);
	}

	@Override
	public VideoAdapter findOne1(int id) {
		return videoadapterRepository.findOne(id);
	}

	@Override
	public Page<VideoAdapter> findAll(Pageable pageable) {
		return videoadapterRepository.findAll(pageable);
	}


	@Override
	public Page<VideoAdapter> findAll(Pageable pageable, VideoAdapterFilterForm form) {
		return videoadapterRepository.findAll(new VideoAdapterFilterAdapter(form), pageable);
	}

	@Override
	public VideoAdapterForm findOne(int id) {
		VideoAdapter entity = videoadapterRepository.findOne(id);
		VideoAdapterForm form = new VideoAdapterForm();
		form.setName(entity.getName());
		form.setId(entity.getId());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setPath(entity.getPath());
		form.setVersion(entity.getVersion());
		return form;
	}
}