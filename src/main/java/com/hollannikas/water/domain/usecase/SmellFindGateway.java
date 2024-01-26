package com.hollannikas.water.domain.usecase;

import com.hollannikas.water.domain.entity.Smell;

import java.util.List;

public interface SmellFindGateway {

    List<Smell> findAll();

    Smell find(int id);
}
