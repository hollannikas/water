package com.hollannikas.water.domain.usecase;

import com.hollannikas.water.domain.entity.Smell;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmellFindAllUseCase {

    final SmellFindGateway smellFindGateway;

    public SmellFindAllUseCase(SmellFindGateway smellFindGateway) {
        this.smellFindGateway = smellFindGateway;
    }

    public List<Smell> findSmells() { return smellFindGateway.findAll(); }
}
