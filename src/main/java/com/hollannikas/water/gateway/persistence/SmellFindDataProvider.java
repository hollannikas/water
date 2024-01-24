package com.hollannikas.water.gateway.persistence;

import com.hollannikas.water.entity.Smell;
import com.hollannikas.water.usecase.SmellFindGateway;
import com.hollannikas.water.gateway.persistence.mapper.SmellEntityMapper;
import com.hollannikas.water.gateway.persistence.repository.SmellRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmellFindDataProvider implements SmellFindGateway {

    private final Logger logger = LoggerFactory.getLogger(SmellFindGateway.class);

    final SmellRepository smellRepository;

    public SmellFindDataProvider(SmellRepository smellRepository) {
        this.smellRepository = smellRepository;
    }
    @Override
    public List<Smell> findAll() {
       return smellRepository.findAll().stream()
               .peek(e -> logger.debug(e.getSeliteEng()))
               .map(SmellEntityMapper::from)
               .toList();
    }

    @Override
    public Smell find(int id) {
        return SmellEntityMapper.from(
                smellRepository.findById(id)
                .orElseThrow());
    }
}
