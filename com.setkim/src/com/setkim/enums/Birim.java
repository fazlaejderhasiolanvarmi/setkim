package com.setkim.enums;

public enum Birim {

    //Bu gerçekten gerekli bir enum mı konuşulsun

    M2(0, "metrekare"),
    KG(1,"kilogram"),
    ADET(2, "adet"),
    TAKIM(3, "takım");

    private int index;
    private String name;

    private Birim(int index, String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
