package ua.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	enum Folder{
		ÑOREPPROCESSOR, TYPEPROCESSOR, RAM, HDD, KOMPUTER, PROC, VIDEOADAPTER ;
	}
	
	String write(Folder folder, MultipartFile file, int id);
}
