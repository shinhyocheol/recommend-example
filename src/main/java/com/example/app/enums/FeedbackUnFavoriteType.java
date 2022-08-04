package com.example.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FeedbackUnFavoriteType {
    FAKE_PHOTO,
    FAKE_INFO,
    FAKE_LOCATION,
    OTHER;
}
