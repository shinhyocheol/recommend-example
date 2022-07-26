package com.example.app.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomStructureType {
    ONE_ROOM_KITCHEN_ALL_IN_ONE("주방 일체형"),
    ONE_ROOM_KITCHEN_DETACHABLE("주방 분리형"),
    TWO_THREE_ROOM_SINGLE_LAYER("투,쓰리룸 단일층"),
    TWO_THREE_ROOM_DOUBLE_LAYER("투,쓰리룸 복층"),
    URBAN_OFFICETEL_ONE_ROOM("오피스텔(도시형 생활주택) 원룸"),
    URBAN_OFFICETEL_TWO_ROOM("오피스텔(도시형 생활주택) 투룸");

    private final String description;
}
