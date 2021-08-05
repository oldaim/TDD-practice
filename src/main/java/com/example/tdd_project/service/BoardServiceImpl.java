package com.example.tdd_project.service;

import com.example.tdd_project.DTO.BoardDTO;
import com.example.tdd_project.entity.Board;
import com.example.tdd_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void save(BoardDTO dto){
        Board board = Board.builder().content(dto.getContent())
                .author(dto.getAuthor()).build();

        boardRepository.save(board);

        log.info(board);
    }

    @Override
    public Optional<Board> read(Long number){


        Optional<Board> bno = boardRepository.findById(number);
        log.info(bno);

        return bno;
    }

    @Override
    public void modify(BoardDTO dto){
    Optional<Board> board = boardRepository.findById(dto.getNumber());

        if(board.isPresent()){
            Board b = board.get();
            b.change(dto.getContent(), dto.getAuthor());
            boardRepository.save(b);
        }

    }

    @Override
    public void delete(Long number){
        Optional<Board> bno = boardRepository.findById(number);

        if(bno.isPresent()) {

            boardRepository.deleteById(number);
            log.info("success");
        }
    }
}
