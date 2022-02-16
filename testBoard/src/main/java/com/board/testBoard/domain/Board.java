package com.board.testBoard.domain;

import lombok.Getter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter

public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String title;

    // Lob 는 크기제한 없게한다
    @Lob
    private String content;

    private LocalDateTime createdDate;

    // Board와 User의 연관 관계(1:N)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
