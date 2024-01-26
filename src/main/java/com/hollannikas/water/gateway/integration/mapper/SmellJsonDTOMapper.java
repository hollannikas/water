package com.hollannikas.water.gateway.integration.mapper;

import com.hollannikas.water.domain.entity.Smell;
import com.hollannikas.water.gateway.integration.dto.SmellJsonDTO;

public class SmellJsonDTOMapper {
    public static Smell from(SmellJsonDTO dto) {
        return (dto == null) ? null :
                new Smell(dto.getHajuId(), dto.getSeliteEng());
    }
}
