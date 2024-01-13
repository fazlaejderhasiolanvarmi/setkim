package com.setkim.ekleme.panels.siparis;

import com.setkim.raporlama.musteri.MusteriNoVeAdPair;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.DateFormat;
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        view.getEkleBtn().addActionListener(e -> {
            String satirAdi = "";
            try {
                satirAdi = "Boyanan Malzeme";
                String boyananMalzeme = view.getBoyananMalzeme().getText();
                satirAdi = "Malzeme Cinsi";
                String malzemeCinsi = view.getMalzemeCinsi().getText();
                satirAdi = "Yüzey İşlem";
                String yuzeyIslem = view.getYuzeyIslem().getText();
                satirAdi = "Renk Kodu";
                String renkKodu = view.getRenkKodu().getText();
                satirAdi = "Boya Miktarı";
                double boyaMiktari = Double.parseDouble(view.getBoyaMiktari().getText());
                satirAdi = "İşçilik Süresi";
                double iscilikSuresi = Double.parseDouble(view.getIscilikSuresi().getText());
                satirAdi = "Boyanan Malzeme Miktarı";
                double boyananMalzemeMiktari = Double.parseDouble(view.getBoyananMalzemeMiktari().getText());
                satirAdi = "Birim";
                String birim = view.getBirim().getText();
                satirAdi = "Hat";
                int hat = Integer.parseInt(view.getHat().getText());
                satirAdi = "Boyama Fiyatı";
                double boyamaFiyati = Double.parseDouble(view.getBoyamaFiyati().getText());
                satirAdi = "Tutar";
                double tutar = Double.parseDouble(view.getTutar().getText());
                satirAdi = "Müşteri No";
                int musteriNo = ((MusteriNoVeAdPair) view.getMusteriComboBox().getSelectedItem()).getMusteriNo();
                satirAdi = "Malzeme Alım Tarihi";
                String malzemeAlimTarihi = view.getMalzemeAlimTarihi().getText();
                dateFormat.parse(malzemeAlimTarihi);
                satirAdi = "Teslim Tarihi";
                String teslimTarihi = view.getTeslimTarihi().getText();
                dateFormat.parse(teslimTarihi);
                satirAdi = "İrsaliye No";
                String irsaliyeNo = view.getIrsaliyeNo().getText();
                satirAdi = "Fatura No";
                String faturaNo = view.getFaturaNo().getText();
                satirAdi = "Vade";
                int vade = Integer.parseInt(view.getVade().getText());

                Database.insertToSiparisBilgisi(
                        boyananMalzeme,
                        malzemeCinsi,
                        yuzeyIslem,
                        renkKodu,
                        boyaMiktari,
                        iscilikSuresi,
                        boyananMalzemeMiktari,
                        birim,
                        hat,
                        boyamaFiyati,
                        tutar,
                        musteriNo,
                        malzemeAlimTarihi,
                        teslimTarihi,
                        irsaliyeNo,
                        faturaNo,
                        vade
                );
            } catch (Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        satirAdi + " hatalı girildi.",
                        "Başarısız",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

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
