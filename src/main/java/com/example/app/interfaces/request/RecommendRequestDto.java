package com.example.app.interfaces.request;

import com.example.app.enums.ContractType;
import com.example.app.enums.RoomStructureType;
import com.example.app.enums.RoomType;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.type.BigIntegerType;

public class RecommendRequestDto {
    @Getter
    @Setter
    @ToString
    public static class AddRecommendRequest {
        private List<Integer> regionGidList;
        private List<Integer> subwayIdList;
        private ContractType contractType;
        private Long deposit;
        private Long rentPrice;
        private BigIntegerType roomSize;
        private RoomType roomType;
        private RoomStructureType roomStructureType;
        private Integer roomFloor;
        private BigIntegerType maintenanceCost;
        private String memo;
    }

    @Getter
    @Setter
    @ToString
    public static class EditRecommendRequest {
        private Integer recommendRequestsSeq;
        private List<Integer> regionGidList;
        private List<Integer> subwayIdList;
        private ContractType contractType;
        private Long deposit;
        private Long rentPrice;
        private BigIntegerType roomSize;
        private RoomType roomType;
        private RoomStructureType roomStructureType;
        private Integer roomFloor;
        private BigIntegerType maintenanceCost;
        private String memo;
    }
}
