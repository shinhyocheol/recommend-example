package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MappingStatusType {
    RECOMMEND("추천"),
    ACCEPT("수락(이방볼래요)");

    private final String description;
}
