package com.hollannikas.water.controller.scheduling;

import com.hollannikas.water.usecase.SmellFindAllUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WaterLogger {

    private final Logger logger = LoggerFactory.getLogger(WaterLogger.class);
    final SmellFindAllUseCase smellFindUseCase;

    public WaterLogger(SmellFindAllUseCase smellFindAllUseCase) {
        this.smellFindUseCase = smellFindAllUseCase;
    }

    @Scheduled(fixedRate = 2000L)
    public void tock() {
        var smells = smellFindUseCase.findSmells();
        logger.info("We have " + smells.size() + " smells");
    }
}