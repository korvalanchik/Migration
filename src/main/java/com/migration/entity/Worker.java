package com.migration.entity;

import lombok.Data;

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
