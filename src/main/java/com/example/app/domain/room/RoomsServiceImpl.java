package com.example.app.domain.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl {
    private final RoomsReader roomsReader;
    private final RoomsStore roomsStore;
}
