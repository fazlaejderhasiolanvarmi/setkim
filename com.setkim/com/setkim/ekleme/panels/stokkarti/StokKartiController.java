package com.setkim.ekleme.panels.stokkarti;


import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.StokKarti;

public class StokKartiController {

    private StokKartiPanel view;

    public StokKartiController() {

        view = new StokKartiPanel();

        initListeners();
    }

    private void initListeners() {

        view.getBtnEkle().addActionListener(e -> {
            StokKarti stokKarti = new StokKarti();

            stokKarti.setStokKartiAdi(view.getTxtFieldStokKartAdi().getText());

            DatabaseObjectList.addStokKartiToList(stokKarti);
        });
    }

    public StokKartiPanel getView() {

        return view;
    }

}
