package com.migration.dao;

import com.migration.entity.ProjectWorker;
import com.migration.storage.Storage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class ProjectWorkerDao {
    private static final String INSERT_PROJECTWORKER_PREPARED_STATEMENT =
                                "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?,?)";

    public static void save(List<ProjectWorker> projectWorker) {
        try
        {
            Connection connection = Storage.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECTWORKER_PREPARED_STATEMENT);
            connection.setAutoCommit(false);
            for(ProjectWorker cl: projectWorker) {
                populatePreparedStatement(cl, preparedStatement);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void populatePreparedStatement(ProjectWorker projectWorker, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, projectWorker.getProjectId());
        preparedStatement.setLong(2, projectWorker.getWorkerId());
    }

}
