package com.example.tdd_project.service;


import com.example.tdd_project.DTO.BoardDTO;
import com.example.tdd_project.entity.Board;
import com.example.tdd_project.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    BoardService boardService;

    @Test
    public void 등록(){


        BoardDTO dto = BoardDTO.builder().content("kimdonggyun").author("onetwo").build();

        boardService.save(dto);
    }

    @Test
    public void 조회(){


        BoardDTO dto = BoardDTO.builder().number(1L).content("kimdonggyun").author("onetwo").build();

        boardService.read(dto);
    }

    @Test
    public void 수정(){


        BoardDTO dto = BoardDTO.builder().number(1L).content("Huh-inju").author("Sejong").build();

        boardService.modify(dto);
    }

    @Test
    public void 삭제(){


        Long number = 3L;

        boardService.delete(number);
    }


}