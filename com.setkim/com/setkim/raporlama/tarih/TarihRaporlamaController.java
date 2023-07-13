package com.setkim.raporlama.tarih;

import com.setkim.util.Database;

import java.util.Calendar;
import java.util.Date;

public class TarihRaporlamaController {
    private TarihRaporlamaPanel view;

    public TarihRaporlamaController() {

        view = new TarihRaporlamaPanel();

        initListeners();
        initTable();
    }

    private void initTable() {
    }

    private void initListeners() {

        view.getBtnFiltrele().addActionListener(e -> {
            Calendar calendar = Calendar.getInstance();

            Date baslangicTarihi = (Date) view.getSpinnerBaslangicTarih().getValue();
            Date bitisTarihi = (Date) view.getSpinnerBitisTarih().getValue();

            calendar.setTime(baslangicTarihi);
            int baslangicGunu = calendar.get(Calendar.DAY_OF_MONTH);
            int baslangicAy = calendar.get(Calendar.MONTH) + 1;
            int baslangicYil = calendar.get(Calendar.YEAR);

            calendar.setTime(bitisTarihi);
            int bitisGunu = calendar.get(Calendar.DAY_OF_MONTH);
            int bitisAy = calendar.get(Calendar.MONTH) + 1;
            int bitisYil = calendar.get(Calendar.YEAR);

            System.out.println(baslangicGunu + "/" + baslangicAy + "/" + baslangicYil);
            System.out.println(bitisGunu + "/" + bitisAy + "/" + bitisYil);

            Database.compareDates();

        });
    }

    public TarihRaporlamaPanel getView() {
        return view;
    }
}
