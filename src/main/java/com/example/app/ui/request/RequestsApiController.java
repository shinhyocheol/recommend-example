package com.example.app.ui.request;

import com.example.app.application.RequestsFacade;
import com.example.app.common.response.CommonResponse;
import com.example.app.domain.request.RequestInfo;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/recommend/requests")
public class RequestsApiController {
    private final RequestsFacade facade;
    private final RequestsMapStruct mapStruct;

    /**
     * <pre>
     *     추천매물 신청 등록
     * </pre>
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addRequest(@RequestBody @Valid RequestsDto.AddParam param) throws Exception {
        facade.addRequest(mapStruct.of(param));
        return CommonResponse.success("SUCCESS");
    }

    /**
     * <pre>
     *     추천매물 신청 목록 조회
     * </pre>
     * @return
     * @throws Exception
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getRequestList() throws Exception {
        List<RequestInfo> requestList = facade.getRequestList();
        return CommonResponse.success(requestList);
    }

    /**
     * <pre>
     *     추천매물 신청 상세 조회
     * </pre>
     * @param seq
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/{seq}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getRequestDetail(@PathVariable Integer seq) throws Exception {
        return CommonResponse.success(null);
    }

    /**
     * <pre>
     *     추천매물 신청 수정
     * </pre>
     * @param seq
     * @param param
     * @return
     * @throws Exception
     */
    @PutMapping(value = "/{seq}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse editRequest(
            @PathVariable Integer seq,
            @RequestBody @Valid RequestsDto.EditParam param) throws Exception {
        return CommonResponse.success("SUCCESS");
    }

    /**
     * <pre>
     *     추천매물 신청 삭제
     * </pre>
     * @param seq
     * @return
     * @throws Exception
     */
    @DeleteMapping(value = "/{seq}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteRequest(@PathVariable Integer seq) throws Exception {
        return CommonResponse.success("SUCCESS");
    }
}
