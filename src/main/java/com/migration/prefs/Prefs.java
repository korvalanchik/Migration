package com.migration.prefs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DB_JDBC_CONNECTION_URL = "dbUrl";
    public static final String DB_USERNAME = "userName";
    public static final String DB_PASSWORD = "password";
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Object> prefsMap = new HashMap<>();
    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = String.join("\n", Files.readAllLines(Paths.get(filename)));

            TypeReference<Map<String, Object>> mapType = new TypeReference<>() {
            };
            prefsMap = objectMapper.readValue(json, mapType);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key) {
        return getPref(key).toString();
    }
    public Object getPref(String key) {
        return prefsMap.get(key);
    }
}
