package com.hollannikas.water.domain.usecase;

import com.hollannikas.water.domain.entity.Smell;

import java.util.List;

public interface SmellLoadGateway {
    List<Smell> loadSmells();
}
