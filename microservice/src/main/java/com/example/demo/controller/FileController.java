package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.validation.metadata.MethodType;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	@RequestMapping(value ="/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	
	public String upload(@RequestParam ("file") MultipartFile file) {
		File f = new File ("File-Archives/" + file.getOriginalFilename());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fos.write(file.getBytes());
			fos.close();
			return "File Upload Success : " + f.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;	
	}
	
	@RequestMapping(value ="/download", method=RequestMethod.GET )
	public ResponseEntity<Object> download() throws FileNotFoundException {
		
		File f = new File("E:\\BBB-FEO\\SpringDemo\\microservice\\File-Archives\\GIT-HELP.txt");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(f));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", f.getName()));
		headers.add("cache-control", "no-cache, no-store, mustrevalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		
		ResponseEntity<Object> responseEntity =
				ResponseEntity.ok().headers(headers).contentLength(f.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
		return responseEntity;
	}
}
