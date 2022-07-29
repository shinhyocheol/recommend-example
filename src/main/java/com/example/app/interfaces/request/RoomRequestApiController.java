package com.example.app.interfaces.request;

import com.example.app.application.request.RoomRequestsFacade;
import com.example.app.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/room-requests")
public class RoomRequestApiController {
    private final RoomRequestsFacade roomRequestsFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getRoomRequest() {
        var roomRequestList = roomRequestsFacade.roomRequestList();
        return null;
    }
}
