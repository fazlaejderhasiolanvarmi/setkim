package com.setkim.raporlama.tarih;

import com.setkim.util.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

            String baslangicTarih = baslangicGunu + "/" + baslangicAy + "/" + baslangicYil;
            String bitisTarih = bitisGunu + "/" + bitisAy + "/" + bitisYil;

            List<Object> siparisler = new ArrayList<>();

            try {
                siparisler = Database.compareDates(new SimpleDateFormat("dd/MM/yyyy").parse(baslangicTarih), new SimpleDateFormat("dd/MM/yyyy").parse(bitisTarih));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            //Bunun yerine tabloya yazılacak
            if (!siparisler.isEmpty()) {
                for (Object siparis : siparisler) {
                    List<Object> row = (List<Object>) siparis;

                    for (Object bilgi : row) {
                        System.out.print(bilgi + "\t");
                    }

                    System.out.println();
                }
            } else {
                System.out.println("Veri bulunamadı!");
            }

        });
    }

    public TarihRaporlamaPanel getView() {
        return view;
    }
}
