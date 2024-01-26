package com.hollannikas.water.controller;

import com.hollannikas.water.domain.usecase.SmellRefreshUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SmellScheduler {
    private final Logger logger = LoggerFactory.getLogger(SmellScheduler.class);
    final SmellRefreshUseCase smellRefreshUseCase;

    public SmellScheduler(SmellRefreshUseCase smellRefreshUseCase) {
        this.smellRefreshUseCase = smellRefreshUseCase;
    }

    @Scheduled(fixedRate = 2000L)
    public void tock() {
        smellRefreshUseCase.refreshSmells();
        logger.info("Smells were refreshed");
    }
}
