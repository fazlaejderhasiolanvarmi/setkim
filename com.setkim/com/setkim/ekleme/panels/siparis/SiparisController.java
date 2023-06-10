package com.setkim.ekleme.panels.siparis;

import com.setkim.util.Database;

public class SiparisController {

    private SiparisPanel view;

    public SiparisController() {
        view = new SiparisPanel();

        view.getEkleBtn().addActionListener(e -> {

            Database.insertToSiparisBilgisi(
                    view.getBoyananMalzeme().getText(),
                    view.getMalzemeCinsi().getText(),
                    view.getYuzeyIslem().getText(),
                    view.getRenkKodu().getText(),
                    Double.parseDouble(view.getBoyaMiktari().getText()),
                    Double.parseDouble(view.getIscilikSuresi().getText()),
                    Double.parseDouble(view.getBoyananMalzemeMiktari().getText()),
                    view.getBirim().getText(),
                    Integer.parseInt(view.getHat().getText()),
                    Double.parseDouble(view.getBoyamaFiyati().getText()),
                    Double.parseDouble(view.getTutar().getText()),
                    view.getMalzemeAlimTarihi().getText(),
                    view.getTeslimTarihi().getText(),
                    view.getIrsaliyeNo().getText(),
                    view.getFaturaNo().getText(),
                    Integer.parseInt(view.getVade().getText())
            );
            
        });

    }

    public SiparisPanel getView() {
        return view;
    }
}
