package com.example.app.ui;

import com.example.app.configuration.TestAbstractController;
import com.example.app.enums.ContractType;
import com.example.app.enums.RoomType;
import com.example.app.enums.StructureType;
import com.example.app.ui.request.RequestsDto;
import com.example.app.ui.request.RequestsDto.AddParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.hibernate.type.BigIntegerType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("추천매물 신청")
public class TestRequestsController extends TestAbstractController {
    @Autowired
    private ObjectMapper objectMapper;

    private final String BASE_URL = "/api/v1/recommend/requests";

    @DisplayName("추천매물 신청 목록 조회")
    @Test
    public void 추천매물_신청_목록_조회() throws Exception {
        mockMvc.perform(get(BASE_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("추천매물 신청 등록")
    @Test
    public void 추천매물_신청_등록() throws Exception {
        Integer[] regionGids = new Integer[] {1, 2};
        Integer[] subwayIds = new Integer[] {1, 2};
        ContractType contractType = ContractType.LEASE;
        Long maxDeposit = Long.valueOf(300000000);
        Long minDeposit = Long.valueOf(100000000);
        Double maxRoomSize = Double.valueOf(84.52);
        Double minRoomSize = Double.valueOf(59.59);
        RoomType roomType = RoomType.ONE_ROOM;
        StructureType roomStructureType = StructureType.ONE_ROOM_KITCHEN_ALL_IN_ONE;
        Integer[] roomFloor = {1, 2, 3, 4};
        Long maxMaintenanceCost = Long.valueOf(100000);
        Long minMaintenanceCost = Long.valueOf(50000);
        String memo = "테스트";
        Integer usersIdx = 1;

        RequestsDto.AddParam param = new AddParam();
        param.setRegionGids(regionGids);
        param.setSubwayIds(subwayIds);
        param.setContractType(contractType);
        param.setMaxDeposit(maxDeposit);
        param.setMinDeposit(minDeposit);
        param.setMaxRoomSize(maxRoomSize);
        param.setMinRoomSize(minRoomSize);
        param.setRoomType(roomType);
        param.setRoomStructureType(roomStructureType);
        param.setRoomFloors(roomFloor);
        param.setMaxMaintenanceCost(maxMaintenanceCost);
        param.setMinMaintenanceCost(minMaintenanceCost);
        param.setMemo(memo);
        param.setUsersIdx(usersIdx);

        String jsonParam = objectMapper.writeValueAsString(param);
        System.out.println(jsonParam);

        mockMvc.perform(post(BASE_URL)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(jsonParam))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
