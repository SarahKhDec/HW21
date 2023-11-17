package org.example.HW21.utils;

import org.example.HW21.exceptions.file.BigFileException;
import org.example.HW21.exceptions.file.FileNotFoundException;
import org.example.HW21.exceptions.file.FileNotJPGException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@Component
public class ConvertUrlToByteArray {

    public byte[] converter(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new FileNotFoundException("no files found at the requested url");
        }
        if (!file.getOriginalFilename().endsWith(".JPG")){
            throw new FileNotJPGException("the photo format is not JPG.");
        }
        if (file.getSize() > 307200) {
            throw new BigFileException("the size of the photo is more than 300 kb.");
        }
        return file.getBytes();
    }
}
