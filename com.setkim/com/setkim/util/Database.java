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
    DB Tables: * Musteri
               * Siparis
     */

    private static Connection connection;

    public static List<Object> showMainTable() {

        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM SiparisBilgisi";

        List<Object> table = new ArrayList<>();

        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    List<Object> row = new ArrayList<>();

                    int musteriNo = (int) resultSet.getObject("MusteriNo");

                    String musteriAdi = getMusteriAdiFromMusteriNo(musteriNo);

                    row.add(musteriAdi);

                    String boyananMalzeme = (String) resultSet.getObject(2);

                    row.add(boyananMalzeme);

                    double tutar = (double) resultSet.getObject(12);

                    row.add(tutar);

                    String alimTarihi = (String) resultSet.getObject(14);

                    row.add(alimTarihi);

                    String teslimTarihi = (String) resultSet.getObject(15);

                    row.add(teslimTarihi);

                    table.add(row);
                }

            } catch (Exception e) {
                e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir
            }

        } else {
            connect();
            table = showMainTable();
            closeConnection();
        }

        return table;
    }

    public static void insertToSiparisBilgisi(String boyananMalzeme, String malzemeCinsi, String yuzeyIslem, String renkKodu, double boyaMiktari, double iscilikSuresi, double boyananMalzemeMiktari, String birim, int hat, double boyamaFiyati, double tutar, String alimTarihi, String teslimTarihi, String irsaliyeNo, String faturaNo, int vade) {

        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO SiparisBilgisi (Boyanan_Malzeme, Malzeme_Cinsi, Yuzey_Islem, Renk_Kodu, Boya_Miktari, Iscilik_Suresi, Boyanan_Malzeme_Miktari, Birimi, Hat, Boyama_Fiyati, Tutar, AlimTarihi, TeslimTarihi, IrsaliyeNo, FaturaNo, Vade)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        if (connection != null) {

            try {
                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, boyananMalzeme);
                preparedStatement.setString(2, malzemeCinsi);
                preparedStatement.setString(3, yuzeyIslem);
                preparedStatement.setString(4, renkKodu);
                preparedStatement.setDouble(5, boyaMiktari);
                preparedStatement.setDouble(6, iscilikSuresi);
                preparedStatement.setDouble(7, boyananMalzemeMiktari);
                preparedStatement.setString(8, birim);
                preparedStatement.setInt(9, hat);
                preparedStatement.setDouble(10, boyamaFiyati);
                preparedStatement.setDouble(11, tutar);
                preparedStatement.setString(12, alimTarihi);
                preparedStatement.setString(13, teslimTarihi);
                preparedStatement.setString(14, irsaliyeNo);
                preparedStatement.setString(15, faturaNo);
                preparedStatement.setInt(16, vade);

                preparedStatement.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            connect();
            insertToSiparisBilgisi(boyananMalzeme, malzemeCinsi, yuzeyIslem, renkKodu, boyaMiktari, iscilikSuresi, boyananMalzemeMiktari, birim, hat, boyamaFiyati, tutar, alimTarihi, teslimTarihi, irsaliyeNo, faturaNo, vade);
            closeConnection();
        }

    }

    public static void insertToSetkimMain(String boyananMalzeme, String malzemeCinsi, String yuzeyIslem, String renkKodu, double boyaMiktari, double iscilikSuresi, double boyananMalzemeMiktari, String birimi, int hat, double boyamaFiyati, double tutar) {

        PreparedStatement preparedStatement = null;

        String query = "insert into SiparisBilgisi (Boyanan_Malzeme, Malzeme_Cinsi, Yuzey_Islem, Renk_Kodu, Boya_Miktari, Iscilik_Suresi, Boyanan_Malzeme_Miktari, Birimi, Hat, Boyama_Fiyati, Tutar)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, boyananMalzeme);
                preparedStatement.setString(2, malzemeCinsi);
                preparedStatement.setString(3, yuzeyIslem);
                preparedStatement.setString(4, renkKodu);
                preparedStatement.setDouble(5, boyaMiktari);
                preparedStatement.setDouble(6, iscilikSuresi);
                preparedStatement.setDouble(7, boyananMalzemeMiktari);
                preparedStatement.setString(8, birimi);
                preparedStatement.setInt(9, hat);
                preparedStatement.setDouble(10, boyamaFiyati);
                preparedStatement.setDouble(11, tutar);

                preparedStatement.executeUpdate();

            } catch (Exception e) {

                e.printStackTrace();

            }


        } else {

            connect();
            insertToSetkimMain(boyananMalzeme, malzemeCinsi, yuzeyIslem, renkKodu, boyaMiktari, iscilikSuresi, boyananMalzemeMiktari, birimi, hat, boyamaFiyati, tutar);
            closeConnection();

        }
    }

    public static void insertToMusteri(String musteriAdi, int belgeNo, String adres, String vergiDairesi, String vergiNo, String yetkili) {

        PreparedStatement preparedStatement = null;

        String query = "insert into Musteri (Musteri_Adı, Belge_No, Adres, Vergi_Dairesi, Vergi_No, Yetkili)" +
                "values (?, ?, ?, ?, ?, ?)";

        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, musteriAdi);
                preparedStatement.setInt(2, belgeNo);
                preparedStatement.setString(3, adres);
                preparedStatement.setString(4, vergiDairesi);
                preparedStatement.setString(5, vergiNo);
                preparedStatement.setString(6, yetkili);

                preparedStatement.executeUpdate();

            } catch (Exception e) {

                e.printStackTrace();

            }

        } else {
            connect();
            insertToMusteri(musteriAdi, belgeNo, adres, vergiDairesi, vergiNo, yetkili);
            closeConnection();
        }

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
                connection = null;

            }

        } catch (Exception e) {

            e.printStackTrace(); //Beğenmeyen ağlayarak günlüğüne yazabilir

        }
    }

    public static List<Object> getMusteriFromMusteriName(String musteriName) {

        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM Musteri WHERE Musteri_Adi = " + musteriName;

        List<Object> musteriBilgisi = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            for (int i = 1; i < 8; i++) {
                musteriBilgisi.add(resultSet.getObject(i));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return musteriBilgisi;
    }

    private static String getMusteriAdiFromMusteriNo(int musteriNo) {

        PreparedStatement preparedStatement = null;

        String query = "SELECT Musteri_Adı FROM Musteri WHERE Musteri_No = " + musteriNo;

        try {
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                return resultSet.getString("Musteri_Adı");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
