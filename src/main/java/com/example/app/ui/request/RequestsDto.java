package com.example.app.ui.request;

import com.example.app.enums.ContractType;
import com.example.app.enums.StructureType;
import com.example.app.enums.RoomType;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.type.BigIntegerType;

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
    public static class EditParam {
        private Integer recommendRequestsSeq;
        private List<Integer> regionGidList;
        private List<Integer> subwayIdList;
        private ContractType contractType;
        private Long deposit;
        private Long rentPrice;
        private BigIntegerType roomSize;
        private RoomType roomType;
        private StructureType roomStructureType;
        private Integer roomFloor;
        private BigIntegerType maintenanceCost;
        private String memo;
    }
}
