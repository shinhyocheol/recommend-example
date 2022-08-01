package com.example.app.domain.recommend;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.domain.item.basic.Rooms;
import com.example.app.domain.item.sign.SignRooms;
import com.example.app.domain.item.simple.SimpleRooms;
import com.example.app.domain.user.Users;
import com.example.app.enums.RoomMappingStatusType;
import com.example.app.enums.RoomTableType;
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
    private RoomTableType type;

    @Comment(value = "추천 진행상태")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(30) default 'RECOMMEND'")
    private RoomMappingStatusType status;

    @Comment(value = "추천매물 신청번호")
    @ManyToOne
    @JoinColumn(
            name = "request_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_rooms_recommend_requests_seq")
    )
    private RecommendRequests request;

    @Comment(value = "일반매물 번호")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "rooms_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_rooms_room_info_seq")
    )
    private Rooms room;

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

}