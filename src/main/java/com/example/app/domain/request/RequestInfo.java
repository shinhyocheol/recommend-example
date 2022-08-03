//package com.example.app.domain.request;
//
//import com.example.app.enums.ContractType;
//import com.example.app.enums.RoomType;
//import com.example.app.enums.StructureType;
//import java.time.ZonedDateTime;
//import java.util.List;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.ToString;
//import org.hibernate.type.BigIntegerType;
//
//@ToString
//@Getter
//@RequiredArgsConstructor
//public class RequestInfo {
//    private final Integer[] regionGids;
//    private final Integer[] subwayIds;
//    private final ContractType contractType;
//    private final Long maxDeposit;
//    private final Long minDeposit;
//    private final Long maxRentPrice;
//    private final Long minRentPrice;
//    private final Long maxRoomSize;
//    private final Long minRoomSize;
//    private final Long rentPrice;
//    private final RoomType roomType;
//    private final StructureType roomStructureType;
//    private final Integer[] roomFloors;
//    private final Long maxMaintenanceCost;
//    private final Long minMaintenanceCost;
//    private final String memo;
//    private final Integer usersIdx;
//    private final Boolean isDeleted;
//    private final ZonedDateTime savedTime;
//    private final ZonedDateTime editedTime;
//
//    public static RequestInfo of(Requests request) {
//        return new RequestInfo(
//                request.getSeq(),
//                request.getIsActive(),
//                request.getRegionGidList(),
//                request.getSubwayIdList(),
//                request.getContractType().getDescription(),
//                request.getDeposit(),
//                request.getRentPrice(),
//                request.getRoomSize(),
//                request.getRoomType().getDescription(),
//                request.getRoomStructureType().getDescription(),
//                request.getRoomFloor(),
//                request.getMemo(),
//                request.isDeleted(),
//                request.getSavedTime(),
//                request.getEditedTime()
//        );
//    }
//}
