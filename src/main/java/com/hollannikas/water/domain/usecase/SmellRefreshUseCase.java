package com.hollannikas.water.domain.usecase;

import com.hollannikas.water.domain.entity.Smell;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmellRefreshUseCase {

    final SmellLoadGateway smellLoadGateway;
    final SmellUpdateGateway smellUpdateGateway;

    public SmellRefreshUseCase(SmellLoadGateway smellLoadGateway, SmellUpdateGateway smellUpdateGateway) {
        this.smellLoadGateway = smellLoadGateway;
        this.smellUpdateGateway = smellUpdateGateway;
    }

    public void refreshSmells() {
        List<Smell> smells = smellLoadGateway.loadSmells();
        smellUpdateGateway.updateSmells(smells);
    }
}
