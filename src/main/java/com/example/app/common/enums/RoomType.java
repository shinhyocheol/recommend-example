package com.example.app.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomType {
    ONE_ROOM("원룸"),
    TWO_ROOM("투룸"),
    THREE_ROOM("쓰리룸 이상"),
    OFFICETEL("오피스텔"),
    APT("아파트");

    private final String description;
}
