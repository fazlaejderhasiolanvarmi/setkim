package com.setkim.ekleme.panels.siparis;

import com.setkim.util.Database;

public class SiparisController {

    private SiparisPanel view;

    public SiparisController() {
        view = new SiparisPanel();

        view.getBtnEkle().addActionListener(e -> {

            Database.insertToSetkimMain(
                    view.getBoyananMalzeme().getText(),
                    view.getMalzemeCinsi().getText(),
                    view.getYuzeyIslem().getText(),
                    view.getRenkKodu().getText(),
                    Double.valueOf(view.getBoyaMiktari().getText()),
                    Double.valueOf(view.getIscilikSuresi().getText()),
                    Double.valueOf(view.getBoyananMalzemeMiktari().getText()),
                    view.getBirim().getText(),
                    Integer.valueOf(view.getHat().getText()),
                    Double.valueOf(view.getBoyamaFiyati().getText()),
                    Double.valueOf(view.getTutar().getText())
            );
            
        });

    }

    public SiparisPanel getView() {
        return view;
    }
}
