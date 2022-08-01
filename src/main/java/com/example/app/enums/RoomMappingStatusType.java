package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomMappingStatusType {
    RECOMMEND("추천"),
    ACCEPT("수락(이방볼래요)");

    private final String description;
}
