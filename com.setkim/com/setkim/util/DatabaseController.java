package com.setkim.util;

import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.SiparisBilgisi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    /*
    DB Tables: * Musteri
               * Siparis
     */

    private static Connection connection;

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

    public static List<Musteri> getMusteriListFromDatabase() {

        List<Musteri> musteriList = new ArrayList<>();
        PreparedStatement preparedStatement;

        String query = "SELECT * FROM Musteri";

        if (connection != null) {
            try {

                preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Musteri musteri = new Musteri();

                    musteri.setMusteriNo(resultSet.getInt(1));
                    musteri.setMusteriAdi(resultSet.getString(2));
                    musteri.setBelgeNo(resultSet.getInt(3));
                    musteri.setAdres(resultSet.getString(4));
                    musteri.setVergiDairesi(resultSet.getString(5));
                    musteri.setVergiNo(resultSet.getString(6));
                    musteri.setYetkili(resultSet.getString(7));

                    musteriList.add(musteri);
                }

            } catch (Exception e) {
                e.printStackTrace(); //beğenmeyen ağlayarak günlüğüne yazabilir
            }

        } else {
            connect();
            musteriList = getMusteriListFromDatabase();
            closeConnection();
        }

        return musteriList;
    }

    public static List<SiparisBilgisi> getSiparisListFromDatabase() {

        List<SiparisBilgisi> siparisBilgisiList = new ArrayList<>();
        PreparedStatement preparedStatement;

        String query = "SELECT * FROM SiparisBilgisi";

        if (connection != null) {

            try {
                preparedStatement = connection.prepareStatement(query);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    SiparisBilgisi siparisBilgisi = new SiparisBilgisi();

                    siparisBilgisi.setSiparisNo(resultSet.getInt(1));
                    siparisBilgisi.setBoyananMalzeme(resultSet.getString(2));
                    siparisBilgisi.setMalzemeCinsi(resultSet.getString(3));
                    siparisBilgisi.setYuzeyIslem(resultSet.getString(4));
                    siparisBilgisi.setRenkKodu(resultSet.getString(5));
                    siparisBilgisi.setBoyaMiktari(resultSet.getDouble(6));
                    siparisBilgisi.setIscilikSuresi(resultSet.getDouble(7));
                    siparisBilgisi.setBoyananMalzemeMiktari(resultSet.getDouble(8));
                    siparisBilgisi.setBirim(resultSet.getString(9));
                    siparisBilgisi.setHat(resultSet.getInt(10));
                    siparisBilgisi.setBoyamaFiyati(resultSet.getDouble(11));
                    siparisBilgisi.setTutar(resultSet.getDouble(12));
                    siparisBilgisi.setMusteri(DatabaseObjectList.findMusteriWithMusteriNo(resultSet.getInt(13)));
                    siparisBilgisi.setAlimTarihi(new SimpleDateFormat("dd/MM/yyyy").parse(resultSet.getString(14)));
                    siparisBilgisi.setTeslimTarihi(new SimpleDateFormat("dd/MM/yyyy").parse(resultSet.getString(15)));
                    siparisBilgisi.setIrsaliyeNo(resultSet.getString(16));
                    siparisBilgisi.setFaturaNo(resultSet.getString(17));
                    siparisBilgisi.setVade(resultSet.getInt(18));

                    siparisBilgisiList.add(siparisBilgisi);
                }

            } catch (Exception e) {
                e.printStackTrace(); // beğenmeyen ağlayarak günlüğüne yazabilir
            }

        } else {
            connect();
            siparisBilgisiList = getSiparisListFromDatabase();
            closeConnection();
        }

        return siparisBilgisiList;


    }

}