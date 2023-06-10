package com.setkim.raporlama.secenek;

public class RaporlamaSecenekController {

    private RaporlamaSecenekPanel view;

    public RaporlamaSecenekController() {
        view = new RaporlamaSecenekPanel();
        initListener();
    }

    private void initListener() {
        view.getBtnRaporla().addActionListener(e -> {
            if (view.rdbtnMusteri.isSelected()) {
                //TODO: Müşteri ekranıyla bağlantı
                System.out.println("Müşteri seçildi");
            } else {
                //TODO: Tarih ekranıyla bağlantı
                System.out.println("Tarih seçildi");
            }
        });
    }

    public RaporlamaSecenekPanel getView() {
        return view;
    }
}
