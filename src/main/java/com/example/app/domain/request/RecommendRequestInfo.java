package com.example.app.domain.request;

import java.time.ZonedDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.type.BigIntegerType;

@ToString
@Getter
@RequiredArgsConstructor
public class RecommendRequestInfo {
    private final Integer seq;
    private final Boolean isActive;
    private final List<Integer> regionGidList;
    private final List<Integer> subwayIdList;
    private final String contractType;
    private final Long deposit;
    private final Long rentPrice;
    private final BigIntegerType roomSize;
    private final String roomType;
    private final String roomStructureType;
    private final Integer roomFloor;
    private final String memo;
    private final Boolean isDelete;
    private final ZonedDateTime savedTime;
    private final ZonedDateTime editedTime;

    public static RecommendRequestInfo of(RecommendRequests request) {
        return new RecommendRequestInfo(
                request.getSeq(),
                request.getIsActive(),
                request.getRegionGidList(),
                request.getSubwayIdList(),
                request.getContractType().getDescription(),
                request.getDeposit(),
                request.getRentPrice(),
                request.getRoomSize(),
                request.getRoomType().getDescription(),
                request.getRoomStructureType().getDescription(),
                request.getRoomFloor(),
                request.getMemo(),
                request.isDeleted(),
                request.getSavedTime(),
                request.getEditedTime()
        );
    }
}
