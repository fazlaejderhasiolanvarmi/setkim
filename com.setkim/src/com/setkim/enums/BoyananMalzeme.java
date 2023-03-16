package com.setkim.enums;

public enum BoyananMalzeme {
    LEVHA(0, "Levha"),
    PROFIL(1, "Profil"),
    KAPI(2, "Kapı"),
    PANO_DOLAP(3, "Pano&Dolap");

    private final int value;
    private final String name;

    private BoyananMalzeme(int value, String name){
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
