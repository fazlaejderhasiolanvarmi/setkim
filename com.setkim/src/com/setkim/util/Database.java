package com.setkim.util;

import com.setkim.config.CommonConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    /*
    DB Tables:
               * Musteri
               * Setkim_Main
               * Siparis_Detay
     */
    private static Connection connection;

    private static boolean isConnected = false;

    public static void connect(){
        String path = "jdbc:sqlite:" + CommonConfig.path;
        connection = null;

        try {

            connection = DriverManager.getConnection(path);

            isConnected = true;

        } catch (Exception e) {

            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

        }
    }

    public static void insert(){
        //TODO: Insert Query gelecek
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("");

            ps.setInt(1, 3);
            ps.setInt(2, 2);
            ps.setInt(3, 1);
            ps.setInt(4, 2);
            ps.setFloat(5, 300);
            ps.setFloat(6, 56);
            ps.setDouble(7, 4.8);
            ps.setString(8, "metrekare");
            ps.setInt(9, 1);
            ps.setFloat(10, 700);
            ps.setDouble(11, 3879.95);

            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void delete(){
        //TODO: Delete Query gelecek
    }

    public static void update(){

        //TODO: Update Query gelecek

    }

    public static void show(){
        PreparedStatement ps = null;

        //if(isConnected) sonradan eklenecek connection test
        //if(connection != null) 'da kullanılabilir

        String query = "";

        try {
            ps = connection.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                System.out.print("index: " + resultSet.getInt("index"));
                System.out.print(",\t Name: " + resultSet.getString("Name"));
                System.out.println();
            }

        } catch (Exception e){
            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir
        }finally {
            try {
                ps.close();
            } catch (Exception e){
                e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir
            }
        }
    }

    public static List<Object> showSetkimMain(){
        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM Setkim_Main";

        List<Object> table = new ArrayList<>();

        if (connection != null){

            try {

                preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    List<Object> row = new ArrayList<>();

                    for (int i = 2; i < 13; i++) {
                        row.add(resultSet.getObject(i));
                    }

                    table.add(row);
                }

            } catch (Exception e) {
                e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir
            }

        }

        return table;

    }

    public static List<Object> showMusteri(){

        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM Musteri";

        List<Object> table = new ArrayList<>();

        if (connection != null){

            try {

                preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    List<Object> row = new ArrayList<>();

                    for (int i = 2; i < 9; i++) {
                        row.add(resultSet.getObject(i));
                    }

                    table.add(row);
                }

            } catch (Exception e) {
                e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir
            }

        }

        return table;
    }

    public static void closeConnection(){
        try {
            if (connection != null){

                connection.close();
                System.out.println("Connection closed.");
                isConnected = false;

            }
        } catch (Exception e) {

            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

        }
    }

    //Bağlantı sağlanıyor mu kontrolleri, silinecek
    public static void main(String[] args){
        connect();
        showSetkimMain();
        closeConnection();
    }

}
