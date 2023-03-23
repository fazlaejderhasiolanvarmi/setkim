package com.setkim.enums;

public enum Hat {

    //Bu gerçekten gerekli bir enum mı konuşulsun

    HAT_1(0, "HAT-1"),
    HAT_2(1, "HAT-2");

    private int index;
    private String name;

    private Hat(int index, String name){
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
