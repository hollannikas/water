package com.hollannikas.water.domain.usecase;

import com.hollannikas.water.domain.entity.Smell;

import java.util.List;

public interface SmellUpdateGateway {
    void updateSmells(List<Smell> smells);
}
