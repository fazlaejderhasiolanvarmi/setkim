package com.setkim.ekleme.panels.musteri;

import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.Musteri;

import javax.swing.*;

public class MusteriController {

    private MusteriPanel view;

    public MusteriController() {
        view = new MusteriPanel();

        view.getBtnEkle().addActionListener(e -> {

            Musteri musteri = new Musteri();

            musteri.setMusteriNo(DatabaseObjectList.getMaxMusteriNo());
            musteri.setMusteriAdi(view.getTextFieldMusteriAdi().getText());
            musteri.setBelgeNo(Integer.valueOf(view.getTextFieldBelgeNo().getText()));
            musteri.setAdres(view.getTextFieldAdres().getText());
            musteri.setVergiDairesi(view.getTextFieldVergiDairesi().getText());
            musteri.setVergiNo(view.getTextFieldVergiNo().getText());
            musteri.setYetkili(view.getTextFieldYetkili().getText());

            DatabaseObjectList.addMusteriToList(musteri);

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
