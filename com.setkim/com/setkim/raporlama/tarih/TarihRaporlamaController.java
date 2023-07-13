package com.setkim.raporlama.tarih;

public class TarihRaporlamaController {
    private TarihRaporlamaPanel view;

    public TarihRaporlamaController() {

        view = new TarihRaporlamaPanel();

        initListeners();
    }

    private void initListeners() {
        view.getBtnTarihSecKucuk().addActionListener(e -> {
            String dateText = view.getTextFieldTarihKucuk().getText();
            //Dummy
            System.out.println(dateText);
        });

        view.getBtnTarihSecBuyuk().addActionListener(e -> {
            String dateText = view.getTextFieldTarihBuyuk().getText();
            //Dummy
            System.out.println(dateText);
        });
    }

    public TarihRaporlamaPanel getView() {
        return view;
    }
}
