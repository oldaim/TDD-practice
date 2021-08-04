package com.example.tdd_project.repository;

import com.example.tdd_project.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> { // <엔티티 / ID 유형>
}
