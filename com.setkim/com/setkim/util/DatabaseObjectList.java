package com.setkim.util;

import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.SiparisBilgisi;

import java.util.ArrayList;
import java.util.List;

public class DatabaseObjectList {

    private static List<Musteri> musteriList = new ArrayList<>();
    private static List<SiparisBilgisi> siparisBilgisiList = new ArrayList<>();

    public static void fillListsFromDatabase() {
        musteriList = DatabaseController.getMusteriListFromDatabase();
        siparisBilgisiList = DatabaseController.getSiparisListFromDatabase();
    }

    public static List<Musteri> getMusteriList() {
        return musteriList;
    }

    public static Musteri findMusteriWithMusteriNo(int musteriNo) {

        for (Musteri musteri : musteriList) {
            if (musteri.getMusteriNo() == musteriNo) {
                return musteri;
            }
        }

        return null;
    }

    public static SiparisBilgisi findSiparisWithSiparisNo(int siparisNo) {

        for (SiparisBilgisi siparisBilgisi : siparisBilgisiList) {

            if (siparisBilgisi.getSiparisNo() == siparisNo) {
                return siparisBilgisi;
            }

        }

        return null;
    }

    public static List<Object> getMainTableList() {

        List<Object> tableList = new ArrayList<>();

        for (SiparisBilgisi siparis : siparisBilgisiList) {
            List<Object> row = new ArrayList<>();

            row.add(siparis.getMusteri().getMusteriAdi());
            row.add(siparis.getBoyananMalzeme());
            row.add(siparis.getTutar());
            row.add(siparis.getAlimTarihi());
            row.add(siparis.getTeslimTarihi());
            row.add(siparis.getSiparisNo());

            tableList.add(row);
        }

        return tableList;
    }

    public static void addMusteriToList(Musteri musteri) {
        musteri.setMusteriNo(getMaxMusteriNo() + 1);

        musteriList.add(musteri);
    }

    public static int getMaxMusteriNo() {

        int max = -1;

        for (Musteri musteri : musteriList) {
            if (musteri.getMusteriNo() > max) {
                max = musteri.getMusteriNo();
            }
        }

        return max;
    }

    public static void addSiparisToList(SiparisBilgisi siparis) {

        siparis.setSiparisNo(getMaxSiparisNo() + 1);

        siparisBilgisiList.add(siparis);
    }

    public static int getMaxSiparisNo() {

        int max = -1;

        for (SiparisBilgisi siparis : siparisBilgisiList) {

            if (siparis.getSiparisNo() > max) {
                max = siparis.getSiparisNo();
            }

        }

        return max;
    }

    public static List<Object> getSiparisListOfMusteri(Musteri musteri) {

        List<Object> filteredResults = new ArrayList<>();

        for (SiparisBilgisi siparis : siparisBilgisiList) {

            if (siparis.getMusteri().equals(musteri)) {

                List<Object> row = new ArrayList<>();

                row.add(siparis.getBoyananMalzeme());
                row.add(siparis.getMalzemeCinsi());
                row.add(siparis.getYuzeyIslem());
                row.add(siparis.getRenkKodu());
                row.add(siparis.getBoyaMiktari());
                row.add(siparis.getIscilikSuresi());
                row.add(siparis.getBoyananMalzemeMiktari());
                row.add(siparis.getBirim());
                row.add(siparis.getHat());
                row.add(siparis.getBoyamaFiyati());
                row.add(siparis.getTutar());
                row.add(siparis.getAlimTarihi());
                row.add(siparis.getTeslimTarihi());
                row.add(siparis.getIrsaliyeNo());
                row.add(siparis.getFaturaNo());
                row.add(siparis.getVade());
                row.add(siparis.getSiparisNo());

                filteredResults.add(row);
            }
        }

        return filteredResults;
    }

    public static List<Object> getTarihFiltrelemeTable() {

        List<Object> tableData = new ArrayList<>();

        for (SiparisBilgisi siparis : siparisBilgisiList) {
            List<Object> row = new ArrayList<>();

            row.add(siparis.getMusteri().getMusteriAdi());
            row.add(siparis.getBoyananMalzeme());
            row.add(siparis.getMalzemeCinsi());
            row.add(siparis.getYuzeyIslem());
            row.add(siparis.getRenkKodu());
            row.add(siparis.getBoyaMiktari());
            row.add(siparis.getIscilikSuresi());
            row.add(siparis.getBoyananMalzemeMiktari());
            row.add(siparis.getBirim());
            row.add(siparis.getHat());
            row.add(siparis.getBoyamaFiyati());
            row.add(siparis.getTutar());
            row.add(siparis.getAlimTarihi());
            row.add(siparis.getTeslimTarihi());
            row.add(siparis.getIrsaliyeNo());
            row.add(siparis.getFaturaNo());
            row.add(siparis.getVade());
            row.add(siparis.getSiparisNo());

            tableData.add(row);
        }

        return tableData;
    }

    public static List<SiparisBilgisi> getSiparisBilgisiList() {
        return siparisBilgisiList;
    }

    public static void saveMusteriList() {
        DatabaseController.deleteMusteriListFromDatabase();
        DatabaseController.saveMusteriListToDatabase(musteriList);
    }

    public static void saveSiparisList() {
        DatabaseController.deleteSiparisListFromDatabase();
        DatabaseController.saveSiparisListToDatabase(siparisBilgisiList);
    }
}
