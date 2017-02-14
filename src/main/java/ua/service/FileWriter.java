package ua.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	enum Folder{
		�OREPPROCESSOR, TYPEPROCESSOR, RAM, HDD, KOMPUTER, PROC, VIDEOADAPTER ;
	}
	
	String write(Folder folder, MultipartFile file, int id);
}
