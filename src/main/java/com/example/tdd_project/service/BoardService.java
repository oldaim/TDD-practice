package com.example.tdd_project.service;

import com.example.tdd_project.DTO.BoardDTO;
import com.example.tdd_project.entity.Board;

import java.util.Optional;

public interface BoardService {
    void save(BoardDTO dto);

    Optional<Board> read(Long number);

    void modify(BoardDTO dto);

    void delete(Long number);
}
