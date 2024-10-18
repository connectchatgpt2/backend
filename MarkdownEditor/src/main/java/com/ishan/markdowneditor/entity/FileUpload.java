package com.ishan.markdowneditor.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FileUpload {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 1L;

/*    private String fileName;

    @Lob
    private byte[] data;*/
    private String fileName;

    private String filePath;

}