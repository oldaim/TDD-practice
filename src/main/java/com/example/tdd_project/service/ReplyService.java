package com.example.tdd_project.service;

import com.example.tdd_project.DTO.ReplyDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyService {
    @Transactional
    void save(ReplyDTO replyDTO);

    List<ReplyDTO> findByBoardNumber(Long number);
}
