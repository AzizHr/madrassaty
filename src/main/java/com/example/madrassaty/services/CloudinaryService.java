package com.example.madrassaty.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
