package com.alekseyz.testtask.metricconsumermicroservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "processed_event")
public class ProcessedMetricEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_id", nullable = false, unique = true)
    private String messageId;

    @OneToOne
    @JoinColumn(name = "metric_id",nullable = false)
    private MetricEntity metricEntity;


}
