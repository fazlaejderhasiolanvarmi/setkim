package com.setkim.util;

import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.SiparisBilgisi;
import com.setkim.util.objects.Stok;
import com.setkim.util.objects.StokKarti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseObjectList {

    private static List<Musteri> musteriList = new ArrayList<>();
    private static List<SiparisBilgisi> siparisBilgisiList = new ArrayList<>();
    private static List<Stok> stokList = new ArrayList<>();
    private static List<StokKarti> stokKartiList = new ArrayList<>();

    public static void fillListsFromDatabase() {
        musteriList = DatabaseController.getMusteriListFromDatabase();
        siparisBilgisiList = DatabaseController.getSiparisListFromDatabase();
        stokKartiList = DatabaseController.getStokKartiListFromDatabase();
        stokList = DatabaseController.getStokListFromDatabase();
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

    public static List<Stok> getStokList() {
        return stokList;
    }

    public static List<StokKarti> getStokKartiList() {
        return stokKartiList;
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

    public static List<Object> getStokTableList() {

        List<Object> tableStokList = new ArrayList<>();

        for (Stok stok : stokList) {
            List<Object> row = new ArrayList<>();

            row.add(stok.getStokKodu());
            row.add(stok.getStokAdi());
            row.add(stok.getBirim());
            row.add(stok.getFiyat());
            row.add(stok.getMiktar());
            row.add(stok.getTutar());

            tableStokList.add(row);
        }

        return tableStokList;
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

    public static List<SiparisBilgisi> findSiparisBetweenDates(Date baslangicTarihi, Date bitisTarihi) {

        List<SiparisBilgisi> filteredSiparisList = new ArrayList<>();

        for (SiparisBilgisi siparis : siparisBilgisiList) {

            if (siparis.getAlimTarihi().after(baslangicTarihi) && siparis.getAlimTarihi().before(bitisTarihi)) {

                filteredSiparisList.add(siparis);

            } else if (siparis.getAlimTarihi().equals(baslangicTarihi) || siparis.getAlimTarihi().equals(bitisTarihi)) {
                // Alım tarihiyle aynı tarihse onu da almak için equals attım

                filteredSiparisList.add(siparis);
            }

        }

        return filteredSiparisList;
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

    public static List<Object> getSiparisListOfMusteriWithDate(Musteri musteri, Date baslangicTarihi, Date bitisTarihi) {

        List<Object> siparisListOfMusteri = getSiparisListOfMusteri(musteri);

        List<Object> filteredSiparisListOfMusteri = new ArrayList<>();

        for (Object obj : siparisListOfMusteri) {

            List<Object> siparis = (List<Object>) obj;

            Date alimTarihi = (Date) siparis.get(11);
            Date teslimTarihi = (Date) siparis.get(12);

            if (alimTarihi.after(baslangicTarihi) && teslimTarihi.before(bitisTarihi)) {
                filteredSiparisListOfMusteri.add(obj);
            } else if (alimTarihi.equals(baslangicTarihi) || teslimTarihi.equals(bitisTarihi)) {
                filteredSiparisListOfMusteri.add(obj);
            }

        }

        return filteredSiparisListOfMusteri;
    }

    public static List<Object> getFilteredStokList(StokKarti stokKarti) {

        List<Object> tableData = new ArrayList<>();

        for (Stok stok : stokList) {
            if (stokKarti.getStokKartiNo() == stok.getStokKarti().getStokKartiNo()) {

                List<Object> row = new ArrayList<>();

                row.add(stok.getStokKodu());
                row.add(stok.getStokAdi());
                row.add(stok.getBirim());
                row.add(stok.getFiyat());
                row.add(stok.getMiktar());
                row.add(stok.getTutar());

                tableData.add(row);
            }
        }

        return tableData;
    }

    public static void addStokKartiToList(StokKarti stokKarti) {

        stokKarti.setStokKartiNo(getMaxStokKartiNo() + 1);

        stokKartiList.add(stokKarti);
    }

    private static int getMaxStokKartiNo() {
        int max = -1;

        for (StokKarti stokKarti : stokKartiList) {

            if (stokKarti.getStokKartiNo() > max) {
                max = stokKarti.getStokKartiNo();
            }
        }

        return max;
    }

    public static void addStokToList(Stok stok) {

        stok.setStokNo(getMaxStokNo() + 1);

        stokList.add(stok);
    }

    private static int getMaxStokNo() {

        int max = -1;

        for (Stok stok : stokList) {

            if (stok.getStokNo() > max) {
                max = stok.getStokNo();
            }
        }

        return max;
    }

    public static void saveStokKartiList() {
        DatabaseController.deleteStokKartiListFromDatabase();
        DatabaseController.saveStokKartiListToDatabase(stokKartiList);
    }

    public static void saveStokList() {
        DatabaseController.deleteStokListFromDatabase();
        DatabaseController.saveStokListToDatabase(stokList);
    }

    public static StokKarti getStokKartiWithStokKartiNo(int stokKartiNo) {

        for (StokKarti stokKarti : stokKartiList) {

            if (stokKarti.getStokKartiNo() == stokKartiNo) {
                return stokKarti;
            }

        }

        return null;
    }
}
