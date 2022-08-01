package com.example.app.configuration.mapstruct;

import java.util.Objects;
import org.mapstruct.TargetType;

public class EnumerableConverter {
    public static final String convert(Enumerable source) {
        return Objects.nonNull(source) ? source.getType() : null;
    }

    public static final <E extends Enum<? extends Enumerable>> E convert(String source, @TargetType Class<E> clazz) {
        return (E) Enumerable.findToNull(source, (Enumerable[]) clazz.getEnumConstants());
    }

}
