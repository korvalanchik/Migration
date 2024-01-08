package com.migration.entity;

import lombok.Data;

@Data
public class Project {
    private Long id;
    private Long clientId;
    private String startDate;
    private String finishDate;
}
