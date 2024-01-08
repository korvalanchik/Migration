package com.migration.dao;

import com.migration.entity.Worker;
import com.migration.storage.Storage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class WorkerDao {
    private static final String INSERT_WORKER_PREPARED_STATEMENT = "INSERT INTO worker (`NAME`,`BIRTHDAY`,`LEVEL`,`SALARY`) VALUES(?,?,?,?)";

    public static void save(List<Worker> worker) {
        try
        {
            Connection connection = Storage.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKER_PREPARED_STATEMENT);
            connection.setAutoCommit(false);
            for(Worker wr: worker) {
                populatePreparedStatement(wr, preparedStatement);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void populatePreparedStatement(Worker worker, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, worker.getName());
        preparedStatement.setString(2, String.valueOf(worker.getBirthday()));
        preparedStatement.setString(3, String.valueOf(worker.getLevel()));
        preparedStatement.setInt(4, worker.getSalary());
    }

}
