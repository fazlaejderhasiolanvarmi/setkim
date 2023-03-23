package com.setkim.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static void connect(){
        String path = "jdbc:sqlite:C:\\Users\\burak.celtik\\IdeaProjects\\setkim\\Deployment\\setkim.db";
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(path);

            System.out.println("Connection established.");

        } catch (Exception e) {

            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (Exception e) {

                e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

            }
        }
    }

    public static void main(String[] args){
        connect();
    }

}
