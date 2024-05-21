--liquibase formatted sql

--changeset alexeyz:1

create table metric
(
    id           bigserial
        primary key,
    metric_name  varchar(255),
    metric_type  varchar(255),
    metric_value varchar(255),
    source       varchar(255),
    timestamp    timestamp(6)
);

create table processed_event
(
    id         bigserial
        primary key,
    message_id varchar(255) not null
        unique,
    metric_id  bigint       not null
        references metric
);