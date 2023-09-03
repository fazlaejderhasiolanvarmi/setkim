package com.setkim.ekleme.panels.siparis;

import com.setkim.raporlama.musteri.MusteriNoVeAdPair;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class SiparisController {

    private SiparisPanel view;

    public SiparisController() {
        view = new SiparisPanel();

        initListeners();

    }

    private void initListeners() {

        view.getEkleBtn().addActionListener(e -> {

            Database.insertToSiparisBilgisi(
                    view.getBoyananMalzeme().getText(),
                    view.getMalzemeCinsi().getText(),
                    view.getYuzeyIslem().getText(),
                    view.getRenkKodu().getText(),
                    Double.parseDouble(view.getBoyaMiktari().getText()),
                    Double.parseDouble(view.getIscilikSuresi().getText()),
                    Double.parseDouble(view.getBoyananMalzemeMiktari().getText()),
                    view.getBirim().getText(),
                    Integer.parseInt(view.getHat().getText()),
                    Double.parseDouble(view.getBoyamaFiyati().getText()),
                    Double.parseDouble(view.getTutar().getText()),
                    ((MusteriNoVeAdPair) view.getMusteriComboBox().getSelectedItem()).getMusteriNo(),
                    view.getMalzemeAlimTarihi().getText(),
                    view.getTeslimTarihi().getText(),
                    view.getIrsaliyeNo().getText(),
                    view.getFaturaNo().getText(),
                    Integer.parseInt(view.getVade().getText())
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Bilgiler eklendi!",
                    "Başarılı",
                    JOptionPane.INFORMATION_MESSAGE);

        });

        view.getBoyananMalzemeMiktari().getDocument().addDocumentListener(new DocumentListener() {
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
                // nothing to do
            }
        });

        view.getBoyamaFiyati().getDocument().addDocumentListener(new DocumentListener() {
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
                // nothing to do
            }
        });

    }

    private void fillTutar() {

        if (!view.getBoyananMalzemeMiktari().getText().isEmpty() && !view.getBoyamaFiyati().getText().isEmpty()) {

            try {
                double boyananMalzemeMiktari = Double.parseDouble(view.getBoyananMalzemeMiktari().getText());
                double boyamaFiyati = Double.parseDouble(view.getBoyamaFiyati().getText());

                double tutar = boyananMalzemeMiktari * boyamaFiyati;

                Formatter formatter = new Formatter(Locale.US);
                formatter.format("%.2f", tutar);

                view.getTutar().setText(formatter.toString());

            } catch (Exception e) {

                // double değer yok devam et

            }

        } else {

            view.getTutar().setText("");

        }
    }

    public void refreshCombobox() {

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        List<MusteriNoVeAdPair> musteriList = Database.getMusteriList();

        for (MusteriNoVeAdPair musteri : musteriList) {
            model.addElement(musteri);
        }

        view.getMusteriComboBox().setModel(model);
        view.getMusteriComboBox().setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                if (value instanceof MusteriNoVeAdPair)
                    setText(((MusteriNoVeAdPair) value).getMusteriAdi());

                return this;
            }
        });
    }

    public SiparisPanel getView() {
        return view;
    }
}
