package com.example.tdd_project.DTO;

import com.example.tdd_project.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDTO {
    private Long ReplyNumber;

    private Board board;

    private String text;
}
