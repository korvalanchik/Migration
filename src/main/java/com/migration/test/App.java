package com.migration.test;

import com.migration.storage.DatabaseInitService;
import com.migration.storage.Storage;
import lombok.SneakyThrows;

import java.util.List;

public class App {
    @SneakyThrows
    public static void main(String[] args){
        Storage storage = Storage.getInstance();
        new DatabaseInitService().initDb();
//        List<Worker> workers = new WorkerService().receiveWorker();
//        WorkerDao.save(workers);
//        List<Client> clients = new ClientService().receiveClient();
//        ClientDao.save(clients);
//        List<Project> projects = new ProjectService().receiveProject();
//        ProjectDao.save(projects);
//        List<ProjectWorker> projectWorkers = new ProjectWorkerService().receiveProjectWorker();
//        ProjectWorkerDao.save(projectWorkers);
        if(!storage.getConnection().isClosed()) {
            storage.getConnection().close();
        }
        storage.close();
    }
}
