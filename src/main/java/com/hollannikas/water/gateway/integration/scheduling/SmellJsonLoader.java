package com.hollannikas.water.gateway.integration.scheduling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hollannikas.water.domain.entity.Smell;
import com.hollannikas.water.domain.usecase.SmellLoadGateway;
import com.hollannikas.water.gateway.integration.dto.SmellDataJsonDTO;
import com.hollannikas.water.gateway.integration.dto.SmellJsonDTO;
import com.hollannikas.water.gateway.integration.mapper.SmellJsonDTOMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SmellJsonLoader implements SmellLoadGateway {

    final List<SmellJsonDTO> smells = new ArrayList<>();

    public SmellJsonLoader() {
        // TODO: read from API and insert into DB
        var om = new ObjectMapper();
        var url = getClass().getClassLoader().getResource("haju.json");
        try {
            var data = om.readValue(url, SmellDataJsonDTO.class);
            this.smells.addAll(Arrays.asList(data.getSmellEntities()));
        } catch (IOException e) {
            // Log
        }
    }
    @Override
    public List<Smell> loadSmells() {
        return smells.stream()
                .map(SmellJsonDTOMapper::from)
                .toList();
    }
}
