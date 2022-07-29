package com.example.app.application.request;

import com.example.app.domain.request.RoomRequestInfo;
import com.example.app.domain.request.RoomRequestsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomRequestsFacade {
    private final RoomRequestsService roomRequestsService;

    public List<RoomRequestInfo> roomRequestInfo() {
        return roomRequestsService.roomRequestList();
    }
}
