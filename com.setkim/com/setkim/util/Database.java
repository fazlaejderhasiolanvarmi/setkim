package com.setkim.util;

import com.setkim.config.CommonConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Database {

    /*
    DB Tables: * Setkim_Main
               * Musteri
               * Siparis_Detay
     */

    private static Connection connection;

    public static List<Object> showSetkimMain() {

        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM Setkim_Main";

        List<Object> table = new ArrayList<>();

        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();

                    for (int i = 2; i < 13; i++) {
                        row.add(resultSet.getObject(i));
                    }

                    table.add(row);
                }

            } catch (Exception e) {
                e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir
            }

        } else {
            connect();
            table = showSetkimMain();
            closeConnection();
        }

        return table;
    }

    public static void connect() {
        String path = "jdbc:sqlite:" + CommonConfig.path;
        connection = null;

        try {

            connection = DriverManager.getConnection(path);

        } catch (Exception e) {

            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

        }
    }

    public static void closeConnection() {

        try {
            if (connection != null) {

                connection.close();

            }

        } catch (Exception e) {

            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

        }
    }

}
