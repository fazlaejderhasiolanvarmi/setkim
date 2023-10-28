package com.setkim.util.objects;

import java.util.Date;

public class SiparisBilgisi {

    private int siparisNo;
    private String boyananMalzeme;
    private String malzemeCinsi;
    private String yuzeyIslem;
    private String renkKodu;
    private double boyaMiktari;
    private double iscilikSuresi;
    private double boyananMalzemeMiktari;
    private String birim;
    private int hat;
    private double boyamaFiyati;
    private double tutar;
    private Musteri musteri;
    private Date alimTarihi;
    private Date teslimTarihi;
    private String irsaliyeNo;
    private String faturaNo;
    private int vade;

    public SiparisBilgisi() {
    }

    public SiparisBilgisi(int siparisNo, String boyananMalzeme, String malzemeCinsi, String yuzeyIslem, String renkKodu, double boyaMiktari, double iscilikSuresi, double boyananMalzemeMiktari, String birim, int hat, double boyamaFiyati, double tutar, Musteri musteri, Date alimTarihi, Date teslimTarihi, String irsaliyeNo, String faturaNo, int vade) {
        this.siparisNo = siparisNo;
        this.boyananMalzeme = boyananMalzeme;
        this.malzemeCinsi = malzemeCinsi;
        this.yuzeyIslem = yuzeyIslem;
        this.renkKodu = renkKodu;
        this.boyaMiktari = boyaMiktari;
        this.iscilikSuresi = iscilikSuresi;
        this.boyananMalzemeMiktari = boyananMalzemeMiktari;
        this.birim = birim;
        this.hat = hat;
        this.boyamaFiyati = boyamaFiyati;
        this.tutar = tutar;
        this.musteri = musteri;
        this.alimTarihi = alimTarihi;
        this.teslimTarihi = teslimTarihi;
        this.irsaliyeNo = irsaliyeNo;
        this.faturaNo = faturaNo;
        this.vade = vade;
    }

    public int getSiparisNo() {
        return siparisNo;
    }

    public void setSiparisNo(int siparisNo) {
        this.siparisNo = siparisNo;
    }

    public String getBoyananMalzeme() {
        return boyananMalzeme;
    }

    public void setBoyananMalzeme(String boyananMalzeme) {
        this.boyananMalzeme = boyananMalzeme;
    }

    public String getMalzemeCinsi() {
        return malzemeCinsi;
    }

    public void setMalzemeCinsi(String malzemeCinsi) {
        this.malzemeCinsi = malzemeCinsi;
    }

    public String getYuzeyIslem() {
        return yuzeyIslem;
    }

    public void setYuzeyIslem(String yuzeyIslem) {
        this.yuzeyIslem = yuzeyIslem;
    }

    public String getRenkKodu() {
        return renkKodu;
    }

    public void setRenkKodu(String renkKodu) {
        this.renkKodu = renkKodu;
    }

    public double getBoyaMiktari() {
        return boyaMiktari;
    }

    public void setBoyaMiktari(double boyaMiktari) {
        this.boyaMiktari = boyaMiktari;
    }

    public double getIscilikSuresi() {
        return iscilikSuresi;
    }

    public void setIscilikSuresi(double iscilikSuresi) {
        this.iscilikSuresi = iscilikSuresi;
    }

    public double getBoyananMalzemeMiktari() {
        return boyananMalzemeMiktari;
    }

    public void setBoyananMalzemeMiktari(double boyananMalzemeMiktari) {
        this.boyananMalzemeMiktari = boyananMalzemeMiktari;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public int getHat() {
        return hat;
    }

    public void setHat(int hat) {
        this.hat = hat;
    }

    public double getBoyamaFiyati() {
        return boyamaFiyati;
    }

    public void setBoyamaFiyati(double boyamaFiyati) {
        this.boyamaFiyati = boyamaFiyati;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Date getAlimTarihi() {
        return alimTarihi;
    }

    public void setAlimTarihi(Date alimTarihi) {
        this.alimTarihi = alimTarihi;
    }

    public Date getTeslimTarihi() {
        return teslimTarihi;
    }

    public void setTeslimTarihi(Date teslimTarihi) {
        this.teslimTarihi = teslimTarihi;
    }

    public String getIrsaliyeNo() {
        return irsaliyeNo;
    }

    public void setIrsaliyeNo(String irsaliyeNo) {
        this.irsaliyeNo = irsaliyeNo;
    }

    public String getFaturaNo() {
        return faturaNo;
    }

    public void setFaturaNo(String faturaNo) {
        this.faturaNo = faturaNo;
    }

    public int getVade() {
        return vade;
    }

    public void setVade(int vade) {
        this.vade = vade;
    }
}
