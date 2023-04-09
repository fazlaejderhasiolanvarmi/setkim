package com.setkim.ekleme;

import com.setkim.ekleme.panels.musteri.MusteriController;
import com.setkim.ekleme.panels.siparisdetay.SiparisDetayController;

import javax.swing.*;

public class EklemeController {

    private EklemePanel view;

    private MusteriController musteriController;

    private SiparisDetayController siparisDetayController;

    public EklemeController(){
        view = new EklemePanel();

        musteriController = new MusteriController();
        siparisDetayController = new SiparisDetayController();


        view.getBtnSec().addActionListener(e -> {
            String selection = (String) view.getComboBox().getSelectedItem();

            view.getWrapperPanel().removeAll();

            if (selection.equals("Müşteri Bilgisi")){

                view.getWrapperPanel().add(musteriController.getView());

            } else if(selection.equals("Sipariş")) {

                view.getWrapperPanel().add(new JPanel());

            } else if (selection.equals("Sipariş Detayı")) {

                view.getWrapperPanel().add(siparisDetayController.getView());

            }

            view.getWrapperPanel().revalidate();
            view.getWrapperPanel().repaint();
        });
    }


    public JPanel getView() {
        return view;
    }
}
