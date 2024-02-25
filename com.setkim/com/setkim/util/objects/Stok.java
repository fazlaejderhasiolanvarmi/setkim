package com.setkim.util.objects;

public class Stok {
    private int stokNo;
    private StokKarti stokKarti;
    private String stokKodu;
    private String stokAdi;
    private String birim;
    private double fiyat;
    private int miktar;
    private double tutar;

    public Stok() {
    }

    public Stok(StokKarti stokKarti, String stokKodu, String stokAdi, String birim, double fiyat, int miktar, double tutar) {
        this.stokKarti = stokKarti;
        this.stokKodu = stokKodu;
        this.stokAdi = stokAdi;
        this.birim = birim;
        this.fiyat = fiyat;
        this.miktar = miktar;
        this.tutar = tutar;
    }

    public StokKarti getStokKarti() {
        return stokKarti;
    }

    public void setStokKarti(StokKarti stokKarti) {
        this.stokKarti = stokKarti;
    }

    public String getStokKodu() {
        return stokKodu;
    }

    public void setStokKodu(String stokKodu) {
        this.stokKodu = stokKodu;
    }

    public String getStokAdi() {
        return stokAdi;
    }

    public void setStokAdi(String stokAdi) {
        this.stokAdi = stokAdi;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public int getStokNo() {
        return stokNo;
    }

    public void setStokNo(int stokNo) {
        this.stokNo = stokNo;
    }
}
