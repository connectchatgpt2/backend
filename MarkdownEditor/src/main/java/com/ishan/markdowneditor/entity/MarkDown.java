package com.ishan.markdowneditor.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MarkDown {

    @Id
    private String id;

    @Lob
    private String savedText;
}
