package com.migration.service;

import com.migration.dao.ClientDao;
import com.migration.entity.Client;
import com.migration.prefs.Prefs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
    public static final String LIST_OF_CLIENT_JSON = "clientsList";

    public List<Client> receiveClient() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String listClients = new Prefs().getString(LIST_OF_CLIENT_JSON);
        String clients = String.join("\n", Files.readAllLines(Paths.get(listClients)));

        TypeReference<List<Client>> mapType = new TypeReference<List<Client>>() {};

        return objectMapper.readValue(clients, mapType);
    }
    public long create(String name) throws SQLException {
        Client client = new Client();
        client.setName(name);
        return new ClientDao().saveClient(client);
    }
    public String getById(Long id) throws SQLException {
        String nameClient = new ClientDao().selectById(id);
        if(nameClient == null) {
            return "Nothing found with Id " + id;
        }
        return nameClient;
    }
}
