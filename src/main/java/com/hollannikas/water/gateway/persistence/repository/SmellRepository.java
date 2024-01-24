package com.hollannikas.water.gateway.persistence.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hollannikas.water.gateway.persistence.repository.entity.SmellData;
import com.hollannikas.water.gateway.persistence.repository.entity.SmellEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class SmellRepository {

    final List<SmellEntity> smells = new ArrayList<>();

    public SmellRepository() {
        var om = new ObjectMapper();
        var url = getClass().getClassLoader().getResource("haju.json");
        try {
            var data = om.readValue(url, SmellData.class);
            this.smells.addAll(Arrays.asList(data.getSmellEntities()));
        } catch (IOException e) {
            // Log
        }
    }
    public List<SmellEntity> findAll() {
        return this.smells;
    }

    public Optional<SmellEntity> findById(int hajuId) {
        return smells.stream()
                .filter(smell -> smell.getHajuId() == hajuId)
                .findFirst();
    }
}
