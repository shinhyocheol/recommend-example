package com.example.app.domain.recommend.room;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.domain.recommend.request.RecommendRoomRequests;
import com.example.app.domain.room.basic.RoomInfo;
import com.example.app.domain.room.sign.SignRooms;
import com.example.app.domain.room.simple.SimpleRooms;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "recommend_rooms")
public class RecommendRooms extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "매물 타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Type type;

    @Comment(value = "추천 진행상태")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(30) default 'RECOMMEND'")
    private Status status;

    @Comment(value = "추천매물 신청번호")
    @ManyToOne
    @JoinColumn(name = "request_seq", foreignKey = @ForeignKey(name = "fk_recommend_request_room"))
    private RecommendRoomRequests request;

    @Comment(value = "일반매물 번호")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "rooms_seq", foreignKey = @ForeignKey(name = "fk_room_recommend_room"))
    private RoomInfo room;

    @Comment(value = "간편매물 번호")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "simple_rooms_seq", foreignKey = @ForeignKey(name = "fk_simple_room_recommend_room"))
    private SimpleRooms simpleRoom;

    @Comment(value = "싸인매물 번호")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "sign_rooms_seq", foreignKey = @ForeignKey(name = "fk_sign_room_recommend_room"))
    private SignRooms signRoom;

    @Comment(value = "삭제여부")
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

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
