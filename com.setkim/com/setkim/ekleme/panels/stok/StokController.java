package com.setkim.ekleme.panels.stok;

import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.Stok;
import com.setkim.util.objects.StokKarti;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class StokController {

    private StokPanel view;

    public StokController() {

        view = new StokPanel();

        refreshCombobox();
        initListeners();

    }

    private void initListeners() {

        view.getBtnEkle().addActionListener(e -> {
            Stok stok = new Stok();

            stok.setStokKarti((StokKarti) view.getCmbBoxStokKart().getSelectedItem());
            stok.setStokKodu(view.getTxtFieldStokKodu().getText());
            stok.setStokAdi(view.getTxtFieldStokAdi().getText());
            stok.setBirim(view.getTxtFieldBirim().getText());
            stok.setFiyat(Double.parseDouble(view.getTxtFieldFiyat().getText()));
            stok.setMiktar(Integer.parseInt(view.getTxtFieldMiktar().getText()));
            stok.setTutar(Double.parseDouble(view.getTxtFieldTutar().getText()));

            DatabaseObjectList.addStokToList(stok);

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

    public void refreshCombobox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();

        List<StokKarti> stokKartiList = DatabaseObjectList.getStokKartiList();

        for (StokKarti stokKarti : stokKartiList) {
            model.addElement(stokKarti);
        }

        view.getCmbBoxStokKart().setModel(model);
        view.getCmbBoxStokKart().setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                if (value instanceof StokKarti)
                    setText(((StokKarti) value).getStokKartiAdi());

                return this;
            }
        });
    }

    public StokPanel getView() {
        return view;
    }
}
