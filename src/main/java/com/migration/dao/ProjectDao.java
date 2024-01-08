package com.migration.dao;

import com.migration.entity.Project;
import com.migration.storage.Storage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class ProjectDao {
    private static final String INSERT_PROJECT_PREPARED_STATEMENT = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES(?,?,?)";

    public static void save(List<Project> project) {
        try
        {
            Connection connection = Storage.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_PREPARED_STATEMENT);
            connection.setAutoCommit(false);
            for(Project wr: project) {
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
    private static void populatePreparedStatement(Project project, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, project.getClientId());
        preparedStatement.setString(2, String.valueOf(project.getStartDate()));
        preparedStatement.setString(3, String.valueOf(project.getFinishDate()));
    }

}
