package com.example.app.domain.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendRoomsServiceImpl {
    private final RecommendRoomsReader recommendRoomsReader;
    private final RecommendRoomsStore recommendRoomsStore;
}