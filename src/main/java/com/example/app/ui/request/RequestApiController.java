package com.example.app.ui.request;

import com.example.app.application.RequestsFacade;
import com.example.app.common.response.CommonResponse;
import com.example.app.domain.request.RequestInfo;
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
public class RequestApiController {
    private final RequestsFacade facade;
    private final RequestMapStruct mapStruct;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRecommendRequest(@RequestBody @Valid RequestDto.AddParam param) {
        facade.addRequest(mapStruct.of(param));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getRecommendRequestList() {
        List<RequestInfo> requestList = facade.getRequestList();
        return CommonResponse.success(requestList);
    }
}
