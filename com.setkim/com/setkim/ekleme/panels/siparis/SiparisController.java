package com.setkim.ekleme.panels.siparis;

public class SiparisController {

    private SiparisPanel view;

    public SiparisController(){
        view = new SiparisPanel();

        view.getBtnEkle().addActionListener(e -> {
            // TODO: textfiedl alınıp databaseye eklenecek.
        });

    }

    public SiparisPanel getView() {
        return view;
    }
}
