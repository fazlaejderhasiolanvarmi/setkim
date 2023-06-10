package com.setkim.ekleme.panels.siparis;

import javax.swing.*;
import java.awt.*;

public class SiparisPanel extends JPanel {
    private JTextField boyananMalzeme;
    private JTextField malzemeCinsi;
    private JTextField yuzeyIslem;
    private JTextField renkKodu;
    private JTextField boyaMiktari;
    private JTextField iscilikSuresi;
    private JTextField boyananMalzemeMiktari;
    private JTextField birim;
    private JTextField hat;
    private JTextField boyamaFiyati;
    private JTextField tutar;
    private JTextField textFieldMalzemeAlimTarihi;
    private JTextField textFieldTeslimTarihi;
    private JTextField textFieldIrsaliyeNo;
    private JTextField textFieldFaturaNo;
    private JTextField textFieldVade;

    private JButton btnEkle;

    public SiparisPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.4, 0.6};
        gridBagLayout.rowWeights = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Boyanan Malzeme");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);

        boyananMalzeme = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        add(boyananMalzeme, gbc_textField);
        boyananMalzeme.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Malzeme Cinsi");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

        malzemeCinsi = new JTextField();
        GridBagConstraints gbc_textField_9 = new GridBagConstraints();
        gbc_textField_9.insets = new Insets(0, 0, 5, 5);
        gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_9.gridx = 1;
        gbc_textField_9.gridy = 1;
        add(malzemeCinsi, gbc_textField_9);
        malzemeCinsi.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Yüzey İşlem");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        add(lblNewLabel_2, gbc_lblNewLabel_2);

        yuzeyIslem = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 1;
        gbc_textField_5.gridy = 2;
        add(yuzeyIslem, gbc_textField_5);
        yuzeyIslem.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Renk Kodu");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        add(lblNewLabel_3, gbc_lblNewLabel_3);

        renkKodu = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 1;
        gbc_textField_4.gridy = 3;
        add(renkKodu, gbc_textField_4);
        renkKodu.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Boya Miktarı");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 4;
        add(lblNewLabel_4, gbc_lblNewLabel_4);

        boyaMiktari = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 4;
        add(boyaMiktari, gbc_textField_1);
        boyaMiktari.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("İşçilik Süresi");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 5;
        add(lblNewLabel_5, gbc_lblNewLabel_5);

        iscilikSuresi = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 5;
        add(iscilikSuresi, gbc_textField_2);
        iscilikSuresi.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Boyanan Malzeme Miktarı");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 6;
        add(lblNewLabel_6, gbc_lblNewLabel_6);

        boyananMalzemeMiktari = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 1;
        gbc_textField_3.gridy = 6;
        add(boyananMalzemeMiktari, gbc_textField_3);
        boyananMalzemeMiktari.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Birim");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 7;
        add(lblNewLabel_7, gbc_lblNewLabel_7);

        birim = new JTextField();
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.gridx = 1;
        gbc_textField_6.gridy = 7;
        add(birim, gbc_textField_6);
        birim.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Hat");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 8;
        add(lblNewLabel_8, gbc_lblNewLabel_8);

        hat = new JTextField();
        GridBagConstraints gbc_textField_7 = new GridBagConstraints();
        gbc_textField_7.insets = new Insets(0, 0, 5, 5);
        gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_7.gridx = 1;
        gbc_textField_7.gridy = 8;
        add(hat, gbc_textField_7);
        hat.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("Boyama Fiyatı");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 9;
        add(lblNewLabel_9, gbc_lblNewLabel_9);

        boyamaFiyati = new JTextField();
        GridBagConstraints gbc_textField_8 = new GridBagConstraints();
        gbc_textField_8.insets = new Insets(0, 0, 5, 5);
        gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_8.gridx = 1;
        gbc_textField_8.gridy = 9;
        add(boyamaFiyati, gbc_textField_8);
        boyamaFiyati.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("Tutar");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 10;
        add(lblNewLabel_10, gbc_lblNewLabel_10);

        tutar = new JTextField();
        GridBagConstraints gbc_textField_10 = new GridBagConstraints();
        gbc_textField_10.insets = new Insets(0, 0, 5, 5);
        gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_10.gridx = 1;
        gbc_textField_10.gridy = 10;
        add(tutar, gbc_textField_10);
        tutar.setColumns(10);

        JLabel lblMalzAlTar = new JLabel("Malzeme Alım Tarihi");
        GridBagConstraints gbc_lblMalzAlTar = new GridBagConstraints();
        gbc_lblMalzAlTar.insets = new Insets(0, 0, 5, 5);
        gbc_lblMalzAlTar.gridx = 0;
        gbc_lblMalzAlTar.gridy = 11;
        add(lblMalzAlTar, gbc_lblMalzAlTar);

        textFieldMalzemeAlimTarihi = new JTextField();
        GridBagConstraints gbc_textFieldMalzemeAlimTarihi = new GridBagConstraints();
        gbc_textFieldMalzemeAlimTarihi.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldMalzemeAlimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldMalzemeAlimTarihi.gridx = 1;
        gbc_textFieldMalzemeAlimTarihi.gridy = 11;
        add(textFieldMalzemeAlimTarihi, gbc_textFieldMalzemeAlimTarihi);
        textFieldMalzemeAlimTarihi.setColumns(10);

        JLabel lblTeslimTarihi = new JLabel("Teslim Tarihi");
        GridBagConstraints gbc_lblTeslimTarihi = new GridBagConstraints();
        gbc_lblTeslimTarihi.insets = new Insets(0, 0, 5, 5);
        gbc_lblTeslimTarihi.gridx = 0;
        gbc_lblTeslimTarihi.gridy = 12;
        add(lblTeslimTarihi, gbc_lblTeslimTarihi);

        textFieldTeslimTarihi = new JTextField();
        GridBagConstraints gbc_textFieldTeslimTarihi = new GridBagConstraints();
        gbc_textFieldTeslimTarihi.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldTeslimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTeslimTarihi.gridx = 1;
        gbc_textFieldTeslimTarihi.gridy = 12;
        add(textFieldTeslimTarihi, gbc_textFieldTeslimTarihi);
        textFieldTeslimTarihi.setColumns(10);

        JLabel lblIrsaliye = new JLabel("İrsaliye No");
        GridBagConstraints gbc_lblIrsaliye = new GridBagConstraints();
        gbc_lblIrsaliye.insets = new Insets(0, 0, 5, 5);
        gbc_lblIrsaliye.gridx = 0;
        gbc_lblIrsaliye.gridy = 13;
        add(lblIrsaliye, gbc_lblIrsaliye);

        textFieldIrsaliyeNo = new JTextField();
        GridBagConstraints gbc_textFieldIrsaliyeNo = new GridBagConstraints();
        gbc_textFieldIrsaliyeNo.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldIrsaliyeNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldIrsaliyeNo.gridx = 1;
        gbc_textFieldIrsaliyeNo.gridy = 13;
        add(textFieldIrsaliyeNo, gbc_textFieldIrsaliyeNo);
        textFieldIrsaliyeNo.setColumns(10);

        JLabel lblFatura = new JLabel("Fatura No");
        GridBagConstraints gbc_lblFatura = new GridBagConstraints();
        gbc_lblFatura.insets = new Insets(0, 0, 5, 5);
        gbc_lblFatura.gridx = 0;
        gbc_lblFatura.gridy = 14;
        add(lblNewLabel_3, gbc_lblFatura);

        textFieldFaturaNo = new JTextField();
        GridBagConstraints gbc_textFieldFaturaNo = new GridBagConstraints();
        gbc_textFieldFaturaNo.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldFaturaNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFaturaNo.gridx = 1;
        gbc_textFieldFaturaNo.gridy = 14;
        add(textFieldFaturaNo, gbc_textFieldFaturaNo);
        textFieldFaturaNo.setColumns(10);

        JLabel lblVade = new JLabel("Vade");
        GridBagConstraints gbc_lblVade = new GridBagConstraints();
        gbc_lblVade.insets = new Insets(0, 0, 5, 5);
        gbc_lblVade.gridx = 0;
        gbc_lblVade.gridy = 15;
        add(lblVade, gbc_lblVade);

        textFieldVade = new JTextField();
        GridBagConstraints gbc_textFieldVade = new GridBagConstraints();
        gbc_textFieldVade.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldVade.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVade.gridx = 1;
        gbc_textFieldVade.gridy = 15;
        add(textFieldVade, gbc_textFieldVade);
        textFieldVade.setColumns(10);

        btnEkle = new JButton("Ekle");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
        gbc_btnNewButton.gridwidth = 3;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 11;
        add(btnEkle, gbc_btnNewButton);
    }

    public JTextField getBoyananMalzeme() {
        return boyananMalzeme;
    }

    public JTextField getBoyaMiktari() {
        return boyaMiktari;
    }

    public JTextField getIscilikSuresi() {
        return iscilikSuresi;
    }

    public JTextField getBoyananMalzemeMiktari() {
        return boyananMalzemeMiktari;
    }

    public JTextField getRenkKodu() {
        return renkKodu;
    }

    public JTextField getYuzeyIslem() {
        return yuzeyIslem;
    }

    public JTextField getBirim() {
        return birim;
    }

    public JTextField getHat() {
        return hat;
    }

    public JTextField getBoyamaFiyati() {
        return boyamaFiyati;
    }

    public JTextField getMalzemeCinsi() {
        return malzemeCinsi;
    }

    public JTextField getTutar() {
        return tutar;
    }

    public JButton getBtnEkle() {
        return btnEkle;
    }
}
