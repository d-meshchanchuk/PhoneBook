package com.myproject.phonebook.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImgStorageService {

    void uploadFile(MultipartFile file);

    void delete();

}
