package com.setkim.raporlama.secenek;

import com.setkim.raporlama.musteri.MusteriRaporlamaController;

import javax.swing.*;
import java.awt.*;

public class RaporlamaSecenekController {

    private RaporlamaSecenekPanel view;
    private MusteriRaporlamaController musteriRaporlamaController;

    public RaporlamaSecenekController() {
        view = new RaporlamaSecenekPanel();

        initListener();

        musteriRaporlamaController = new MusteriRaporlamaController();
    }

    private void initListener() {
        view.getBtnRaporla().addActionListener(e -> {
            if (view.rdbtnMusteri.isSelected()) {

                JFrame musteriFrame = new JFrame();
              //  musteriFrame.setAlwaysOnTop(true);
                musteriFrame.add(musteriRaporlamaController.getView());
                musteriFrame.setBounds(100, 100, 400, 600);
                musteriFrame.setVisible(true);
                musteriFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                view.raporlamaPopupClose(e);


            } else {
                //TODO: Tarih ekranıyla bağlantı
                System.out.println("Tarih seçildi");
            }
        });
    }

    public RaporlamaSecenekPanel getView() {
        return view;
    }
}
