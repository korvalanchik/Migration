package com.migration.service;

import com.migration.emptity.ProjectWorker;
import com.migration.prefs.Prefs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProjectWorkerService {
    public static final String LIST_OF_PROJECTWORKER_JSON = "projectWorkerList";

    public List<ProjectWorker> receiveProjectWorker() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String listProjectWorkers = new Prefs().getString(LIST_OF_PROJECTWORKER_JSON);
        String projectWorkers = String.join("\n", Files.readAllLines(Paths.get(listProjectWorkers)));

        TypeReference<List<ProjectWorker>> mapType = new TypeReference<List<ProjectWorker>>() {};

        return objectMapper.readValue(projectWorkers, mapType);
    }
}
