package com.hollannikas.water.usecase;

import com.hollannikas.water.entity.Smell;
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
