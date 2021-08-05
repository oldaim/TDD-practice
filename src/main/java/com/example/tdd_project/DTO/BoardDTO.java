package com.example.tdd_project.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private Long number;

    private String content;

    private String author;

}
