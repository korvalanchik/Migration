package com.migration.storage;

import com.migration.prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private Connection connection;

    private Storage() {
        try {
            String url = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            String pass = new Prefs().getString(Prefs.DB_PASSWORD);
            String userName = new Prefs().getString(Prefs.DB_USERNAME);
            connection = DriverManager.getConnection(url,userName,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Storage getInstance() {
        return INSTANCE;
    }
    public Connection getConnection() {
        return connection;
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()){
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
