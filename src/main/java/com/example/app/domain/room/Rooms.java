package com.example.app.domain.room;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.domain.request.Requests;
import com.example.app.enums.MappingStatusType;
import com.example.app.enums.RoomJoinType;
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
public class Rooms extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "매물 테이블 타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private RoomJoinType type;

    @Comment(value = "추천 진행상태")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(30) default 'RECOMMEND'")
    private MappingStatusType status;

    @Comment(value = "추천매물 코멘트")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Comment(value = "추천매물 신청번호")
    @ManyToOne
    @JoinColumn(
            name = "recommend_requests_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_rooms_recommend_requests_seq")
    )
    private Requests request;

    @Comment(value = "삭제여부")
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    /**
     * 매물, 회원의 경우 기존에 이미 존재하는 테이블임.
     * 또한 많은 데이터를 담고 있기에 직접 참조 설정은 기존 테이블에 영향을 끼칠 수 있는 리스크가 발생할 수 있음.
     * 따라서 간접 참조로 각 테이블의 ID만 가지고 있도록 하였고, 외래키 설정이 필요한 경우 DB 에서 직접 마이그레이션 작업 필요함.
     * 따라서 해당 테이블의 데이터가 필요한 경우 지연/즉시 로딩을 통한 join 조회가 아닌
     * JDBC Template 을 통해 쿼리 처리를 하거나 WebClient를 통해 다방 서버에 데이터를 요청하는 방식 중 채택해서 활용할 계획
     */
    @Comment(value = "중개소 아이디")
    @Column(length = 50, nullable = false)
    private String agentId;

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
