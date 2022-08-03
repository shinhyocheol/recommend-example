package com.example.app.ui.request;

import com.example.app.enums.ContractType;
import com.example.app.enums.StructureType;
import com.example.app.enums.RoomType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class RequestsDto {
    @Getter
    @Setter
    @ToString
    public static class AddParam {
        private Integer[] regionGids;
        private Integer[] subwayIds;
        private ContractType contractType;
        private Long maxDeposit;
        private Long minDeposit;
        private Long maxRentPrice;
        private Long minRentPrice;
        private Long maxRoomSize;
        private Long minRoomSize;
        private Long rentPrice;
        private RoomType roomType;
        private StructureType roomStructureType;
        private Integer[] roomFloors;
        private Long maxMaintenanceCost;
        private Long minMaintenanceCost;
        private String memo;
        private Integer usersIdx;
    }

    @Getter
    @Setter
    @ToString
    public static class EditParam extends AddParam {
        private Integer recommendRequestsSeq;
    }
}
