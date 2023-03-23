package com.setkim.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    /*
    DB Tables: * Boyanan_Malzeme,
               * Malzeme_Cinsi,
               * Renk_Kodu,
               * Yuzey_Islem,
               * Setkim_Main
     */

    public static final String INSERT = "";
    public static final String DELETE = "";
    public static final String UPDATE = "";

    public static void connect(){
        String path = "jdbc:sqlite:C:\\Users\\burak.celtik\\IdeaProjects\\setkim\\Deployment\\setkim.db"; //Değişecek
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

    public static void insert(){

    }

    public static void delete(){

    }

    public static void update(){

    }

    //Bağlantı sağlanıyor mu kontrolleri, silinecek
    public static void main(String[] args){
        connect();
    }

}
