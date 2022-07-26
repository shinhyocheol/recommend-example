package com.example.app.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContractType {
    MONTHLY_RENT("월세"),
    LEASE("전세"),
    SALE("매매");

    private final String description;
}
