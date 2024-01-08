package com.migration.dao;

import com.migration.entity.Client;
import com.migration.storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientDao {
    private final PreparedStatement createSt;
    private final PreparedStatement getByIdSt;
    private final PreparedStatement setNameSt;
    private final PreparedStatement listAllSt;
    private final PreparedStatement deleteByIdSt;

    public ClientDao() throws SQLException {
        Connection connection = Storage.getInstance().getConnection();
        createSt = connection.prepareStatement(
                        "INSERT INTO client (`NAME`) VALUES (?)", new String[] {"ID"});
        getByIdSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
        listAllSt = connection.prepareStatement("SELECT id, name FROM client");
        setNameSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
        deleteByIdSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
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
        return 0L;
    }
    public String selectById(long id) {
        try {
            PreparedStatement preparedStatement = getByIdSt;
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean saveName(long id, String name) {
        try {
            PreparedStatement preparedStatement = setNameSt;
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            int res = preparedStatement.executeUpdate();
            if(res > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean removeById(long id) {
        try {
            PreparedStatement preparedStatement = deleteByIdSt;
            preparedStatement.setLong(1, id);
            int res = preparedStatement.executeUpdate();
            if(res > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Client> selectAll() {
        List<Client> clients = new ArrayList<>();
        try {
            ResultSet rs = listAllSt.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                String name = rs.getString("name");
                if(name.length() < 3 || name.length() > 30) {
                    return Collections.emptyList();
                }
                client.setName(name);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;

    }
    private void populatePreparedStatement(Client client, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, client.getName());
    }
}
