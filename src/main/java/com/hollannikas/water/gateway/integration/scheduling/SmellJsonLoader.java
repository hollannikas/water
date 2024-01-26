package com.hollannikas.water.gateway.integration.scheduling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hollannikas.water.domain.entity.Smell;
import com.hollannikas.water.domain.usecase.SmellLoadGateway;
import com.hollannikas.water.gateway.integration.dto.SmellDataJsonDTO;
import com.hollannikas.water.gateway.integration.dto.SmellJsonDTO;
import com.hollannikas.water.gateway.integration.mapper.SmellJsonDTOMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SmellJsonLoader implements SmellLoadGateway {

    final List<SmellJsonDTO> smells = new ArrayList<>();

    final String veslaUrl;

    public SmellJsonLoader(@Value("${vesla.url}") String veslaUrl) {
        this.veslaUrl = veslaUrl;
    }

    private void fetchSmellsFromOData() {
        try {
            var url = new URI(veslaUrl).toURL();
            var data = new ObjectMapper().readValue(url, SmellDataJsonDTO.class);
            var smells = Arrays.asList(data.getSmellEntities());
            this.smells.addAll(smells);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Smell> loadSmells() {
        fetchSmellsFromOData();
        return smells.stream()
                .map(SmellJsonDTOMapper::from)
                .toList();
    }
}
