package com.setkim.ekleme.panels.siparis;

import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.SiparisBilgisi;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.SimpleDateFormat;
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

            SiparisBilgisi siparis = new SiparisBilgisi();

            siparis.setBoyananMalzeme(view.getBoyananMalzeme().getText());
            siparis.setMalzemeCinsi(view.getMalzemeCinsi().getText());
            siparis.setYuzeyIslem(view.getYuzeyIslem().getText());
            siparis.setRenkKodu(view.getRenkKodu().getText());
            siparis.setBoyaMiktari(Double.parseDouble(view.getBoyaMiktari().getText()));
            siparis.setIscilikSuresi(Double.parseDouble(view.getIscilikSuresi().getText()));
            siparis.setBoyananMalzemeMiktari(Double.parseDouble(view.getBoyananMalzemeMiktari().getText()));
            siparis.setBirim(view.getBirim().getText());
            siparis.setHat(Integer.parseInt(view.getBirim().getText()));
            siparis.setBoyamaFiyati(Double.parseDouble(view.getBoyamaFiyati().getText()));
            siparis.setTutar(Double.parseDouble(view.getTutar().getText()));
            siparis.setMusteri((Musteri) view.getMusteriComboBox().getSelectedItem());

            try {
                siparis.setAlimTarihi(new SimpleDateFormat("dd/MM/yyyy").parse(view.getMalzemeAlimTarihi().getText()));
                siparis.setTeslimTarihi(new SimpleDateFormat("dd/MM/yyyy").parse(view.getTeslimTarihi().getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            siparis.setIrsaliyeNo(view.getIrsaliyeNo().getText());
            siparis.setFaturaNo(view.getFaturaNo().getText());
            siparis.setVade(Integer.parseInt(view.getVade().getText()));

            DatabaseObjectList.addSiparisToList(siparis);

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

        List<Musteri> musteriList = DatabaseObjectList.getMusteriList();

        for (Musteri musteri : musteriList) {
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
                if (value instanceof Musteri)
                    setText(((Musteri) value).getMusteriAdi());

                return this;
            }
        });
    }

    public SiparisPanel getView() {
        return view;
    }
}
