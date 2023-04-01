package com.setkim.ekleme.panels.musteri;

public class MusteriController {

    private MusteriPanel view;

    public MusteriController(){
        view = new MusteriPanel();

        view.getBtnEkle().addActionListener(e -> {
            // TODO: textfiedl alınıp databaseye eklenecek.
        });

    }

    public MusteriPanel getView() {
        return view;
    }
}
