package com.setkim.ekleme;

import com.setkim.ekleme.panels.musteri.MusteriController;
import com.setkim.ekleme.panels.siparis.SiparisController;
import com.setkim.ekleme.panels.stok.StokController;
import com.setkim.ekleme.panels.stokkarti.StokKartiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EklemeController {

    private EklemePanel view;
    private MusteriController musteriController;
    private SiparisController siparisController;
    private StokController stokController;
    private StokKartiController stokKartiController;

    public EklemeController() {
        view = new EklemePanel();

        musteriController = new MusteriController();
        siparisController = new SiparisController();

        stokController = new StokController();
        stokKartiController = new StokKartiController();

        view.getWrapperPanel().add(musteriController.getView());
        view.getWrapperPanel().revalidate();
        view.getWrapperPanel().repaint();

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = (String) view.getComboBox().getSelectedItem();

                view.getWrapperPanel().removeAll();

                if (selection.equals("Müşteri Bilgisi")) {

                    view.getWrapperPanel().add(musteriController.getView());

                } else if (selection.equals("Sipariş")) {

                    siparisController.refreshCombobox();
                    view.getWrapperPanel().add(siparisController.getView());

                } else if (selection.equals("Stok Kartı")) {

                    view.getWrapperPanel().add(stokKartiController.getView());

                } else if (selection.equals("Stok")) {

                    view.getWrapperPanel().add(stokController.getView());
                }

                view.getWrapperPanel().revalidate();
                view.getWrapperPanel().repaint();

            }
        };

        view.getComboBox().addActionListener(actionListener);

    }

    public JPanel getView() {
        return view;
    }
}
