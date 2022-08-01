package com.example.app.domain.request;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.enums.ContractType;
import com.example.app.enums.RoomStructureType;
import com.example.app.enums.RoomType;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.BigIntegerType;

@Getter
@Entity
@NoArgsConstructor
@TypeDef(name = "intList", typeClass = org.hibernate.mapping.List.class)
@Table(name = "recommend_room_requests")
public class RecommendRequests extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "지역 코드목록")
    @Type(type = "intList")
    @Column(name = "regionGids", columnDefinition = "integer[]")
    private List<Integer> regionGidList;

    @Comment(value = "지하철역 코드목록")
    @Type(type = "intList")
    @Column(name = "subwayIds", columnDefinition = "integer[]")
    private List<Integer> subwayIdList;

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
    @Column(columnDefinition = "text")
    private String memo;

    @Comment(value = "활성화 여부")
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @Comment(value = "삭제여부")
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Comment(value = "신청 회원 번호")
    private Integer usersIdx;

    @Builder
    public RecommendRequests(Boolean isActive, List<Integer> regionGidList,
            List<Integer> subwayIdList, ContractType contractType, Long deposit,
            Long rentPrice, BigIntegerType roomSize, RoomType roomType,
            RoomStructureType structureType, Integer roomFloor,
            BigIntegerType maintenanceCost, String memo, Boolean isDeleted) {
        this.isActive = isActive;
        this.regionGidList = regionGidList;
        this.subwayIdList = subwayIdList;
        this.contractType = contractType;
        this.deposit = deposit;
        this.rentPrice = rentPrice;
        this.roomSize = roomSize;
        this.roomType = roomType;
        this.roomStructureType = structureType;
        this.roomFloor = roomFloor;
        this.maintenanceCost = maintenanceCost;
        this.memo = memo;
        this.isDeleted = isDeleted;
    }
}
