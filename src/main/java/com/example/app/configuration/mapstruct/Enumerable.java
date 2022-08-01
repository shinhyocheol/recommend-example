package com.example.app.configuration.mapstruct;

import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public interface Enumerable {
    String getType();

    String getName();

    default boolean matched(String type) {
        return Objects.equals(this.getType(), type);
    }

    static <T extends Enumerable> T find(String type, T[] values) {
        T findValue = findToNull(type, values);
        if (Objects.nonNull(findValue)) {
            new Exception(String.format("지원하지 않는 형식입니다.(형식 : %s)", type));
        }
        return findValue;
    }

    static <T extends Enumerable> T findToNull(String type, T[] values) {
        return StringUtils.isBlank(type) ? null : (T) Arrays.stream(values).filter((value) -> {
            return value.getType().equals(type);
        }).findFirst().orElse((T) null);
    }
}
