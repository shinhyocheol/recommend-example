package com.example.app.infrastructure.request;

import com.example.app.domain.request.RoomRequestInfo;
import com.example.app.domain.request.RoomRequestsReader;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomRequestsReaderImpl implements RoomRequestsReader {
    private final RoomRequestsRepository roomRequestsRepository;

    @Override
    public List<RoomRequestInfo> getRoomRequestList() {
        return roomRequestsRepository.findAll().stream()
                .map(item -> RoomRequestInfo.of(item))
                .collect(Collectors.toList());
    }
}
