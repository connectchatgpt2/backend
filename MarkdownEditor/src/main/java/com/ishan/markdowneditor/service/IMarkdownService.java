package com.ishan.markdowneditor.service;

public interface IMarkdownService {
    void saveText(String receivedText);

    String getText();
}
