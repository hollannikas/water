package com.hollannikas.water.gateway.persistence.repository;

import com.hollannikas.water.gateway.persistence.entity.SmellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmellRepository extends JpaRepository<SmellEntity, Integer> {
}
