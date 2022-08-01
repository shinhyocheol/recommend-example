package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomTableType {
    GENERAL("일반"),
    SIMPLE("간편등록"),
    SIGN("싸인");

    private final String description;
}
