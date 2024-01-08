package com.migration.service;

import com.migration.entity.Project;
import com.migration.prefs.Prefs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProjectService {
    public static final String LIST_OF_PROJECT_JSON = "projectsList";

    public List<Project> receiveProject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String listProjects = new Prefs().getString(LIST_OF_PROJECT_JSON);
        String projects = String.join("\n", Files.readAllLines(Paths.get(listProjects)));

        TypeReference<List<Project>> mapType = new TypeReference<List<Project>>() {};

        return objectMapper.readValue(projects, mapType);
    }

}
