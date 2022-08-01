package com.example.app.domain.request;

import com.example.app.enums.ContractType;
import com.example.app.enums.StructureType;
import com.example.app.enums.RoomType;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.type.BigIntegerType;

public class RequestCommand {

    @Getter
    @Builder
    public static class RegisterRequest {
        private final List<Integer> regionGidList;
        private final List<Integer> subwayIdList;
        private final ContractType contractType;
        private final Long deposit;
        private final Long rentPrice;
        private final BigIntegerType roomSize;
        private final RoomType roomType;
        private final StructureType roomStructureType;
        private final Integer roomFloor;
        private final BigIntegerType maintenanceCost;
        private final String memo;

        public Requests toEntity() {
            return Requests.builder()
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
