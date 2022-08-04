package com.example.app.domain.request;

import com.example.app.enums.ContractType;
import com.example.app.enums.StructureType;
import com.example.app.enums.RoomType;
import lombok.Builder;
import lombok.Getter;

public class RequestsCommand {

    @Getter
    @Builder
    public static class RegisterRequest {
        private final Integer[] regionGids;
        private final Integer[] subwayIds;
        private final ContractType contractType;
        private final Long maxDeposit;
        private final Long minDeposit;
        private final Long maxRentPrice;
        private final Long minRentPrice;
        private final Double maxRoomSize;
        private final Double minRoomSize;
        private final Long rentPrice;
        private final RoomType roomType;
        private final StructureType roomStructureType;
        private final Integer[] roomFloors;
        private final Long maxMaintenanceCost;
        private final Long minMaintenanceCost;
        private final String memo;
        private final Integer usersIdx;

        public Requests toEntity() {
            return Requests.builder()
                    .regionGids(regionGids)
                    .subwayIds(subwayIds)
                    .contractType(contractType)
                    .maxDeposit(maxDeposit)
                    .minDeposit(minDeposit)
                    .maxRentPrice(maxRentPrice)
                    .minRentPrice(minRentPrice)
                    .maxRoomSize(maxRoomSize)
                    .minRoomSize(minRoomSize)
                    .roomType(roomType)
                    .structureType(roomStructureType)
                    .roomFloors(roomFloors)
                    .maxMaintenanceCost(maxMaintenanceCost)
                    .minMaintenanceCost(minMaintenanceCost)
                    .memo(memo)
                    .usersIdx(usersIdx)
                    .build();
        }
    }

}
