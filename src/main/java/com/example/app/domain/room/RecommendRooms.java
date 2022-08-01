package com.example.app.domain.room;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.domain.request.RecommendRequests;
import com.example.app.enums.RoomMappingStatusType;
import com.example.app.enums.RoomTableType;
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

    @Comment(value = "삭제여부")
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    /**
     * 매물, 회원의 경우 기존에 이미 존재하는 테이블임.
     * 또한 많은 데이터를 담고 있기에 직접 참조 설정은 작지 않은 리스크를 감당해야 할 부담이 생김
     * 따라서 간접 참조로 각 테이블의 ID만 가지고 있도록 하였고, 외래키 설정이 필요한 경우 DB 에서 직접 마이그레이션 작업 필요함.
     * 따라서 해당 테이블의 데이터가 필요한 경우 지연/즉시 로딩을통한 join 조회가 아닌
     * Mybatis 또는 JDBC Template 을 통해 데이터 별도 조회할 것
     */
    @Comment(value = "일반매물 번호")
    private Integer roomsSeq;

    @Comment(value = "간편매물 번호")
    private Integer simpleRoomsSeq;

    @Comment(value = "싸인매물 번호")
    private Integer signRoomsSeq;

    @Comment(value = "사용자 번호")
    @Column(nullable = false)
    private Integer usersIdx;

}