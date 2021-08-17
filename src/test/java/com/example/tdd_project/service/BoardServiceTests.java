package com.example.tdd_project.service;


import com.example.tdd_project.DTO.BoardDTO;
import com.example.tdd_project.entity.Board;
import com.example.tdd_project.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.rules.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    BoardService boardService;

    @Autowired
    ReplyService replyService;

    @Test
    public void 더미_데이터_생성(){

        for(Long i = Long.valueOf(1); i <= 100L; i++)
        {
            BoardDTO dto = BoardDTO.builder().number(i).content("Board Dummy file....."+i)
                    .author("Dummy_author..."+i).build();
            boardService.save(dto);
        }



    }


    @Test
    public void 등록(){


        BoardDTO dto = BoardDTO.builder().content("kimdonggyun").author("onetwo").build();

        boardService.save(dto);
    }

    @Test
    public void 조회(){


        boardService.read(2L);
    }

    @Test
    public void 수정(){


        BoardDTO dto = BoardDTO.builder().number(1L).content("Huh-inju").author("Sejong").build();

        boardService.modify(dto);
    }

    @Test
    public void 게시물과_댓글_같이_삭제(){


        Long number = 85L;

        replyService.deleteAll(number);

        boardService.delete(number);
    }

    @Test
    public void 다수_저장() {


        ArrayList<BoardDTO> dtoList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            BoardDTO dto= BoardDTO.builder().content("test"+ i).author("Sejong"+ i).build();
            dtoList.add(dto);
        }

        boardService.saveAll(dtoList);
    }


}
