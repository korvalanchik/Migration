package com.migration.emptity;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Worker {
    private Long id;
    private String name;
    private String birthday;
    private Level level;
    private int salary;

    public enum Level {
        TRAINEE,
        JUNIOR,
        MIDDLE,
        SENIOR
    }

}
