package com.cqu.waxxd.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyFileUpload {

	public static List<String> upload_images(
			MultipartFile[] files) {
		String path = MyPropertyUtil.getProperty("myUpload.properties","windows_path");
		
		List<String> list_images = new ArrayList<String>();
		for(int i = 0; i < files.length;i++ ) {
			
			if (!files[i].isEmpty()) {
				String originaFileName = files[i].getOriginalFilename();
				String name = System.currentTimeMillis() + originaFileName;
				String upload_name = path + "/" + name;
				try {
					files[i].transferTo(new File(upload_name));
					list_images.add(name);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		return list_images;
	}	
}
