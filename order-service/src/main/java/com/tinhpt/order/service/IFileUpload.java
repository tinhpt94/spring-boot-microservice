package com.tinhpt.order.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileUpload {
    String uploadFile(String username, MultipartFile file);
    String uploadFiles(String username, List<MultipartFile> files);
}
