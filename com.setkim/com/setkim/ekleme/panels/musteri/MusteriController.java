package com.setkim.ekleme.panels.musteri;

import com.setkim.util.Database;

import javax.swing.*;

public class MusteriController {

    private MusteriPanel view;

    public MusteriController() {
        view = new MusteriPanel();

        view.getBtnEkle().addActionListener(e -> {
            String satirAdi = "";
            try {
                satirAdi = "Müşteri Adı";
                String musteriAdi = view.getTextFieldMusteriAdi().getText();
                satirAdi = "Belge Numarası";
                int belgeNo = Integer.parseInt(view.getTextFieldBelgeNo().getText());
                satirAdi = "Adres";
                String adres = view.getTextFieldAdres().getText();
                satirAdi = "Vergi Dairesi";
                String vergiDairesi = view.getTextFieldVergiDairesi().getText();
                satirAdi = "Vergi Numarası";
                String vergiNo = view.getTextFieldVergiNo().getText();
                satirAdi = "Yetkili";
                String yetkili = view.getTextFieldYetkili().getText();
                Database.insertToMusteri(
                        musteriAdi,
                        belgeNo,
                        adres,
                        vergiDairesi,
                        vergiNo,
                        yetkili
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Bilgiler eklendi!",
                        "Başarılı",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        satirAdi + " yanlış girildi.",
                        "Başarısız",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

    }

    public MusteriPanel getView() {
        return view;
    }
}
