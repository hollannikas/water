package com.hollannikas.water.gateway.persistence.mapper;

import com.hollannikas.water.entity.Smell;
import com.hollannikas.water.gateway.persistence.repository.entity.SmellEntity;

public class SmellEntityMapper {
    public static Smell from(SmellEntity entity) {
        return (entity == null) ? null :
                new Smell(entity.getHajuId(), entity.getSeliteEng());
    }
}
