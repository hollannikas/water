package com.hollannikas.water.domain.usecase;

import com.hollannikas.water.domain.entity.Smell;
import org.springframework.stereotype.Component;

@Component
public class SmellFindUseCase {

    final SmellFindGateway smellFindGateway;

    public SmellFindUseCase(SmellFindGateway smellFindGateway) {
        this.smellFindGateway = smellFindGateway;
    }

    public Smell findSmell(int id) { return smellFindGateway.find(id); }
}
