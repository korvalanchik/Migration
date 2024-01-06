package com.migration.storage;

import com.migration.prefs.Prefs;
import org.flywaydb.core.Flyway;


public class DatabaseInitService {
    public void initDb() {
        String url = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
        String pass = new Prefs().getString(Prefs.DB_PASSWORD);
        String userName = new Prefs().getString(Prefs.DB_USERNAME);
        Flyway flyway = Flyway.configure().dataSource(url, userName, pass).load();

        flyway.migrate();
    }
}
