package com.alekseyz.testtask.metricconsumermicroservice.repository;

import com.alekseyz.testtask.metricconsumermicroservice.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<MetricEntity, Long> {
}
