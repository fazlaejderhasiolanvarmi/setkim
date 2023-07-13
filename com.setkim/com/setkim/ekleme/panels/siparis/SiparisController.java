package com.setkim.ekleme.panels.siparis;

import com.setkim.raporlama.musteri.MusteriNoVeAdPair;
import com.setkim.util.Database;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SiparisController {

    private SiparisPanel view;

    public SiparisController() {
        view = new SiparisPanel();

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
