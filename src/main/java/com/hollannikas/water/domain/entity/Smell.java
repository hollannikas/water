package com.hollannikas.water.domain.entity;

import com.hollannikas.water.annotations.DomainEntity;

@DomainEntity
public record Smell(int id, String description) { }
