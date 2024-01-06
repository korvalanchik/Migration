package com.migration.dao;

import com.migration.emptity.Client;
import com.migration.storage.Storage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class ClientDao {
    private static final String INSERT_CLIENT_PREPARED_STATEMENT = "INSERT INTO client (`NAME`) VALUES (?)";

    public static void save(List<Client> client) {
        try
        {
            Connection connection = Storage.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_PREPARED_STATEMENT);
            connection.setAutoCommit(false);
            for(Client cl: client) {
                populatePreparedStatement(cl, preparedStatement);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void populatePreparedStatement(Client client, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, client.getName());
    }
}
