package com.hollannikas.water.gateway.persistence;

import com.hollannikas.water.domain.entity.Smell;
import com.hollannikas.water.domain.usecase.SmellFindGateway;
import com.hollannikas.water.domain.usecase.SmellUpdateGateway;
import com.hollannikas.water.gateway.persistence.entity.SmellEntity;
import com.hollannikas.water.gateway.persistence.mapper.SmellEntityMapper;
import com.hollannikas.water.gateway.persistence.repository.SmellRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmellFindDataProvider implements SmellFindGateway, SmellUpdateGateway {

    final SmellRepository smellRepository;

    public SmellFindDataProvider(SmellRepository smellRepository) {
        this.smellRepository = smellRepository;
    }
    @Override
    public List<Smell> findAll() {
       return smellRepository.findAll().stream()
               .map(SmellEntityMapper::from)
               .toList();
    }

    @Override
    public Smell find(int id) {
        return SmellEntityMapper.from(
                smellRepository.findById(id)
                .orElseThrow());
    }

    @Override
    public void updateSmells(List<Smell> smells) {
        List<SmellEntity> smellEntities = smells.stream()
                        .map(SmellEntityMapper::to)
                                .toList();
        smellRepository.saveAll(smellEntities);
    }
}
