package com.gowaiterless.api.file.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gowaiterless.api.exception.ImageNotFoundException;
import com.gowaiterless.api.exception.ResourceNotFoundException;

@Service
public class FileService {
	
	@Autowired
	ServletContext servletContext; 
	
	public String saveFile(String dir, MultipartFile uploadfile) {
		return saveFile(dir,null,uploadfile);
	}
	
	public String saveFile(String dir, String name, MultipartFile uploadfile) {
		return saveFile(dir,name,uploadfile,false);
	}

	public String saveFile(String dir, String name, MultipartFile uploadfile, boolean addExtension) {
		try {

            byte[] bytes = uploadfile.getBytes();
            if (name == null) name = getFilename(uploadfile.getOriginalFilename());
            else if (addExtension)
            	name = name + getExtension(uploadfile.getOriginalFilename());
            
            
            Path path = Paths.get(servletContext.getRealPath("/WEB-INF/"+dir + name));
            //save
            Files.write(path, bytes);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(e);
		}
 
	}
	
	
	public byte[] loadFile(String dir, String name) {

		InputStream stream =servletContext.getResourceAsStream("/WEB-INF/"+dir+name);
		if (stream == null) throw new ImageNotFoundException();
		try {
			return IOUtils.toByteArray(stream);
		} catch (IOException e) {
			throw new ImageNotFoundException(e);
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
	
	private static String getFilename(String filename) {
        if (filename == null) {
            return null;
        }
        //int extensionPos = filename.lastIndexOf('.');
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        int index = Math.max(lastUnixPos, lastWindowsPos);
        
        return filename.substring(index);
        
    }

}
