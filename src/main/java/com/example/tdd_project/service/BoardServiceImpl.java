package com.example.tdd_project.service;

import com.example.tdd_project.DTO.BoardDTO;
import com.example.tdd_project.entity.Board;
import com.example.tdd_project.repository.BoardRepository;
import lombok.Builder;
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
                .author(dto.getAuthor()).number(dto.getNumber()).build();

        boardRepository.save(board);

        log.info(board);
    }

    @Override
    public void read(BoardDTO dto){
        Board board = Board.builder().content(dto.getContent())
                .author(dto.getAuthor()).number(dto.getNumber()).build();

        Optional<Board> bno = boardRepository.findById(board.getNumber());
        log.info(bno);
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

        boardRepository.deleteById(number);
        log.info("success");

    }
}
