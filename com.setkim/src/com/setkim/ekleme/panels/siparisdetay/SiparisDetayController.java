package com.setkim.ekleme.panels.siparisdetay;

public class SiparisDetayController {
    private SiparisDetayPanel view;

    public SiparisDetayController(){
        view = new SiparisDetayPanel();

        view.getBtnEkle().addActionListener(e -> {
            //TODO: burlar değerlenecek
        });
    }

    public SiparisDetayPanel getView() {
        return view;
    }
}
