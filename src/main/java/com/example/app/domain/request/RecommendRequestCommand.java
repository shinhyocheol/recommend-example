package com.example.app.domain.request;

import com.example.app.enums.ContractType;
import com.example.app.enums.RoomStructureType;
import com.example.app.enums.RoomType;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.type.BigIntegerType;

public class RecommendRequestCommand {

    @Getter
    @Builder
    public static class RegisterRecommendRequest {
        private final List<Integer> regionGidList;
        private final List<Integer> subwayIdList;
        private final ContractType contractType;
        private final Long deposit;
        private final Long rentPrice;
        private final BigIntegerType roomSize;
        private final RoomType roomType;
        private final RoomStructureType roomStructureType;
        private final Integer roomFloor;
        private final BigIntegerType maintenanceCost;
        private final String memo;

        public RecommendRequests toEntity() {
            return RecommendRequests.builder()
                    .regionGidList(regionGidList)
                    .subwayIdList(subwayIdList)
                    .contractType(contractType)
                    .deposit(deposit)
                    .rentPrice(rentPrice)
                    .roomSize(roomSize)
                    .roomType(roomType)
                    .structureType(roomStructureType)
                    .roomFloor(roomFloor)
                    .maintenanceCost(maintenanceCost)
                    .memo(memo)
                    .build();
        }
    }

}
