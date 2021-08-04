package com.example.tdd_project.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDTO {

    private Long number;

    private String content;

    private String author;

}
