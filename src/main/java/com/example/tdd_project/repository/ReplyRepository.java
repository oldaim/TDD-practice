package com.example.tdd_project.repository;

import com.example.tdd_project.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("select r from Reply r where r.board.number = :number")
    List<Reply> findAllByBoardNumber(@Param("number") Long number);
}