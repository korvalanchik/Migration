package com.migration.dao;

import com.migration.entity.Client;
import com.migration.storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/*
String getById(long id) - повертає назву клієнта з ідентифікатором id
void setName(long id, String name) - встановлює нове ім'я name для клієнта з ідентифікатором id
void deleteById(long id) - видаляє клієнта з ідентифікатором id
List<Client> listAll() - повертає всіх клієнтів з БД у вигляді колекції об'єктів типу Client (цей клас створи сам, у ньому має бути 2 поля - id та name)

 */

//@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class ClientDao {
    private final Connection connection = Storage.getInstance().getConnection();
    private final PreparedStatement createSt;
    private final PreparedStatement getByIdSt;
    private PreparedStatement setNameSt;
    private PreparedStatement listAllSt;
    private PreparedStatement deleteByIdSt;

    public ClientDao() throws SQLException {
        createSt = connection.prepareStatement(
                        "INSERT INTO client (`NAME`) VALUES (?)", new String[] {"ID"});
        getByIdSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
        listAllSt = connection.prepareStatement("SELECT id, name FROM client");
        setNameSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
        deleteByIdSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
    }

    public void save(List<Client> client) {
        try {
            PreparedStatement preparedStatement = createSt;
            connection.setAutoCommit(false);
            for(Client cl: client) {
                populatePreparedStatement(cl, preparedStatement);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public long saveClient(Client client) {
        try {
            PreparedStatement preparedStatement = createSt;
            populatePreparedStatement(client, preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String selectById(long id) {
        try {
            PreparedStatement preparedStatement = getByIdSt;
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    private void populatePreparedStatement(Client client, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, client.getName());
    }
}
