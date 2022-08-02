package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FeedbackActionType {
    BENEFIT("상"),
    PENALTY("벌");

    private final String description;
}
