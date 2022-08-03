package com.example.app.ui;

import com.example.app.configuration.TestAbstractController;
import com.example.app.enums.ContractType;
import com.example.app.enums.RoomType;
import com.example.app.enums.StructureType;
import com.example.app.ui.request.RequestsDto;
import com.example.app.ui.request.RequestsDto.AddParam;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.hibernate.type.BigIntegerType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("추천매물 신청")
public class TestRequestsController extends TestAbstractController {
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
        //given
        List<Integer> regionGidList = Arrays.asList(new Integer[] {1, 2});
        List<Integer> subwayIdList = Arrays.asList(new Integer[] {1, 2});
        ContractType contractType = ContractType.LEASE;
        Long deposit = Long.valueOf(100000000);
        Long roomSize = Long.valueOf((long) 59.59);
        RoomType roomType = RoomType.ONE_ROOM;
        StructureType roomStructureType = StructureType.ONE_ROOM_KITCHEN_ALL_IN_ONE;
//        Integer roomFloor = ;
        Long maintenanceCost;
        String memo;

        //when
        RequestsDto.AddParam param = new AddParam();


        //then
    }
}
