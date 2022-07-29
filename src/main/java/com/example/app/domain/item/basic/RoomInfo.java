package com.example.app.domain.item.basic;

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
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "room_info")
public class RoomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "매물 아이디")
    @Column(length = 30, nullable = false)
    private String id;

    @Comment(value = "매물 광고 상태")
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Status status;

    @Comment(value = "삭제여부")
    @Column(nullable = false)
    @ColumnDefault(value = "false")
    private Boolean isDeleted;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PRIVATE(0),
        PUBLIC(1),
        COMPLETE(2),
        RETURN(3),
        RECONFIRM(4);

        private final Integer intValue;
    }
}
