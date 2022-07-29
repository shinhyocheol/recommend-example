package com.example.app.domain.room;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.domain.request.RoomRequests;
import com.example.app.domain.item.basic.RoomInfo;
import com.example.app.domain.item.sign.SignRooms;
import com.example.app.domain.item.simple.SimpleRooms;
import com.example.app.domain.user.Users;
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
public class Rooms extends BaseTimeEntity {
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
    @JoinColumn(
            name = "request_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_rooms_recommend_requests_seq")
    )
    private RoomRequests request;

    @Comment(value = "일반매물 번호")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "rooms_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_rooms_room_info_seq")
    )
    private RoomInfo room;

    @Comment(value = "간편매물 번호")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "simple_rooms_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_room_simple_rooms_seq")
    )
    private SimpleRooms simpleRoom;

    @Comment(value = "싸인매물 번호")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "sign_rooms_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_rooms_sign_rooms_seq")
    )
    private SignRooms signRoom;

    @Comment(value = "신청회원 번호")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "users_seq",
            referencedColumnName = "idx",
            foreignKey = @ForeignKey(name = "fk_recommend_rooms_users_idx")
    )
    private Users user;

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