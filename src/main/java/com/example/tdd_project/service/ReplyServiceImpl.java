package com.example.tdd_project.service;

import com.example.tdd_project.DTO.ReplyDTO;
import com.example.tdd_project.entity.Board;
import com.example.tdd_project.entity.Reply;
import com.example.tdd_project.repository.BoardRepository;
import com.example.tdd_project.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void save(ReplyDTO replyDTO) {
        Optional<Board> result = boardRepository.findById(replyDTO.getBoardNumber());

        if(result.isPresent())
        {
            Board b = result.get();

            Reply reply = Reply.builder().board(b).text(replyDTO.getText()).build();

            replyRepository.save(reply);
        }


    }

    @Override
    public Reply read(long replyNumber) {
       Optional<Reply> result = replyRepository.findById(replyNumber);

       if(result.isPresent())
       {
           Reply reply = result.get();

           return reply;
       }

       return null;
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
                   .boardNumber(replyList.get(i).getBoard().getNumber())
                   .text(replyList.get(i).getText())
                   .build();

           dtoList.add(replyDTO);
        }

        log.info(dtoList);

        return dtoList;
    }

    @Override
    public void delete(Long random_number) {
        replyRepository.deleteById(random_number);
    }

    @Override
    public void deleteAll(Long number) {
        List<Reply> replyList = replyRepository.findAllByBoardNumber(number);

        replyRepository.deleteAll(replyList);
    }
}
