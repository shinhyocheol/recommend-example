package com.example.app.configuration.mapstruct;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

public class EnumerableListConverter {
    public static final <T extends Enumerable> List<String> convert(List<T> source) {
        return CollectionUtils.isNotEmpty(source) ? source.stream().map(Enumerable::getType).collect(Collectors.toList()) : null;
    }
}
