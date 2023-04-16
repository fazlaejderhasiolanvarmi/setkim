package com.setkim.ekleme.panels.musteri;

import com.setkim.util.Database;

public class MusteriController {

    private MusteriPanel view;

    public MusteriController() {
        view = new MusteriPanel();

        view.getBtnEkle().addActionListener(e -> {
            Database.insertToMusteri(
                    view.getTextFieldMusteriAdi().getText(),
                    Integer.valueOf(view.getTextFieldBelgeNo().getText()),
                    view.getTextFieldAdres().getText(),
                    view.getTextFieldVergiDairesi().getText(),
                    view.getTextFieldVergiNo().getText(),
                    view.getTextFieldYetkili().getText()
            );
        });

    }

    public MusteriPanel getView() {
        return view;
    }
}
