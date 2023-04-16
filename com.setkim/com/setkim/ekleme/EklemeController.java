package com.setkim.ekleme;

import com.setkim.ekleme.panels.musteri.MusteriController;
import com.setkim.ekleme.panels.siparis.SiparisController;
import com.setkim.ekleme.panels.siparisdetay.SiparisDetayController;

import javax.swing.*;

public class EklemeController {

    private EklemePanel view;

    private MusteriController musteriController;

    private SiparisController siparisController;

    private SiparisDetayController siparisDetayController;

    public EklemeController(){
        view = new EklemePanel();

        musteriController = new MusteriController();
        siparisController = new SiparisController();
        siparisDetayController = new SiparisDetayController();



    }


    public JPanel getView() {
        return view;
    }
}
