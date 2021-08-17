package com.example.tdd_project.service;

import com.example.tdd_project.DTO.ReplyDTO;
import com.example.tdd_project.entity.Reply;
import com.example.tdd_project.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyRepository replyRepository;

    @Override
    public void save(ReplyDTO replyDTO) {
       Reply reply = Reply.builder().board(replyDTO.getBoard()).text(replyDTO.getText()).build();

       replyRepository.save(reply);
    }

    @Override
    @Transactional
    public List<ReplyDTO> findByBoardNumber(Long number){

        List<Reply> replyList = replyRepository.findAllByBoardNumber(number);

        ArrayList<ReplyDTO> dtoList = new ArrayList<>();
        for(int i = 0; i < replyList.size(); i++ )
        {
           ReplyDTO replyDTO = ReplyDTO.builder()
                   .ReplyNumber(replyList.get(i).getReplyNumber())
                   .board(replyList.get(i).getBoard())
                   .text(replyList.get(i).getText())
                   .build();

           dtoList.add(replyDTO);
        }

        log.info(dtoList);

        return dtoList;
    }
}
