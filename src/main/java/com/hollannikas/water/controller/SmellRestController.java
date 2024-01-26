package com.hollannikas.water.controller;

import com.hollannikas.water.domain.entity.Smell;
import com.hollannikas.water.domain.usecase.SmellFindAllUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("smells")
public class SmellRestController {

    private final SmellFindAllUseCase smellFindAllUseCase;

    public SmellRestController(SmellFindAllUseCase smellFindAllUseCase) {
        this.smellFindAllUseCase = smellFindAllUseCase;
    }

    @GetMapping(produces = "application/json")
    public List<Smell> getSmells() {
        return smellFindAllUseCase.findSmells();
    }
}
