package com.example.app.ui;

import com.example.app.configuration.TestAbstractController;
import com.example.app.ui.request.RequestsDto;
import com.example.app.ui.request.RequestsDto.AddParam;
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
        RequestsDto.AddParam param = new AddParam();
    }
}
