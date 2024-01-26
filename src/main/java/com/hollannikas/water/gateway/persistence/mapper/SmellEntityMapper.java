package com.hollannikas.water.gateway.persistence.mapper;

import com.hollannikas.water.entity.Smell;
import com.hollannikas.water.gateway.persistence.repository.entity.SmellXML;

public class SmellEntityMapper {
    public static Smell from(SmellXML entity) {
        return (entity == null) ? null :
                new Smell(entity.getHajuId(), entity.getSeliteEng());
    }
}
