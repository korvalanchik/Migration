package com.migration.test;

import com.migration.service.ClientService;
import com.migration.storage.DatabaseInitService;
import com.migration.storage.Storage;
import lombok.SneakyThrows;

public class App {
    @SneakyThrows
    public static void main(String[] args){
        String st;
        long id;
        Storage storage = Storage.getInstance();
        new DatabaseInitService().initDb();
        ClientService clientService = new ClientService();
        st = "Innocent";
        id = clientService.create(st);
        System.out.println("Created new client " + st + " with Id = " + id);
        st = "Violina";
        id = clientService.create(st);
        System.out.println("Created new client " + st + " with Id = " + id);
        System.out.println(clientService.getById(4L));
        System.out.println(clientService.getById(125L));


        if(!storage.getConnection().isClosed()) {
            storage.getConnection().close();
        }
        storage.close();
    }
}
