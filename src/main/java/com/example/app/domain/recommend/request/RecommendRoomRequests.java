package com.example.app.domain.recommend.request;

import com.example.app.common.enums.ContractType;
import com.example.app.common.enums.RoomStructureType;
import com.example.app.common.enums.RoomType;
import com.example.app.domain.BaseTimeEntity;
import java.util.List;
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
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.BigIntegerType;

@Getter
@Entity
@NoArgsConstructor
@TypeDef(name = "intList", typeClass = org.hibernate.mapping.List.class)
@Table(name = "recommend_room_requests")
public class RecommendRoomRequests extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "활성화 여부")
    @Column(nullable = false)
    @ColumnDefault(value = "true")
    private Boolean isActive;

    @Comment(value = "지번 주소")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String jibunAddress;

    @Comment(value = "도로명 주소")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String roadAddress;

    @Comment(value = "지역 코드목록")
    @Type(type = "intList")
    @Column(columnDefinition = "integer[]")
    private List<Integer> regionGids;

    @Comment(value = "지하철역 코드목록")
    @Type(type = "intList")
    @Column(columnDefinition = "integer[]")
    private List<Integer> subwayIds;

    @Comment(value = "매물 거래 타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private ContractType contractType;

    @Comment(value = "보증금")
    @Column(nullable = false)
    private Long deposit;

    @Comment(value = "월 납입금")
    private Long rentPrice;

    @Comment(value = "매물 면적")
    @Column(columnDefinition = "numeric")
    private BigIntegerType roomSize;

    @Comment(value = "매물타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private RoomType roomType;

    @Comment(value = "구조 타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private RoomStructureType roomStructureType;

    @Comment(value = "해당층")
    private Integer roomFloor;

    @Comment(value = "관리비")
    @Column(columnDefinition = "numeric")
    private BigIntegerType maintenanceCost;

    @Comment(value = "메모")
    @Column(columnDefinition = "TEXT")
    private String memo;

    @Comment(value = "삭제여부")
    @ColumnDefault(value = "false")
    private boolean isDeleted;

}
