package com.example.tdd_project.service;

import com.example.tdd_project.DTO.ReplyDTO;
import com.example.tdd_project.entity.Reply;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyService {
    @Transactional
    void save(ReplyDTO replyDTO);

    List<ReplyDTO> findByBoardNumber(Long number);

    void deleteAll(Long number);

    Reply read(long l);

    void delete(Long random_number);
}
