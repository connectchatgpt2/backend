package com.ishan.markdowneditor.controller;

import com.ishan.markdowneditor.entity.FileUpload;
import com.ishan.markdowneditor.service.IFileUploadService;
import com.ishan.markdowneditor.service.ILoginService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UploadDownloadController {
    ILoginService iLoginService;
    private IFileUploadService fileUploadService;

    @PostMapping(value = "/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        boolean isUploaded = fileUploadService.fileUpload(file);
        if (isUploaded) {
            return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
        } else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
    }

    @GetMapping("/download-file/{id}")
    public ResponseEntity<StreamingResponseBody> downloadFile(@PathVariable("id") Long id) throws IOException {
        FileUpload fileDetails = fileUploadService.getFile(id);
        Resource resource = fileUploadService.loadFileAsResource(fileDetails.getFilePath());

        StreamingResponseBody responseBody = outputStream -> {
            try (InputStream inputStream = resource.getInputStream()) {
                byte[] buffer = new byte[5 * 1024 * 1024]; // 5MB buffer
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        };

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDetails.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(responseBody);
    }
}