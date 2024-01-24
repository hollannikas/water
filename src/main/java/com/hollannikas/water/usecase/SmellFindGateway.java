package com.hollannikas.water.usecase;

import com.hollannikas.water.entity.Smell;

import java.util.List;

public interface SmellFindGateway {

    List<Smell> findAll();

    Smell find(int id);
}
