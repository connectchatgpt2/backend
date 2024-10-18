package com.ishan.markdowneditor.service;

import com.ishan.markdowneditor.entity.FileUpload;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;

public interface IFileUploadService {

    boolean fileUpload(MultipartFile file) throws Exception;

    FileUpload getFile(Long id) throws IOException;

    Resource loadFileAsResource(String filePath);
}
