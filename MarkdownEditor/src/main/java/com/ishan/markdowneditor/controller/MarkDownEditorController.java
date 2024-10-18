package com.ishan.markdowneditor.controller;

import com.ishan.markdowneditor.constants.Constants;
import com.ishan.markdowneditor.dto.ResponseDto;
import com.ishan.markdowneditor.entity.FileUpload;
import com.ishan.markdowneditor.service.IFileUploadService;
import com.ishan.markdowneditor.service.IMarkdownService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")

@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MarkDownEditorController {

    private IMarkdownService markdownService;
    private IFileUploadService fileUploadService;


    @PostMapping("/save-text")
    public ResponseEntity<ResponseDto> saveText(@RequestBody Map<String,String> payload) {
        String receivedText = payload.get("content");
        markdownService.saveText(receivedText);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(Constants.STATUS_201, "Text saved successfully"));
    }

    @GetMapping("/load-text")
    public ResponseEntity<String> loadText() {
        String fetchedText = markdownService.getText();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fetchedText);
    }


}
