package com.example.app.interfaces;

import com.example.app.application.RecommendRequestsFacade;
import com.example.app.common.response.CommonResponse;
import com.example.app.domain.recommend.RecommendRequestInfo;
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
    private final RecommendRequestsFacade recommendRequestsFacade;
    private final RecommendRequestDtoMapper recommendRequestDtoMapper;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addRecommendRequest(@RequestBody @Valid RecommendRequestDto.AddRecommendRequest addParam) {
        // recommendRequestsFacade.addRecommendRequest();
        return CommonResponse.success(null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getRoomRequest() {
        List<RecommendRequestInfo> recommendRequestList = recommendRequestsFacade.recommendRequestList();
        return CommonResponse.success(recommendRequestList);
    }
}
