package com.setkim.ekleme.panels.siparisdetay;

import com.setkim.util.Database;

public class SiparisDetayController {
    private SiparisDetayPanel view;

    public SiparisDetayController() {
        view = new SiparisDetayPanel();

        view.getBtnEkle().addActionListener(e -> {
            Database.insertToSiparisDetay(
                    view.getTextFieldMalzemeAlimTarihi().getText(),
                    view.getTextFieldTeslimTarihi().getText(),
                    view.getTextFieldIrsaliyeNo().getText(),
                    view.getTextFieldFaturaNo().getText(),
                    Integer.valueOf(view.getTextFieldVade().getText())
            );
        });
    }

    public SiparisDetayPanel getView() {
        return view;
    }
}
