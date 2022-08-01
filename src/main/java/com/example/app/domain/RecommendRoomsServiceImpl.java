package com.example.app.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendRoomsServiceImpl {
    private final RecommendRoomsReader recommendRoomsReader;
    private final RecommendRoomsStore recommendRoomsStore;
}
