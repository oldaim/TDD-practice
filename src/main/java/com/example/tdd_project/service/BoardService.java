package com.example.tdd_project.service;

import com.example.tdd_project.DTO.BoardDTO;

public interface BoardService {
    void save(BoardDTO dto);

    void read(BoardDTO dto);

    void modify(BoardDTO dto);

    void delete(Long number);
}
