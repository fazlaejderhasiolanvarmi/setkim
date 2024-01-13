package com.setkim.raporlama.secenek;

import com.setkim.raporlama.musteri.MusteriRaporlamaController;
import com.setkim.raporlama.tarih.TarihRaporlamaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RaporlamaSecenekController {

    private RaporlamaSecenekPanel view;
    private MusteriRaporlamaController musteriRaporlamaController;
    private TarihRaporlamaController tarihRaporlamaController;

    public RaporlamaSecenekController() {
        view = new RaporlamaSecenekPanel();

        initListener();

        musteriRaporlamaController = new MusteriRaporlamaController();
        tarihRaporlamaController = new TarihRaporlamaController();
    }

    private void initListener() {
        view.getBtnRaporla().addActionListener(e -> {
            if (view.rdbtnMusteri.isSelected()) {

                JFrame musteriFrame = new JFrame("Müşteri Filtreleme");
                musteriFrame.toFront();
                musteriRaporlamaController.refreshComboBox();
                musteriFrame.add(musteriRaporlamaController.getView());
                musteriFrame.setBounds(100, 100, 1200, 800);
                musteriFrame.setVisible(true);
                musteriFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                raporlamaPopupClose(e);

            } else {

                JFrame tarihFrame = new JFrame("Tarih Filtreleme");
                tarihFrame.toFront();
                tarihFrame.add(tarihRaporlamaController.getView());
                tarihFrame.setBounds(100, 100, 1200, 800);
                tarihFrame.setVisible(true);
                tarihFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                raporlamaPopupClose(e);
            }
        });
    }

    public RaporlamaSecenekPanel getView() {
        return view;
    }

    public void raporlamaPopupClose(ActionEvent e) {
        JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }
}
