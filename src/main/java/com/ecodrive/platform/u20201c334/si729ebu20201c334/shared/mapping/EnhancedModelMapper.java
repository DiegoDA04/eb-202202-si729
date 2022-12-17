package com.ecodrive.platform.u20201c334.si729ebu20201c334.shared.mapping;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EnhancedModelMapper extends ModelMapper {

    public EnhancedModelMapper() { super(); }

    public <S, T> List<T> mapList(List<S> sourceList,Class<T> targetClass) {
        return sourceList.stream().map(item -> this.map(item, targetClass))
                .collect(Collectors.toList());
    }
}
