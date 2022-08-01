package com.example.app.interfaces;

import java.util.List;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
        @NotBlank(message = "계약 타입을 입력해주세요.")
        private String contractType;
        @NotNull(message = "보증금을 입력해주세요.")
        private Long deposit;
        private Long rentPrice;
        private BigIntegerType roomSize;
        private String roomType;
        private String roomStructureType;
        private Integer roomFloor;
        private BigIntegerType maintenanceCost;
        private String memo;

        public void setContractType() {

        }

    }

}
