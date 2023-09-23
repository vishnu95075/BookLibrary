package com.api.book.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		return ResponseEntity.ok("Working");

		try {
//			System.out.println(file.getOriginalFilename());
//			System.out.println(file.getSize());
//			System.out.println(file.getContentType());
//			System.out.println(file.getName());
//			System.out.println(file.hashCode());
			
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Empty");
			}

			if(!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Content JPG File");
			}

			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
				return ResponseEntity.ok("Working");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().body("Somthing Went Wrong");

	}
}
