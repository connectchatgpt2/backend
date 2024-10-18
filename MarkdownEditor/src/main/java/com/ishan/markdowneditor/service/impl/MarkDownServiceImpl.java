package com.ishan.markdowneditor.service.impl;

import com.ishan.markdowneditor.entity.MarkDown;
import com.ishan.markdowneditor.repository.MarkDownRepository;
import com.ishan.markdowneditor.service.IMarkdownService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarkDownServiceImpl implements IMarkdownService {
    private MarkDownRepository markDownRepository;
    @Override
    public void saveText(String receivedText) {
        if(null!=receivedText || !receivedText.isEmpty()) {
            markDownRepository.save(new MarkDown("1", receivedText));
            System.out.println("Received Text: " + receivedText);
        }
        else {
            System.out.println("Invalid Text: " + receivedText);
            ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Invalid Text");
        }

    }

    @Override
    public String getText() {
        String savedText = markDownRepository.findById("1").get().getSavedText();
        System.out.println("Fetched Text: " + savedText);
        return savedText;
    }
}
