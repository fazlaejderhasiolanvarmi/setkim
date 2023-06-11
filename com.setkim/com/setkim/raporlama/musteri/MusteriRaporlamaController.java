package com.setkim.raporlama.musteri;

import com.setkim.util.Database;

import java.util.List;

public class MusteriRaporlamaController {
    private MusteriRaporlamaPanel view;

    public MusteriRaporlamaController() {
        view = new MusteriRaporlamaPanel();
        initComboBox();
    }

    private void initComboBox() {

        List<String> musteriList = Database.getMusteriList();

        for (String musteri : musteriList) {
            view.getMusteriDropdown().addItem(musteri);
        }
    }

    public MusteriRaporlamaPanel getView() {
        return view;
    }
}
