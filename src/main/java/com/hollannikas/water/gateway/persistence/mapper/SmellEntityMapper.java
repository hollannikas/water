package com.hollannikas.water.gateway.persistence.mapper;

import com.hollannikas.water.domain.entity.Smell;
import com.hollannikas.water.gateway.persistence.entity.SmellEntity;

public class SmellEntityMapper {
    public static Smell from(SmellEntity entity) {
        return (entity == null) ? null :
                new Smell(entity.getId(), entity.getDescription());
    }

    public static SmellEntity to(Smell smell) {
        return (smell == null) ? null :
                new SmellEntity(smell.id(), smell.description());
    }
}
