package com.example.app.interfaces.request;

import com.example.app.application.RecommendRequestsFacade;
import com.example.app.common.response.CommonResponse;
import com.example.app.domain.request.RecommendRequestInfo;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/recommend/requests")
public class RecommendRequestApiController {
    private final RecommendRequestsFacade facade;
    private final RecommendRequestMapStruct mapStruct;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRecommendRequest(@RequestBody @Valid RecommendRequestDto.AddParam param) {
        facade.addRecommendRequest(mapStruct.of(param));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getRecommendRequestList() {
        List<RecommendRequestInfo> recommendRequestList = facade.getRecommendRequestList();
        return CommonResponse.success(recommendRequestList);
    }
}
