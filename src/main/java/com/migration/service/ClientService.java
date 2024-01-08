package com.migration.service;

import com.migration.dao.ClientDao;
import com.migration.entity.Client;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private final ClientDao clientDao;

    public ClientService() throws SQLException {
        clientDao = new ClientDao();
    }

    public long create(String name) {
        Client client = new Client();
        client.setName(name);
        return clientDao.saveClient(client);
    }

    public String getById(Long id) {
        String nameClient = clientDao.selectById(id);
        if(nameClient == null) {
            return "Nothing found with Id " + id;
        }
        return nameClient;
    }

    public void setName(long id, String name) {
        if(Boolean.FALSE.equals(clientDao.saveName(id, name))) {
            System.out.println("Name has not been changed");
        }
    }

    public void deleteById(long id) {
        if(Boolean.FALSE.equals(clientDao.removeById(id))) {
            System.out.println("Record has not been deleted");
        }
    }

    public List<Client> listAll() throws MyException {
            if (clientDao.selectAll().isEmpty()) {
                throw new MyException();
            }
        return clientDao.selectAll();
    }

    private static class MyException extends Exception {
        public MyException() {
            super("Input data validation failed!");
        }
    }
}
