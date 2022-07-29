package com.example.app.domain.recommend.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomRequestsServiceImpl implements RoomRequestsService {
    private final RoomRequestsReader recommendRoomRequestsReader;
    private final RoomRequestsStore recommendRoomRequestsStore;


}
