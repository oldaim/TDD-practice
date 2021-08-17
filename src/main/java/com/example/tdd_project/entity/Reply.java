package com.example.tdd_project.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Table(name = "Reply_table")
public class Reply extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyNumber;

    private String text;

    @ManyToOne
    private Board board;
}
