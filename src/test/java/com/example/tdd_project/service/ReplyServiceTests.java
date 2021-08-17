package com.example.tdd_project.service;

import com.example.tdd_project.DTO.ReplyDTO;
import com.example.tdd_project.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Random;

@SpringBootTest
public class ReplyServiceTests {
    @Autowired
    ReplyService replyService;

    @Autowired
    BoardService boardService;

    @Test
    public void 더미_데이터_생성()
    {

        Random random = new Random();

        for(Long i = Long.valueOf(1); i <= 300L; i++)
        {
          Long random_number = Long.valueOf(random.nextInt(230) + 1);

          Optional<Board> dummy_board = boardService.read(random_number);

          if(dummy_board.isPresent())
          {
             ReplyDTO replyDTO = ReplyDTO.builder().boardNumber(dummy_board.get().getNumber()).text(i+"...test_reply").build();

             replyService.save(replyDTO);
          }
        }
    }



   @Test
    public void 댓글_등록()
    {
        Optional<Board> board_test= boardService.read(85L);

        ReplyDTO replyDTO = ReplyDTO.builder().boardNumber(board_test.get().getNumber()).text("test_reply").build();

        replyService.save(replyDTO);

    }


    @Test
    public void 댓글_조회()
    {
        Long replyNumber = 15L;

        replyService.read(3L);

    }



    @Test
    public void 게시물의_모든_댓글_조회()
    {


        Long random_number = 85L;

        Optional<Board> board_test= boardService.read(random_number);

        if(board_test.isPresent()){

          replyService.findByBoardNumber(board_test.get().getNumber());


        }
    }

    @Test
    public void 댓글_단독_삭제()
    {
        Long random_number = 85L;

        replyService.delete(random_number);
    }



}
