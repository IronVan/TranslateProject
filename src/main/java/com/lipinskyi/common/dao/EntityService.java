package com.lipinskyi.common.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EntityService implements IEntity {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    public List selectAll() {

        ArrayList<Entity> entities = new ArrayList<>();

        registerDriver();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT id, region1, locality FROM sample_geopc_ad_places");
            while (resultSet.next()) {
                Entity entity = new Entity();
                entity.setId(resultSet.getInt("id"));
                entity.setRegion(resultSet.getString("region1"));
                entity.setLocality(resultSet.getString("locality"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return entities;
    }

    @Override
    public Entity getEntityByID(int id) {

        registerDriver();
        Entity entity = new Entity();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT region1, locality FROM sample_geopc_ad_places WHERE id=" + id);
            if (resultSet.next()) {
                entity.setId(id);
                entity.setRegion(resultSet.getString("region1"));
                entity.setLocality(resultSet.getString("locality"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    private void registerDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
