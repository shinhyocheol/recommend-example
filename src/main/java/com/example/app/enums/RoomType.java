package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomType {
    ONE_ROOM("원룸"),
    TWO_ROOM("투룸"),
    THREE_ROOM("쓰리룸 이상"),
    OFFICETEL("오피스텔"),
    URBAN_LIVING_HOMES("도시형 생활주택");

    private final String description;

    public static RoomType of(String roomType) {
        return RoomType.valueOf(roomType);
    }
}
