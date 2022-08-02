package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StructureType {
    ONE_ROOM_KITCHEN_ALL_IN_ONE("ONE_ROOM", "주방 일체형"),
    ONE_ROOM_KITCHEN_DETACHABLE("ONE_ROOM","주방 분리형"),
    TWO_ROOM_SINGLE_LAYER("TWO_ROOM","단일층"),
    TWO_ROOM_DOUBLE_LAYER("TWO_ROOM","복층"),
    THREE_ROOM_SINGLE_LAYER("THREE_ROOM","단일층"),
    THREE_ROOM_DOUBLE_LAYER("THREE_ROOM","복층"),
    OFFICETEL_ONE_ROOM("OFFICETEL", "원룸"),
    OFFICETEL_TWO_ROOM("OFFICETEL","투룸"),
    URBAN_LIVING_HOMES_ONE_ROOM("URBAN_LIVING_HOMES", "원룸"),
    URBAN_LIVING_HOMES_TWO_ROOM("URBAN_LIVING_HOMES", "투룸");

    private final String roomType;
    private final String description;

    public static StructureType of(String roomStructureType) {
        return StructureType.valueOf(roomStructureType);
    }
}
