package com.example.app.domain.request;

import com.example.app.enums.ContractType;
import com.example.app.enums.RoomType;
import com.example.app.enums.StructureType;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class RequestDetail {
    private final Integer seq;
    private final Boolean isActive;
    private final Integer[] regionGids;
    private final Integer[] subwayIds;
    private final ContractType contractType;
    private final Long maxDeposit;
    private final Long minDeposit;
    private final Long maxRentPrice;
    private final Long minRentPrice;
    private final Double maxRoomSize;
    private final Double minRoomSize;
    private final RoomType roomType;
    private final StructureType roomStructureType;
    private final Integer[] roomFloors;
    private final Long maxMaintenanceCost;
    private final Long minMaintenanceCost;
    private final String memo;
    private final Integer usersIdx;
    private final ZonedDateTime savedTime;
    private final ZonedDateTime editedTime;

    public static RequestDetail of(Requests request) {
        return new RequestDetail(
                request.getSeq(),
                request.getIsActive(),
                request.getRegionGids(),
                request.getSubwayIds(),
                request.getContractType(),
                request.getMaxDeposit(),
                request.getMinDeposit(),
                request.getMaxRentPrice(),
                request.getMinRentPrice(),
                request.getMaxRoomSize(),
                request.getMinRoomSize(),
                request.getRoomType(),
                request.getRoomStructureType(),
                request.getRoomFloors(),
                request.getMinMaintenanceCost(),
                request.getMinMaintenanceCost(),
                request.getMemo(),
                request.getUsersIdx(),
                request.getSavedTime(),
                request.getEditedTime()
        );
    }
}
