package com.tinhpt.order.service;

import com.tinhpt.order.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class FileUpload implements IFileUpload {

    @Value("${file.upload.folder:/}")
    private String fileUploadFolder;

    @Override
    public String uploadFile(String username, MultipartFile file) {
        log.debug("Start uploading file: " + file.getName() + " for user: " + username);
        String fileUrl = saveUploadFile(username, Collections.singletonList(file)).get(0);
        log.debug("End uploading file: " + file.getName() + " for user: " + username);
        return fileUrl;
    }

    @Override
    public String uploadFiles(String username, List<MultipartFile> files) {
        return null;
    }

    private List<String> saveUploadFile(String username, List<MultipartFile> files) {
        List<String> filePaths = new ArrayList<>();
        files.forEach( file -> {
            try {
                File userDir = new File(fileUploadFolder, StringUtils.removeAccent(username));
                if (!userDir.exists()) userDir.mkdirs();
                Path path = Paths.get(userDir.getAbsolutePath(), file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                filePaths.add(path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return filePaths;
    }
}
