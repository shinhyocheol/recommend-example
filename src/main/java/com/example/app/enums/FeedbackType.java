package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FeedbackType {
    LIKE("좋아요"),
    DISLIKE("싫어요");

    private final String description;
}
