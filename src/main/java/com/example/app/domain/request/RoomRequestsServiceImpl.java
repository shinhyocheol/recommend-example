package com.example.app.domain.request;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomRequestsServiceImpl implements RoomRequestsService {
    private final RoomRequestsReader roomRequestsReader;
    private final RoomRequestsStore roomRequestsStore;


    @Override
    @Transactional(readOnly = true)
    public List<RoomRequestInfo> roomRequestList() {
        List<RoomRequests> request = roomRequestsReader.getRoomRequestList();
        return null;
    }
}
