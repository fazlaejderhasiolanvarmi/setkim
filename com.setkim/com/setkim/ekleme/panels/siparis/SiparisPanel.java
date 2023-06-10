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
    private JTextField malzemeAlimTarihi;
    private JTextField teslimTarihi;
    private JTextField irsaliyeNo;
    private JTextField faturaNo;
    private JTextField vade;
    private JButton ekleBtn;
    public SiparisPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Boyanan Malzeme");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);

        boyananMalzeme = new JTextField();
        GridBagConstraints gbc_boyananMalzeme = new GridBagConstraints();
        gbc_boyananMalzeme.insets = new Insets(0, 0, 5, 0);
        gbc_boyananMalzeme.fill = GridBagConstraints.HORIZONTAL;
        gbc_boyananMalzeme.gridx = 1;
        gbc_boyananMalzeme.gridy = 0;
        add(boyananMalzeme, gbc_boyananMalzeme);
        boyananMalzeme.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Malzeme Cinsi");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

        malzemeCinsi = new JTextField();
        GridBagConstraints gbc_malzemeCinsi = new GridBagConstraints();
        gbc_malzemeCinsi.insets = new Insets(0, 0, 5, 0);
        gbc_malzemeCinsi.fill = GridBagConstraints.HORIZONTAL;
        gbc_malzemeCinsi.gridx = 1;
        gbc_malzemeCinsi.gridy = 1;
        add(malzemeCinsi, gbc_malzemeCinsi);
        malzemeCinsi.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Yüzey İşlem");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        add(lblNewLabel_2, gbc_lblNewLabel_2);

        yuzeyIslem = new JTextField();
        GridBagConstraints gbc_yuzeyIslem = new GridBagConstraints();
        gbc_yuzeyIslem.insets = new Insets(0, 0, 5, 0);
        gbc_yuzeyIslem.fill = GridBagConstraints.HORIZONTAL;
        gbc_yuzeyIslem.gridx = 1;
        gbc_yuzeyIslem.gridy = 2;
        add(yuzeyIslem, gbc_yuzeyIslem);
        yuzeyIslem.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Renk Kodu");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        add(lblNewLabel_3, gbc_lblNewLabel_3);

        renkKodu = new JTextField();
        GridBagConstraints gbc_renkKodu = new GridBagConstraints();
        gbc_renkKodu.insets = new Insets(0, 0, 5, 0);
        gbc_renkKodu.fill = GridBagConstraints.HORIZONTAL;
        gbc_renkKodu.gridx = 1;
        gbc_renkKodu.gridy = 3;
        add(renkKodu, gbc_renkKodu);
        renkKodu.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Boya Miktarı");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 4;
        add(lblNewLabel_4, gbc_lblNewLabel_4);

        boyaMiktari = new JTextField();
        GridBagConstraints gbc_boyaMiktari = new GridBagConstraints();
        gbc_boyaMiktari.insets = new Insets(0, 0, 5, 0);
        gbc_boyaMiktari.fill = GridBagConstraints.HORIZONTAL;
        gbc_boyaMiktari.gridx = 1;
        gbc_boyaMiktari.gridy = 4;
        add(boyaMiktari, gbc_boyaMiktari);
        boyaMiktari.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("İşçilik Süresi");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 5;
        add(lblNewLabel_5, gbc_lblNewLabel_5);

        iscilikSuresi = new JTextField();
        GridBagConstraints gbc_iscilikSuresi = new GridBagConstraints();
        gbc_iscilikSuresi.insets = new Insets(0, 0, 5, 0);
        gbc_iscilikSuresi.fill = GridBagConstraints.HORIZONTAL;
        gbc_iscilikSuresi.gridx = 1;
        gbc_iscilikSuresi.gridy = 5;
        add(iscilikSuresi, gbc_iscilikSuresi);
        iscilikSuresi.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Boyanan Malzeme Miktarı");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 6;
        add(lblNewLabel_6, gbc_lblNewLabel_6);

        boyananMalzemeMiktari = new JTextField();
        GridBagConstraints gbc_boyananMalzemeMiktari = new GridBagConstraints();
        gbc_boyananMalzemeMiktari.insets = new Insets(0, 0, 5, 0);
        gbc_boyananMalzemeMiktari.fill = GridBagConstraints.HORIZONTAL;
        gbc_boyananMalzemeMiktari.gridx = 1;
        gbc_boyananMalzemeMiktari.gridy = 6;
        add(boyananMalzemeMiktari, gbc_boyananMalzemeMiktari);
        boyananMalzemeMiktari.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Birim");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 7;
        add(lblNewLabel_7, gbc_lblNewLabel_7);

        birim = new JTextField();
        GridBagConstraints gbc_birim = new GridBagConstraints();
        gbc_birim.insets = new Insets(0, 0, 5, 0);
        gbc_birim.fill = GridBagConstraints.HORIZONTAL;
        gbc_birim.gridx = 1;
        gbc_birim.gridy = 7;
        add(birim, gbc_birim);
        birim.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Hat");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 8;
        add(lblNewLabel_8, gbc_lblNewLabel_8);

        hat = new JTextField();
        GridBagConstraints gbc_hat = new GridBagConstraints();
        gbc_hat.insets = new Insets(0, 0, 5, 0);
        gbc_hat.fill = GridBagConstraints.HORIZONTAL;
        gbc_hat.gridx = 1;
        gbc_hat.gridy = 8;
        add(hat, gbc_hat);
        hat.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("Boyama Fiyatı");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 9;
        add(lblNewLabel_9, gbc_lblNewLabel_9);

        boyamaFiyati = new JTextField();
        GridBagConstraints gbc_boyamaFiyati = new GridBagConstraints();
        gbc_boyamaFiyati.insets = new Insets(0, 0, 5, 0);
        gbc_boyamaFiyati.fill = GridBagConstraints.HORIZONTAL;
        gbc_boyamaFiyati.gridx = 1;
        gbc_boyamaFiyati.gridy = 9;
        add(boyamaFiyati, gbc_boyamaFiyati);
        boyamaFiyati.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("Tutar");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 10;
        add(lblNewLabel_10, gbc_lblNewLabel_10);

        tutar = new JTextField();
        GridBagConstraints gbc_tutar = new GridBagConstraints();
        gbc_tutar.insets = new Insets(0, 0, 5, 0);
        gbc_tutar.fill = GridBagConstraints.HORIZONTAL;
        gbc_tutar.gridx = 1;
        gbc_tutar.gridy = 10;
        add(tutar, gbc_tutar);
        tutar.setColumns(10);

        JLabel lblNewLabel_11 = new JLabel("Malzeme Alım Tarihi");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_11.gridx = 0;
        gbc_lblNewLabel_11.gridy = 11;
        add(lblNewLabel_11, gbc_lblNewLabel_11);

        malzemeAlimTarihi = new JTextField();
        GridBagConstraints gbc_malzemeAlimTarihi = new GridBagConstraints();
        gbc_malzemeAlimTarihi.insets = new Insets(0, 0, 5, 0);
        gbc_malzemeAlimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_malzemeAlimTarihi.gridx = 1;
        gbc_malzemeAlimTarihi.gridy = 11;
        add(malzemeAlimTarihi, gbc_malzemeAlimTarihi);
        malzemeAlimTarihi.setColumns(10);

        JLabel lblNewLabel_12 = new JLabel("Teslim Tarihi");
        GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
        gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_12.gridx = 0;
        gbc_lblNewLabel_12.gridy = 12;
        add(lblNewLabel_12, gbc_lblNewLabel_12);

        teslimTarihi = new JTextField();
        GridBagConstraints gbc_teslimTarihi = new GridBagConstraints();
        gbc_teslimTarihi.insets = new Insets(0, 0, 5, 0);
        gbc_teslimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_teslimTarihi.gridx = 1;
        gbc_teslimTarihi.gridy = 12;
        add(teslimTarihi, gbc_teslimTarihi);
        teslimTarihi.setColumns(10);

        JLabel lblNewLabel_13 = new JLabel("İrsaliye No");
        GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
        gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_13.gridx = 0;
        gbc_lblNewLabel_13.gridy = 13;
        add(lblNewLabel_13, gbc_lblNewLabel_13);

        irsaliyeNo = new JTextField();
        GridBagConstraints gbc_irsaliyeNo = new GridBagConstraints();
        gbc_irsaliyeNo.insets = new Insets(0, 0, 5, 0);
        gbc_irsaliyeNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_irsaliyeNo.gridx = 1;
        gbc_irsaliyeNo.gridy = 13;
        add(irsaliyeNo, gbc_irsaliyeNo);
        irsaliyeNo.setColumns(10);

        JLabel lblNewLabel_14 = new JLabel("Fatura No");
        GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
        gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_14.gridx = 0;
        gbc_lblNewLabel_14.gridy = 14;
        add(lblNewLabel_14, gbc_lblNewLabel_14);

        faturaNo = new JTextField();
        GridBagConstraints gbc_faturaNo = new GridBagConstraints();
        gbc_faturaNo.insets = new Insets(0, 0, 5, 0);
        gbc_faturaNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_faturaNo.gridx = 1;
        gbc_faturaNo.gridy = 14;
        add(faturaNo, gbc_faturaNo);
        faturaNo.setColumns(10);

        JLabel lblNewLabel_15 = new JLabel("Vade");
        GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
        gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_15.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_15.gridx = 0;
        gbc_lblNewLabel_15.gridy = 15;
        add(lblNewLabel_15, gbc_lblNewLabel_15);

        vade = new JTextField();
        GridBagConstraints gbc_vade = new GridBagConstraints();
        gbc_vade.insets = new Insets(0, 0, 5, 0);
        gbc_vade.fill = GridBagConstraints.HORIZONTAL;
        gbc_vade.gridx = 1;
        gbc_vade.gridy = 15;
        add(vade, gbc_vade);
        vade.setColumns(10);

        ekleBtn = new JButton("Ekle");
        GridBagConstraints gbc_raporlaBtn = new GridBagConstraints();
        gbc_raporlaBtn.gridwidth = 2;
        gbc_raporlaBtn.gridx = 0;
        gbc_raporlaBtn.gridy = 16;
        add(ekleBtn, gbc_raporlaBtn);
    }

    public JTextField getBoyananMalzeme() {
        return boyananMalzeme;
    }

    public JTextField getMalzemeCinsi() {
        return malzemeCinsi;
    }

    public JTextField getYuzeyIslem() {
        return yuzeyIslem;
    }

    public JTextField getRenkKodu() {
        return renkKodu;
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

    public JTextField getBirim() {
        return birim;
    }

    public JTextField getHat() {
        return hat;
    }

    public JTextField getBoyamaFiyati() {
        return boyamaFiyati;
    }

    public JTextField getTutar() {
        return tutar;
    }

    public JTextField getMalzemeAlimTarihi() {
        return malzemeAlimTarihi;
    }

    public JTextField getTeslimTarihi() {
        return teslimTarihi;
    }

    public JTextField getIrsaliyeNo() {
        return irsaliyeNo;
    }

    public JTextField getFaturaNo() {
        return faturaNo;
    }

    public JTextField getVade() {
        return vade;
    }

    public JButton getEkleBtn() {
        return ekleBtn;
    }
}
