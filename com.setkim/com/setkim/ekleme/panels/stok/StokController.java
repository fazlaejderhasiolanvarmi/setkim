package com.setkim.ekleme.panels.stok;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Formatter;
import java.util.Locale;

public class StokController {

    private StokPanel view;

    public StokController() {

        view = new StokPanel();

        initListeners();

    }

    private void initListeners() {

        view.getBtnEkle().addActionListener(e -> {
            
        });

        view.getTxtFieldMiktar().getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                fillTutar();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                fillTutar();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                // yok bişi pek

            }

        });

        view.getTxtFieldFiyat().getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {

                fillTutar();

            }

            @Override
            public void insertUpdate(DocumentEvent e) {

                fillTutar();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                // yok bişi pek

            }
        });

    }

    protected void fillTutar() {

        if (!view.getTxtFieldFiyat().getText().isEmpty() && !view.getTxtFieldMiktar().getText().isEmpty()) {

            try {

                double fiyat = Double.parseDouble(view.getTxtFieldFiyat().getText());
                double miktar = Double.parseDouble(view.getTxtFieldMiktar().getText());

                double tutar = fiyat * miktar;

                Formatter formatter = new Formatter(Locale.US);
                formatter.format("%.2f", tutar);


                view.getTxtFieldTutar().setText(formatter.toString());
            } catch (Exception e) {

                // double değer yok devam et
            }
        }
    }

    public StokPanel getView() {
        return view;
    }
}
