package com.setkim.ekleme.panels.musteri;

import com.setkim.util.DatabaseController;

import javax.swing.*;

public class MusteriController {

    private MusteriPanel view;

    public MusteriController() {
        view = new MusteriPanel();

        view.getBtnEkle().addActionListener(e -> {
            DatabaseController.insertToMusteri(
                    view.getTextFieldMusteriAdi().getText(),
                    Integer.valueOf(view.getTextFieldBelgeNo().getText()),
                    view.getTextFieldAdres().getText(),
                    view.getTextFieldVergiDairesi().getText(),
                    view.getTextFieldVergiNo().getText(),
                    view.getTextFieldYetkili().getText()
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Bilgiler eklendi!",
                    "Başarılı",
                    JOptionPane.INFORMATION_MESSAGE);
        });

    }

    public MusteriPanel getView() {
        return view;
    }
}
