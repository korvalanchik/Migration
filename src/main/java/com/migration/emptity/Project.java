package com.migration.emptity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Project {
    private Long id;
    private Long clientId;
    private String startDate;
    private String finishDate;
}
