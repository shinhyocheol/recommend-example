package com.example.app.domain.recommend.request;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    @Column(nullable = false, columnDefinition = "boolean default true")
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
    @Column(columnDefinition = "text")
    private String memo;

    @Comment(value = "삭제여부")
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Getter
    @RequiredArgsConstructor
    public enum ContractType {
        MONTHLY_RENT("월세"),
        LEASE("전세"),
        SALE("매매");

        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum RoomType {
        ONE_ROOM("원룸"),
        TWO_ROOM("투룸"),
        THREE_ROOM("쓰리룸 이상"),
        OFFICETEL("오피스텔"),
        APT("아파트");

        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum RoomStructureType {
        ONE_ROOM_KITCHEN_ALL_IN_ONE("주방 일체형"),
        ONE_ROOM_KITCHEN_DETACHABLE("주방 분리형"),
        TWO_THREE_ROOM_SINGLE_LAYER("투,쓰리룸 단일층"),
        TWO_THREE_ROOM_DOUBLE_LAYER("투,쓰리룸 복층"),
        URBAN_OFFICETEL_ONE_ROOM("오피스텔(도시형 생활주택) 원룸"),
        URBAN_OFFICETEL_TWO_ROOM("오피스텔(도시형 생활주택) 투룸");

        private final String description;
    }

    @Builder
    public RecommendRoomRequests (Boolean isActive, String jibunAddress, String roadAddress,
            List<Integer> regionGids, List<Integer> subwayIds, ContractType contractType,
            Long deposit, Long rentPrice, BigIntegerType roomSize, RoomType roomType,
            RoomStructureType structureType, Integer roomFloor, BigIntegerType maintenanceCost,
            String memo, Boolean isDeleted) {
        this.isActive = isActive;
        this.jibunAddress = jibunAddress;
        this.roadAddress = roadAddress;
        this.regionGids = regionGids;
        this.subwayIds = subwayIds;
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
