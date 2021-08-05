package com.example.tdd_project.controller;

import com.example.tdd_project.DTO.BoardDTO;
import com.example.tdd_project.entity.Board;
import com.example.tdd_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping(value = "/read") //단순히 조회 기능만 넣어봄
    public ResponseEntity<Optional<Board>> read()
    {

      return ResponseEntity.ok(boardService.read(2L));

    }

    @GetMapping(value = "/read/{bno}") // URL에 변수를 사용해서 원하는 글만 조회 하게 했음

    public ResponseEntity<Optional<Board>> read2(@PathVariable("bno") Long number)
    {

        return ResponseEntity.ok(boardService.read(number));

    }


    @PostMapping(value = "/save") //이제 POST 요청에서 JSON 파일을 받아서 저장소에 save 할 수 있음
    public void save(@RequestBody BoardDTO dto)
    {
        boardService.save(dto);
    }

    @PostMapping(value = "/modify") //이제 POST 요청에서 JSON 파일을 받아서 저장소에 modify 할 수 있음
    public void modify(@RequestBody BoardDTO dto)
    {
        boardService.modify(dto);
    }

    @GetMapping(value = "/delete/{id}") // id 받아서 삭제 하는 요청
    public void delete(@PathVariable("id") Long number)
    {

        boardService.delete(number);


    }

}
