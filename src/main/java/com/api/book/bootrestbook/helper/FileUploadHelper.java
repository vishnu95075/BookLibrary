package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	public final String UPLOAD_DIR="C:\\Raushan\\Code\\Spring Boot\\bootrestbook\\bootrestbook\\src\\main\\resources\\static\\image";

	public final String UPLOAD_DIR = new ClassPathResource("/static/image").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException {

	}

	public boolean uploadFile(MultipartFile multipart) {
		boolean f1 = false;
		try {
			System.out.println("UPLOAD_DIR1 "+UPLOAD_DIR);

//			InputStream is=multipart.getInputStream();
//			byte[] data = new byte[is.available()];
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipart.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();

			Files.copy(multipart.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipart.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f1 = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f1;

	}
}
