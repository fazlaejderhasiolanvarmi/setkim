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

    public static void deleteMusteriListFromDatabase() {

        PreparedStatement preparedStatement;
        String query = "DELETE FROM Musteri";

        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();

            } catch (Exception e) {

                e.printStackTrace();

            }

        } else {
            connect();
            deleteMusteriListFromDatabase();
            closeConnection();
        }
    }

    public static void saveMusteriListToDatabase(List<Musteri> musteriList) {

        PreparedStatement preparedStatement;
        String query = "INSERT INTO Musteri (Musteri_No, Musteri_Adi, Belge_No, Adres, Vergi_Dairesi, Vergi_No, Yetkili) VALUES (?,?,?,?,?,?,?)";

        if (connection != null) {
            try {

                preparedStatement = connection.prepareStatement(query);
                for (Musteri musteri : musteriList) {

                    preparedStatement.setInt(1, musteri.getMusteriNo());
                    preparedStatement.setString(2, musteri.getMusteriAdi());
                    preparedStatement.setInt(3, musteri.getBelgeNo());
                    preparedStatement.setString(4, musteri.getAdres());
                    preparedStatement.setString(5, musteri.getVergiDairesi());
                    preparedStatement.setString(6, musteri.getVergiNo());
                    preparedStatement.setString(7, musteri.getYetkili());

                    preparedStatement.addBatch();
                }

                preparedStatement.executeBatch();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            connect();
            saveMusteriListToDatabase(musteriList);
            closeConnection();
        }

    }

    public static void deleteSiparisListFromDatabase() {

        PreparedStatement preparedStatement;
        String query = "DELETE FROM SiparisBilgisi";

        if (connection != null) {

            try {

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();

            } catch (Exception e) {

                e.printStackTrace();

            }

        } else {
            connect();
            deleteSiparisListFromDatabase();
            closeConnection();
        }
    }

    public static void saveSiparisListToDatabase(List<SiparisBilgisi> siparisList) {

        PreparedStatement preparedStatement;
        String query = "INSERT INTO SiparisBilgisi (Boyanan_Malzeme, Malzeme_Cinsi, Yuzey_Islem, Renk_Kodu, Boya_Miktari, Iscilik_Suresi,\n" +
                "                            Boyanan_Malzeme_Miktari, Birimi, Hat, Boyama_Fiyati, Tutar, MusteriNo, AlimTarihi,\n" +
                "                            TeslimTarihi, IrsaliyeNo, FaturaNo, Vade)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        if (connection != null) {

            try {
                preparedStatement = connection.prepareStatement(query);

                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

                for (SiparisBilgisi siparis : siparisList) {

                    preparedStatement.setString(1, siparis.getBoyananMalzeme());
                    preparedStatement.setString(2, siparis.getMalzemeCinsi());
                    preparedStatement.setString(3, siparis.getYuzeyIslem());
                    preparedStatement.setString(4, siparis.getRenkKodu());
                    preparedStatement.setDouble(5, siparis.getBoyaMiktari());
                    preparedStatement.setDouble(6, siparis.getIscilikSuresi());
                    preparedStatement.setDouble(7, siparis.getBoyananMalzemeMiktari());
                    preparedStatement.setString(8, siparis.getBirim());
                    preparedStatement.setInt(9, siparis.getHat());
                    preparedStatement.setDouble(10, siparis.getBoyamaFiyati());
                    preparedStatement.setDouble(11, siparis.getTutar());
                    preparedStatement.setObject(12, siparis.getMusteri().getMusteriNo());
                    preparedStatement.setString(13, f.format(siparis.getAlimTarihi()));
                    preparedStatement.setString(14, f.format(siparis.getTeslimTarihi()));
                    preparedStatement.setString(15, siparis.getIrsaliyeNo());
                    preparedStatement.setString(16, siparis.getFaturaNo());
                    preparedStatement.setInt(17, siparis.getVade());

                    preparedStatement.addBatch();
                }

                preparedStatement.executeBatch();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            connect();
            saveSiparisListToDatabase(siparisList);
            closeConnection();
        }

    }
}