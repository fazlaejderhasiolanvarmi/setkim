package com.setkim.ekleme.panels.stokkarti;


public class StokKartiController {

    private StokKartiPanel view;

    public StokKartiController() {

        view = new StokKartiPanel();

        initListeners();
    }

    private void initListeners() {

        view.getBtnEkle().addActionListener(e -> {
            
        });
    }

    public StokKartiPanel getView() {

        return view;
    }

}
