package com.hollannikas.water.gateway.persistence.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hollannikas.water.gateway.persistence.repository.entity.SmellDataXML;
import com.hollannikas.water.gateway.persistence.repository.entity.SmellXML;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class SmellRepository {

    final List<SmellXML> smells = new ArrayList<>();

    public SmellRepository() {
        var om = new ObjectMapper();
        var url = getClass().getClassLoader().getResource("haju.json");
        try {
            var data = om.readValue(url, SmellDataXML.class);
            this.smells.addAll(Arrays.asList(data.getSmellEntities()));
        } catch (IOException e) {
            // Log
        }
    }
    public List<SmellXML> findAll() {
        return this.smells;
    }

    public Optional<SmellXML> findById(int hajuId) {
        return smells.stream()
                .filter(smell -> smell.getHajuId() == hajuId)
                .findFirst();
    }
}
