package com.example.app.domain.recommend.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "recommend_rooms")
public class RecommendRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Type type;

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        GENERAL("일반"),
        SIMPLE("간편등록"),
        SIGN("싸인");

        private final String description;
    }

}
