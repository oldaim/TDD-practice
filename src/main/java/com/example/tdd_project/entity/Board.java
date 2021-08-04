package com.example.tdd_project.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Table(name = "Test")
public class Board extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column
    private String content;

    @Column
    private String author;

    public void change(String content,String author){
        this.author = author;
        this.content = content;
    }
}
