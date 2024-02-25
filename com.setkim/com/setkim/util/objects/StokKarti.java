package com.setkim.util.objects;

public class StokKarti {

    private int stokKartiNo;
    private String stokKartiAdi;

    public StokKarti() {
    }

    public StokKarti(String stokKartiAdi) {
        this.stokKartiAdi = stokKartiAdi;
    }

    public String getStokKartiAdi() {
        return stokKartiAdi;
    }

    public void setStokKartiAdi(String stokKartiAdi) {
        this.stokKartiAdi = stokKartiAdi;
    }

    public int getStokKartiNo() {
        return stokKartiNo;
    }

    public void setStokKartiNo(int stokKartiNo) {
        this.stokKartiNo = stokKartiNo;
    }
}
