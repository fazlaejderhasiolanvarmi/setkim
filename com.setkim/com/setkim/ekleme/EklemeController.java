package com.setkim.ekleme;

import com.setkim.ekleme.panels.musteri.MusteriController;
import com.setkim.ekleme.panels.siparis.SiparisController;
import com.setkim.ekleme.panels.siparisdetay.SiparisDetayController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EklemeController {

    private EklemePanel view;

    private MusteriController musteriController;

    private SiparisController siparisController;

    private SiparisDetayController siparisDetayController;

    public EklemeController() {
        view = new EklemePanel();

        musteriController = new MusteriController();
        siparisController = new SiparisController();
        siparisDetayController = new SiparisDetayController();

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

                    view.getWrapperPanel().add(siparisController.getView());

                } else if (selection.equals("Sipariş Detayı")) {

                    view.getWrapperPanel().add(siparisDetayController.getView());

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
