package com.setkim.util.objects;

public class Musteri {
    private int musteriNo;
    private String musteriAdi;
    private int belgeNo;
    private String adres;
    private String vergiDairesi;
    private String vergiNo;
    private String yetkili;

    public Musteri(int musteriNo, String musteriAdi, int belgeNo, String adres, String vergiDairesi, String vergiNo, String yetkili) {
        this.musteriNo = musteriNo;
        this.musteriAdi = musteriAdi;
        this.belgeNo = belgeNo;
        this.adres = adres;
        this.vergiDairesi = vergiDairesi;
        this.vergiNo = vergiNo;
        this.yetkili = yetkili;
    }

    public Musteri() {
    }

    public int getMusteriNo() {
        return musteriNo;
    }

    public void setMusteriNo(int musteriNo) {
        this.musteriNo = musteriNo;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public int getBelgeNo() {
        return belgeNo;
    }

    public void setBelgeNo(int belgeNo) {
        this.belgeNo = belgeNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getVergiDairesi() {
        return vergiDairesi;
    }

    public void setVergiDairesi(String vergiDairesi) {
        this.vergiDairesi = vergiDairesi;
    }

    public String getVergiNo() {
        return vergiNo;
    }

    public void setVergiNo(String vergiNo) {
        this.vergiNo = vergiNo;
    }

    public String getYetkili() {
        return yetkili;
    }

    public void setYetkili(String yetkili) {
        this.yetkili = yetkili;
    }
}
