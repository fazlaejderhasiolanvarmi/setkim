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

    public List<SiparisBilgisi> getSiparisBilgisiList() {
        return siparisBilgisiList;
    }
}
