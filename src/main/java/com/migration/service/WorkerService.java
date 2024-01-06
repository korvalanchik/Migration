package com.migration.service;

import com.migration.emptity.Worker;
import com.migration.prefs.Prefs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WorkerService {
    public static final String LIST_OF_WORKER_JSON = "workersList";

    public List<Worker> receiveWorker() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String listWorkers = new Prefs().getString(LIST_OF_WORKER_JSON);
        String workers = String.join("\n", Files.readAllLines(Paths.get(listWorkers)));

        TypeReference<List<Worker>> mapType = new TypeReference<List<Worker>>() {};

        return objectMapper.readValue(workers, mapType);
    }
}
