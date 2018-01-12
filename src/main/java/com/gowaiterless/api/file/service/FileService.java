package com.gowaiterless.api.file.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gowaiterless.exception.ResourceNotFoundException;

@Service
public class FileService {

	public String saveFile(String dir, String name, MultipartFile uploadfile) {
		try {
            byte[] bytes = uploadfile.getBytes();
            name = name + getExtension(uploadfile.getOriginalFilename());
            //System.out.println(uploadfile.getName() + " " + getExtension(uploadfile.getName()));
            Path path = Paths.get(dir + name);
            Files.write(path, bytes);
			return name;
		} catch (IOException e) {
			//TODO
			throw new ResourceNotFoundException();
		}
 
	}
	
	
	
	private static String getExtension(String filename) {
        if (filename == null) {
            return null;
        }
        int extensionPos = filename.lastIndexOf('.');
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        int lastSeparator = Math.max(lastUnixPos, lastWindowsPos);

        int index = lastSeparator > extensionPos ? -1 : extensionPos;
        
        return index == -1 ? "" : filename.substring(index);
        
    }

}
