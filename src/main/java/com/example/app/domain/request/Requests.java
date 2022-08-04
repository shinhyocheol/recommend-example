package com.example.app.domain.request;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.enums.ContractType;
import com.example.app.enums.StructureType;
import com.example.app.enums.RoomType;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
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
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@NoArgsConstructor
@Getter
@TypeDefs({
        @TypeDef(name = "array-int", typeClass = IntArrayType.class),
        @TypeDef(name = "array-string", typeClass = StringArrayType.class)
})
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "recommend_room_requests")
public class Requests extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "지역 코드목록")
    @Type(type = "array-int")
    @Column(name = "regionGids", columnDefinition = "integer[]")
    private Integer[] regionGids;

    @Comment(value = "지하철역 코드목록")
    @Type(type = "array-int")
    @Column(name = "subwayIds", columnDefinition = "integer[]")
    private Integer[] subwayIds;

    @Comment(value = "매물 거래 타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private ContractType contractType;

    @Comment(value = "최대 보증금")
    @Column(nullable = false)
    private Long maxDeposit;

    @Comment(value = "최소 보증금")
    @Column(nullable = false)
    private Long minDeposit;

    @Comment(value = "최대 월 임대료")
    private Long maxRentPrice;

    @Comment(value = "최소 월 임대료")
    private Long minRentPrice;

    @Comment(value = "최대 매물 면적")
    @Column(columnDefinition = "numeric")
    private Double maxRoomSize;

    @Comment(value = "최소 매물 면적")
    @Column(columnDefinition = "numeric")
    private Double minRoomSize;

    @Comment(value = "매물타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private RoomType roomType;

    @Comment(value = "구조 타입")
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private StructureType roomStructureType;

    @Comment(value = "해당층")
    @Type(type = "array-int")
    @Column(columnDefinition = "integer[]")
    private Integer[] roomFloors;

    @Comment(value = "최대 관리비")
    @Column(columnDefinition = "numeric")
    private Long maxMaintenanceCost;

    @Comment(value = "최소 관리비")
    @Column(columnDefinition = "numeric")
    private Long minMaintenanceCost;

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
    public Requests(
            Integer usersIdx, Integer[] regionGids, Integer[] subwayIds, ContractType contractType,
            Long maxDeposit, Long minDeposit, Long maxRentPrice, Long minRentPrice,
            Double maxRoomSize, Double minRoomSize, Long minMaintenanceCost, Long maxMaintenanceCost,
            RoomType roomType, StructureType structureType, Integer[] roomFloors, String memo
    ) {
        this.regionGids = regionGids;
        this.subwayIds = subwayIds;
        this.contractType = contractType;
        this.maxDeposit = maxDeposit;
        this.minDeposit = minDeposit;
        this.maxRentPrice = maxRentPrice;
        this.minRentPrice = minRentPrice;
        this.maxRoomSize = maxRoomSize;
        this.minRoomSize = minRoomSize;
        this.roomType = roomType;
        this.roomStructureType = structureType;
        this.roomFloors = roomFloors;
        this.maxMaintenanceCost = maxMaintenanceCost;
        this.minMaintenanceCost = minMaintenanceCost;
        this.memo = memo;
        this.usersIdx = usersIdx;
    }

    public void deleteRequestBySeq() {
        this.isDeleted = true;
    }
}
