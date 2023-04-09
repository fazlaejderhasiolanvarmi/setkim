package com.setkim.util;

import com.setkim.config.CommonConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {

    /*
    DB Tables: * Boyanan_Malzeme,
               * Malzeme_Cinsi,
               * Renk_Kodu,
               * Yuzey_Islem,
               * Setkim_Main
               * Test
     */

    public static final String INSERT = "INSERT INTO Setkim_Main(Boyanan_Malzeme, Malzeme_Cinsi, Yuzey_Islem, Renk_Kodu, Boya_Miktari, Iscilik_Suresi, Boyanan_Malzeme_Miktari, Birimi, Hat, Boyama_Fiyati, Tutar) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    public static final String DELETE = "";
    public static final String UPDATE = "";
    public static final String SHOW = "SELECT * FROM main.Boyanan_Malzeme";

    private static Connection connection;

    private static boolean isConnected = false;

    public static void connect(){
        String path = "jdbc:sqlite:" + CommonConfig.path;
        connection = null;

        try {

            connection = DriverManager.getConnection(path);

            System.out.println("Connection established.");

            isConnected = true;

        } catch (Exception e) {

            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

        }
    }

    public static void insert(){
        //TODO: Insert Query gelecek
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(INSERT);

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

        try {
            ps = connection.prepareStatement(SHOW);

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
        insert();
        closeConnection();
    }

}