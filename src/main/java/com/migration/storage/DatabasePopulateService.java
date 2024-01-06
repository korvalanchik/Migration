package com.migration.storage;

import com.migration.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static final String DB_POPULATE = "populateDb";
    public void setDbPopulate(Storage storage) {
        try {
            String populateDb = new Prefs().getString(DB_POPULATE);
            String sql = String.join("\n", Files.readAllLines(Paths.get(populateDb)));
            storage.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
