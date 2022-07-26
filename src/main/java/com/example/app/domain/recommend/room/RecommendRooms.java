package com.example.app.domain.recommend.room;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.domain.recommend.request.RecommendRoomRequests;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "recommend_rooms")
public class RecommendRooms extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Type type;

    @Comment("추천 진행상태")
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    @ColumnDefault(value = "'RECOMMEND'")
    private Status status;

    @Comment("추천매물 신청번호")
    @ManyToOne
    @JoinColumn(name = "request_seq", foreignKey = @ForeignKey(name = "fk_recommend_request_mapping"))
    private RecommendRoomRequests request;

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        GENERAL("일반"),
        SIMPLE("간편등록"),
        SIGN("싸인");

        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        RECOMMEND("추천"),
        ACCEPT("수락(이방볼래요)");

        private final String description;
    }

}
