package com.setkim.siparisdetay;

import javax.swing.*;
import java.awt.*;

public class SiparisDetayPanel extends JPanel {
    private JTextField textFieldMusteriAdi;
    private JTextField textFieldBelgeNumarasi;
    private JTextArea textAreaAdres;
    private JTextField textFieldVergiDairesi;
    private JTextField textFieldVergiNo;
    private JTextField textFieldYetkili;
    private JTextField textFieldBoyananMalzeme;
    private JTextField textFieldMalzemeCinsi;
    private JTextField textFieldYuzeyIslem;
    private JTextField textFieldRenkKodu;
    private JTextField textFieldBoyaMiktari;
    private JTextField textFieldIscilikSuresi;
    private JTextField textFieldBoyananMalzemeMiktari;
    private JTextField textFieldBirimi;
    private JTextField textFieldHat;
    private JTextField textFieldBoyamaFiyati;
    private JTextField textFieldTutar;
    private JTextField textFieldAlimTarihi;
    private JTextField textFieldTeslimTarihi;
    private JTextField textFieldIrsaliyeNo;
    private JTextField textFieldFaturaNo;
    private JTextField textFieldVade;
    private JButton btnfaturalandir;

    public SiparisDetayPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JPanel musteriPanel = new JPanel();
        GridBagConstraints gbc_musteriPanel = new GridBagConstraints();
        gbc_musteriPanel.insets = new Insets(5, 5, 5, 5);
        gbc_musteriPanel.fill = GridBagConstraints.BOTH;
        gbc_musteriPanel.gridx = 0;
        gbc_musteriPanel.gridy = 0;
        add(musteriPanel, gbc_musteriPanel);
        GridBagLayout gbl_musteriPanel = new GridBagLayout();
        gbl_musteriPanel.columnWidths = new int[]{0, 0, 0};
        gbl_musteriPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_musteriPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_musteriPanel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        musteriPanel.setLayout(gbl_musteriPanel);

        JLabel lblMusteri = new JLabel("Müşteri");
        GridBagConstraints gbc_lblMusteri = new GridBagConstraints();
        gbc_lblMusteri.gridwidth = 2;
        gbc_lblMusteri.insets = new Insets(5, 5, 5, 5);
        gbc_lblMusteri.gridx = 0;
        gbc_lblMusteri.gridy = 0;
        musteriPanel.add(lblMusteri, gbc_lblMusteri);

        JLabel lblMusteriAdi = new JLabel("Müşteri Adı");
        GridBagConstraints gbc_lblMusteriAdi = new GridBagConstraints();
        gbc_lblMusteriAdi.anchor = GridBagConstraints.EAST;
        gbc_lblMusteriAdi.insets = new Insets(5, 5, 5, 5);
        gbc_lblMusteriAdi.gridx = 0;
        gbc_lblMusteriAdi.gridy = 1;
        musteriPanel.add(lblMusteriAdi, gbc_lblMusteriAdi);

        textFieldMusteriAdi = new JTextField();
        GridBagConstraints gbc_textFieldMusteriAdi = new GridBagConstraints();
        gbc_textFieldMusteriAdi.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldMusteriAdi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldMusteriAdi.gridx = 1;
        gbc_textFieldMusteriAdi.gridy = 1;
        musteriPanel.add(textFieldMusteriAdi, gbc_textFieldMusteriAdi);
        textFieldMusteriAdi.setColumns(10);

        JLabel lblBelgeNo = new JLabel("Belge Numarası");
        GridBagConstraints gbc_lblBelgeNo = new GridBagConstraints();
        gbc_lblBelgeNo.anchor = GridBagConstraints.EAST;
        gbc_lblBelgeNo.insets = new Insets(5, 5, 5, 5);
        gbc_lblBelgeNo.gridx = 0;
        gbc_lblBelgeNo.gridy = 2;
        musteriPanel.add(lblBelgeNo, gbc_lblBelgeNo);

        textFieldBelgeNumarasi = new JTextField();
        GridBagConstraints gbc_textFieldBelgeNumarasi = new GridBagConstraints();
        gbc_textFieldBelgeNumarasi.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldBelgeNumarasi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBelgeNumarasi.gridx = 1;
        gbc_textFieldBelgeNumarasi.gridy = 2;
        musteriPanel.add(textFieldBelgeNumarasi, gbc_textFieldBelgeNumarasi);
        textFieldBelgeNumarasi.setColumns(10);

        JLabel lblAdres = new JLabel("Adres");
        GridBagConstraints gbc_lblAdres = new GridBagConstraints();
        gbc_lblAdres.anchor = GridBagConstraints.EAST;
        gbc_lblAdres.insets = new Insets(5, 5, 5, 5);
        gbc_lblAdres.gridx = 0;
        gbc_lblAdres.gridy = 3;
        musteriPanel.add(lblAdres, gbc_lblAdres);

        textAreaAdres = new JTextArea();
        GridBagConstraints gbc_textAreaAdres = new GridBagConstraints();
        gbc_textAreaAdres.insets = new Insets(5, 5, 5, 5);
        gbc_textAreaAdres.fill = GridBagConstraints.BOTH;
        gbc_textAreaAdres.gridx = 1;
        gbc_textAreaAdres.gridy = 3;
        musteriPanel.add(textAreaAdres, gbc_textAreaAdres);

        JLabel lblVergiDairesi = new JLabel("Vergi Dairesi");
        GridBagConstraints gbc_lblVergiDairesi = new GridBagConstraints();
        gbc_lblVergiDairesi.anchor = GridBagConstraints.EAST;
        gbc_lblVergiDairesi.insets = new Insets(5, 5, 5, 5);
        gbc_lblVergiDairesi.gridx = 0;
        gbc_lblVergiDairesi.gridy = 4;
        musteriPanel.add(lblVergiDairesi, gbc_lblVergiDairesi);

        textFieldVergiDairesi = new JTextField();
        GridBagConstraints gbc_textFieldVergiDairesi = new GridBagConstraints();
        gbc_textFieldVergiDairesi.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldVergiDairesi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVergiDairesi.gridx = 1;
        gbc_textFieldVergiDairesi.gridy = 4;
        musteriPanel.add(textFieldVergiDairesi, gbc_textFieldVergiDairesi);
        textFieldVergiDairesi.setColumns(10);

        JLabel lblVergiNo = new JLabel("Vergi Numarası");
        GridBagConstraints gbc_lblVergiNo = new GridBagConstraints();
        gbc_lblVergiNo.anchor = GridBagConstraints.EAST;
        gbc_lblVergiNo.insets = new Insets(5, 5, 5, 5);
        gbc_lblVergiNo.gridx = 0;
        gbc_lblVergiNo.gridy = 5;
        musteriPanel.add(lblVergiNo, gbc_lblVergiNo);

        textFieldVergiNo = new JTextField();
        GridBagConstraints gbc_textFieldVergiNo = new GridBagConstraints();
        gbc_textFieldVergiNo.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldVergiNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVergiNo.gridx = 1;
        gbc_textFieldVergiNo.gridy = 5;
        musteriPanel.add(textFieldVergiNo, gbc_textFieldVergiNo);
        textFieldVergiNo.setColumns(10);

        JLabel lblYetkili = new JLabel("Yetkili");
        GridBagConstraints gbc_lblYetkili = new GridBagConstraints();
        gbc_lblYetkili.anchor = GridBagConstraints.EAST;
        gbc_lblYetkili.insets = new Insets(5, 5, 0, 5);
        gbc_lblYetkili.gridx = 0;
        gbc_lblYetkili.gridy = 6;
        musteriPanel.add(lblYetkili, gbc_lblYetkili);

        textFieldYetkili = new JTextField();
        GridBagConstraints gbc_textFieldYetkili = new GridBagConstraints();
        gbc_textFieldYetkili.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldYetkili.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldYetkili.gridx = 1;
        gbc_textFieldYetkili.gridy = 6;
        musteriPanel.add(textFieldYetkili, gbc_textFieldYetkili);
        textFieldYetkili.setColumns(10);

        JPanel siparisBilgisiPanel = new JPanel();
        GridBagConstraints gbc_siparisBilgisiPanel = new GridBagConstraints();
        gbc_siparisBilgisiPanel.insets = new Insets(5, 5, 5, 5);
        gbc_siparisBilgisiPanel.fill = GridBagConstraints.BOTH;
        gbc_siparisBilgisiPanel.gridx = 1;
        gbc_siparisBilgisiPanel.gridy = 0;
        add(siparisBilgisiPanel, gbc_siparisBilgisiPanel);
        GridBagLayout gbl_siparisBilgisiPanel = new GridBagLayout();
        gbl_siparisBilgisiPanel.columnWidths = new int[]{0, 0, 0};
        gbl_siparisBilgisiPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_siparisBilgisiPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_siparisBilgisiPanel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
                1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        siparisBilgisiPanel.setLayout(gbl_siparisBilgisiPanel);

        JLabel lblSiparisBilgisi = new JLabel("Sipariş Bilgisi");
        GridBagConstraints gbc_lblSiparisBilgisi = new GridBagConstraints();
        gbc_lblSiparisBilgisi.insets = new Insets(5, 5, 5, 5);
        gbc_lblSiparisBilgisi.gridx = 0;
        gbc_lblSiparisBilgisi.gridy = 0;
        siparisBilgisiPanel.add(lblSiparisBilgisi, gbc_lblSiparisBilgisi);

        JLabel lblBoyananMalzeme = new JLabel("Boyanan Malzeme");
        GridBagConstraints gbc_lblBoyananMalzeme = new GridBagConstraints();
        gbc_lblBoyananMalzeme.anchor = GridBagConstraints.EAST;
        gbc_lblBoyananMalzeme.insets = new Insets(5, 5, 5, 5);
        gbc_lblBoyananMalzeme.gridx = 0;
        gbc_lblBoyananMalzeme.gridy = 1;
        siparisBilgisiPanel.add(lblBoyananMalzeme, gbc_lblBoyananMalzeme);

        textFieldBoyananMalzeme = new JTextField();
        GridBagConstraints gbc_textFieldBoyananMalzeme = new GridBagConstraints();
        gbc_textFieldBoyananMalzeme.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldBoyananMalzeme.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBoyananMalzeme.gridx = 1;
        gbc_textFieldBoyananMalzeme.gridy = 1;
        siparisBilgisiPanel.add(textFieldBoyananMalzeme, gbc_textFieldBoyananMalzeme);
        textFieldBoyananMalzeme.setColumns(10);

        JLabel lblMalzemeCinsi = new JLabel("Malzeme Cinsi");
        GridBagConstraints gbc_lblMalzemeCinsi = new GridBagConstraints();
        gbc_lblMalzemeCinsi.anchor = GridBagConstraints.EAST;
        gbc_lblMalzemeCinsi.insets = new Insets(5, 5, 5, 5);
        gbc_lblMalzemeCinsi.gridx = 0;
        gbc_lblMalzemeCinsi.gridy = 2;
        siparisBilgisiPanel.add(lblMalzemeCinsi, gbc_lblMalzemeCinsi);

        textFieldMalzemeCinsi = new JTextField();
        GridBagConstraints gbc_textFieldMalzemeCinsi = new GridBagConstraints();
        gbc_textFieldMalzemeCinsi.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldMalzemeCinsi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldMalzemeCinsi.gridx = 1;
        gbc_textFieldMalzemeCinsi.gridy = 2;
        siparisBilgisiPanel.add(textFieldMalzemeCinsi, gbc_textFieldMalzemeCinsi);
        textFieldMalzemeCinsi.setColumns(10);

        JLabel lblYuzeyIslem = new JLabel("Yüzey İşlem");
        GridBagConstraints gbc_lblYuzeyIslem = new GridBagConstraints();
        gbc_lblYuzeyIslem.anchor = GridBagConstraints.EAST;
        gbc_lblYuzeyIslem.insets = new Insets(5, 5, 5, 5);
        gbc_lblYuzeyIslem.gridx = 0;
        gbc_lblYuzeyIslem.gridy = 3;
        siparisBilgisiPanel.add(lblYuzeyIslem, gbc_lblYuzeyIslem);

        textFieldYuzeyIslem = new JTextField();
        GridBagConstraints gbc_textFieldYuzeyIslem = new GridBagConstraints();
        gbc_textFieldYuzeyIslem.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldYuzeyIslem.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldYuzeyIslem.gridx = 1;
        gbc_textFieldYuzeyIslem.gridy = 3;
        siparisBilgisiPanel.add(textFieldYuzeyIslem, gbc_textFieldYuzeyIslem);
        textFieldYuzeyIslem.setColumns(10);

        JLabel lblRenkKodu = new JLabel("Renk Kodu");
        GridBagConstraints gbc_lblRenkKodu = new GridBagConstraints();
        gbc_lblRenkKodu.anchor = GridBagConstraints.EAST;
        gbc_lblRenkKodu.insets = new Insets(5, 5, 5, 5);
        gbc_lblRenkKodu.gridx = 0;
        gbc_lblRenkKodu.gridy = 4;
        siparisBilgisiPanel.add(lblRenkKodu, gbc_lblRenkKodu);

        textFieldRenkKodu = new JTextField();
        GridBagConstraints gbc_textFieldRenkKodu = new GridBagConstraints();
        gbc_textFieldRenkKodu.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldRenkKodu.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldRenkKodu.gridx = 1;
        gbc_textFieldRenkKodu.gridy = 4;
        siparisBilgisiPanel.add(textFieldRenkKodu, gbc_textFieldRenkKodu);
        textFieldRenkKodu.setColumns(10);

        JLabel lblBoyaMiktari = new JLabel("Boya Miktarı");
        GridBagConstraints gbc_lblBoyaMiktari = new GridBagConstraints();
        gbc_lblBoyaMiktari.anchor = GridBagConstraints.EAST;
        gbc_lblBoyaMiktari.insets = new Insets(5, 5, 5, 5);
        gbc_lblBoyaMiktari.gridx = 0;
        gbc_lblBoyaMiktari.gridy = 5;
        siparisBilgisiPanel.add(lblBoyaMiktari, gbc_lblBoyaMiktari);

        textFieldBoyaMiktari = new JTextField();
        GridBagConstraints gbc_textFieldBoyaMiktari = new GridBagConstraints();
        gbc_textFieldBoyaMiktari.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldBoyaMiktari.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBoyaMiktari.gridx = 1;
        gbc_textFieldBoyaMiktari.gridy = 5;
        siparisBilgisiPanel.add(textFieldBoyaMiktari, gbc_textFieldBoyaMiktari);
        textFieldBoyaMiktari.setColumns(10);

        JLabel lblIscilikSuresi = new JLabel("İşçilik Süresi");
        GridBagConstraints gbc_lblIscilikSuresi = new GridBagConstraints();
        gbc_lblIscilikSuresi.anchor = GridBagConstraints.EAST;
        gbc_lblIscilikSuresi.insets = new Insets(5, 5, 5, 5);
        gbc_lblIscilikSuresi.gridx = 0;
        gbc_lblIscilikSuresi.gridy = 6;
        siparisBilgisiPanel.add(lblIscilikSuresi, gbc_lblIscilikSuresi);

        textFieldIscilikSuresi = new JTextField();
        GridBagConstraints gbc_textFieldIscilikSuresi = new GridBagConstraints();
        gbc_textFieldIscilikSuresi.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldIscilikSuresi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldIscilikSuresi.gridx = 1;
        gbc_textFieldIscilikSuresi.gridy = 6;
        siparisBilgisiPanel.add(textFieldIscilikSuresi, gbc_textFieldIscilikSuresi);
        textFieldIscilikSuresi.setColumns(10);

        JLabel lblBoyananMalzemeMiktari = new JLabel("Boyanan Malzeme Miktarı");
        GridBagConstraints gbc_lblBoyananMalzemeMiktari = new GridBagConstraints();
        gbc_lblBoyananMalzemeMiktari.anchor = GridBagConstraints.EAST;
        gbc_lblBoyananMalzemeMiktari.insets = new Insets(5, 5, 5, 5);
        gbc_lblBoyananMalzemeMiktari.gridx = 0;
        gbc_lblBoyananMalzemeMiktari.gridy = 7;
        siparisBilgisiPanel.add(lblBoyananMalzemeMiktari, gbc_lblBoyananMalzemeMiktari);

        textFieldBoyananMalzemeMiktari = new JTextField();
        GridBagConstraints gbc_textFieldBoyananMalzemeMiktari = new GridBagConstraints();
        gbc_textFieldBoyananMalzemeMiktari.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldBoyananMalzemeMiktari.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBoyananMalzemeMiktari.gridx = 1;
        gbc_textFieldBoyananMalzemeMiktari.gridy = 7;
        siparisBilgisiPanel.add(textFieldBoyananMalzemeMiktari, gbc_textFieldBoyananMalzemeMiktari);
        textFieldBoyananMalzemeMiktari.setColumns(10);

        JLabel lblBirimi = new JLabel("Birimi");
        GridBagConstraints gbc_lblBirimi = new GridBagConstraints();
        gbc_lblBirimi.anchor = GridBagConstraints.EAST;
        gbc_lblBirimi.insets = new Insets(5, 5, 5, 5);
        gbc_lblBirimi.gridx = 0;
        gbc_lblBirimi.gridy = 8;
        siparisBilgisiPanel.add(lblBirimi, gbc_lblBirimi);

        textFieldBirimi = new JTextField();
        GridBagConstraints gbc_textFieldBirimi = new GridBagConstraints();
        gbc_textFieldBirimi.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldBirimi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBirimi.gridx = 1;
        gbc_textFieldBirimi.gridy = 8;
        siparisBilgisiPanel.add(textFieldBirimi, gbc_textFieldBirimi);
        textFieldBirimi.setColumns(10);

        JLabel lblHat = new JLabel("Hat");
        GridBagConstraints gbc_lblHat = new GridBagConstraints();
        gbc_lblHat.anchor = GridBagConstraints.EAST;
        gbc_lblHat.insets = new Insets(5, 5, 5, 5);
        gbc_lblHat.gridx = 0;
        gbc_lblHat.gridy = 9;
        siparisBilgisiPanel.add(lblHat, gbc_lblHat);

        textFieldHat = new JTextField();
        GridBagConstraints gbc_textFieldHat = new GridBagConstraints();
        gbc_textFieldHat.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldHat.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldHat.gridx = 1;
        gbc_textFieldHat.gridy = 9;
        siparisBilgisiPanel.add(textFieldHat, gbc_textFieldHat);
        textFieldHat.setColumns(10);

        JLabel lblBoyamaFiyati = new JLabel("Boyama Fiyatı");
        GridBagConstraints gbc_lblBoyamaFiyati = new GridBagConstraints();
        gbc_lblBoyamaFiyati.anchor = GridBagConstraints.EAST;
        gbc_lblBoyamaFiyati.insets = new Insets(5, 5, 5, 5);
        gbc_lblBoyamaFiyati.gridx = 0;
        gbc_lblBoyamaFiyati.gridy = 10;
        siparisBilgisiPanel.add(lblBoyamaFiyati, gbc_lblBoyamaFiyati);

        textFieldBoyamaFiyati = new JTextField();
        GridBagConstraints gbc_textFieldBoyamaFiyati = new GridBagConstraints();
        gbc_textFieldBoyamaFiyati.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldBoyamaFiyati.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBoyamaFiyati.gridx = 1;
        gbc_textFieldBoyamaFiyati.gridy = 10;
        siparisBilgisiPanel.add(textFieldBoyamaFiyati, gbc_textFieldBoyamaFiyati);
        textFieldBoyamaFiyati.setColumns(10);

        JLabel lblTutar = new JLabel("Tutar");
        GridBagConstraints gbc_lblTutar = new GridBagConstraints();
        gbc_lblTutar.anchor = GridBagConstraints.EAST;
        gbc_lblTutar.insets = new Insets(5, 5, 5, 5);
        gbc_lblTutar.gridx = 0;
        gbc_lblTutar.gridy = 11;
        siparisBilgisiPanel.add(lblTutar, gbc_lblTutar);

        textFieldTutar = new JTextField();
        GridBagConstraints gbc_textFieldTutar = new GridBagConstraints();
        gbc_textFieldTutar.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldTutar.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTutar.gridx = 1;
        gbc_textFieldTutar.gridy = 11;
        siparisBilgisiPanel.add(textFieldTutar, gbc_textFieldTutar);
        textFieldTutar.setColumns(10);

        JLabel lblAlimTarihi = new JLabel("Alım Tarihi");
        GridBagConstraints gbc_lblAlimTarihi = new GridBagConstraints();
        gbc_lblAlimTarihi.anchor = GridBagConstraints.EAST;
        gbc_lblAlimTarihi.insets = new Insets(5, 5, 5, 5);
        gbc_lblAlimTarihi.gridx = 0;
        gbc_lblAlimTarihi.gridy = 12;
        siparisBilgisiPanel.add(lblAlimTarihi, gbc_lblAlimTarihi);

        textFieldAlimTarihi = new JTextField();
        GridBagConstraints gbc_textFieldAlimTarihi = new GridBagConstraints();
        gbc_textFieldAlimTarihi.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldAlimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAlimTarihi.gridx = 1;
        gbc_textFieldAlimTarihi.gridy = 12;
        siparisBilgisiPanel.add(textFieldAlimTarihi, gbc_textFieldAlimTarihi);
        textFieldAlimTarihi.setColumns(10);

        JLabel lblTeslimTarihi = new JLabel("Teslim Tarihi");
        GridBagConstraints gbc_lblTeslimTarihi = new GridBagConstraints();
        gbc_lblTeslimTarihi.anchor = GridBagConstraints.EAST;
        gbc_lblTeslimTarihi.insets = new Insets(5, 5, 5, 5);
        gbc_lblTeslimTarihi.gridx = 0;
        gbc_lblTeslimTarihi.gridy = 13;
        siparisBilgisiPanel.add(lblTeslimTarihi, gbc_lblTeslimTarihi);

        textFieldTeslimTarihi = new JTextField();
        GridBagConstraints gbc_textFieldTeslimTarihi = new GridBagConstraints();
        gbc_textFieldTeslimTarihi.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldTeslimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTeslimTarihi.gridx = 1;
        gbc_textFieldTeslimTarihi.gridy = 13;
        siparisBilgisiPanel.add(textFieldTeslimTarihi, gbc_textFieldTeslimTarihi);
        textFieldTeslimTarihi.setColumns(10);

        JLabel lblIrsaliyeNo = new JLabel("İrsaliye Numarası");
        GridBagConstraints gbc_lblIrsaliyeNo = new GridBagConstraints();
        gbc_lblIrsaliyeNo.anchor = GridBagConstraints.EAST;
        gbc_lblIrsaliyeNo.insets = new Insets(5, 5, 5, 5);
        gbc_lblIrsaliyeNo.gridx = 0;
        gbc_lblIrsaliyeNo.gridy = 14;
        siparisBilgisiPanel.add(lblIrsaliyeNo, gbc_lblIrsaliyeNo);

        textFieldIrsaliyeNo = new JTextField();
        GridBagConstraints gbc_textFieldIrsaliyeNo = new GridBagConstraints();
        gbc_textFieldIrsaliyeNo.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldIrsaliyeNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldIrsaliyeNo.gridx = 1;
        gbc_textFieldIrsaliyeNo.gridy = 14;
        siparisBilgisiPanel.add(textFieldIrsaliyeNo, gbc_textFieldIrsaliyeNo);
        textFieldIrsaliyeNo.setColumns(10);

        JLabel lblFaturaNo = new JLabel("Fatura Numarası");
        GridBagConstraints gbc_lblFaturaNo = new GridBagConstraints();
        gbc_lblFaturaNo.anchor = GridBagConstraints.EAST;
        gbc_lblFaturaNo.insets = new Insets(5, 5, 5, 5);
        gbc_lblFaturaNo.gridx = 0;
        gbc_lblFaturaNo.gridy = 15;
        siparisBilgisiPanel.add(lblFaturaNo, gbc_lblFaturaNo);

        textFieldFaturaNo = new JTextField();
        GridBagConstraints gbc_textFieldFaturaNo = new GridBagConstraints();
        gbc_textFieldFaturaNo.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldFaturaNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFaturaNo.gridx = 1;
        gbc_textFieldFaturaNo.gridy = 15;
        siparisBilgisiPanel.add(textFieldFaturaNo, gbc_textFieldFaturaNo);
        textFieldFaturaNo.setColumns(10);

        JLabel lblVade = new JLabel("Vade");
        GridBagConstraints gbc_lblVade = new GridBagConstraints();
        gbc_lblVade.anchor = GridBagConstraints.EAST;
        gbc_lblVade.insets = new Insets(5, 5, 5, 5);
        gbc_lblVade.gridx = 0;
        gbc_lblVade.gridy = 16;
        siparisBilgisiPanel.add(lblVade, gbc_lblVade);

        textFieldVade = new JTextField();
        GridBagConstraints gbc_textFieldVade = new GridBagConstraints();
        gbc_textFieldVade.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldVade.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVade.gridx = 1;
        gbc_textFieldVade.gridy = 16;
        siparisBilgisiPanel.add(textFieldVade, gbc_textFieldVade);
        textFieldVade.setColumns(10);

        btnfaturalandir = new JButton("Faturalandır");
        GridBagConstraints gbc_faturalandir = new GridBagConstraints();
        gbc_faturalandir.fill = GridBagConstraints.VERTICAL;
        gbc_faturalandir.gridwidth = 2;
        gbc_faturalandir.insets = new Insets(5, 5, 5, 5);
        gbc_faturalandir.gridx = 0;
        gbc_faturalandir.gridy = 1;
        add(btnfaturalandir, gbc_faturalandir);
    }

    public JTextField getTextFieldMusteriAdi() {
        return textFieldMusteriAdi;
    }

    public JTextField getTextFieldBelgeNumarasi() {
        return textFieldBelgeNumarasi;
    }

    public JTextArea getTextAreaAdres() {
        return textAreaAdres;
    }

    public JTextField getTextFieldVergiDairesi() {
        return textFieldVergiDairesi;
    }

    public JTextField getTextFieldVergiNo() {
        return textFieldVergiNo;
    }

    public JTextField getTextFieldYetkili() {
        return textFieldYetkili;
    }

    public JTextField getTextFieldBoyananMalzeme() {
        return textFieldBoyananMalzeme;
    }

    public JTextField getTextFieldMalzemeCinsi() {
        return textFieldMalzemeCinsi;
    }

    public JTextField getTextFieldYuzeyIslem() {
        return textFieldYuzeyIslem;
    }

    public JTextField getTextFieldRenkKodu() {
        return textFieldRenkKodu;
    }

    public JTextField getTextFieldBoyaMiktari() {
        return textFieldBoyaMiktari;
    }

    public JTextField getTextFieldIscilikSuresi() {
        return textFieldIscilikSuresi;
    }

    public JTextField getTextFieldBoyananMalzemeMiktari() {
        return textFieldBoyananMalzemeMiktari;
    }

    public JTextField getTextFieldBirimi() {
        return textFieldBirimi;
    }

    public JTextField getTextFieldHat() {
        return textFieldHat;
    }

    public JTextField getTextFieldBoyamaFiyati() {
        return textFieldBoyamaFiyati;
    }

    public JTextField getTextFieldTutar() {
        return textFieldTutar;
    }

    public JTextField getTextFieldAlimTarihi() {
        return textFieldAlimTarihi;
    }

    public JTextField getTextFieldTeslimTarihi() {
        return textFieldTeslimTarihi;
    }

    public JTextField getTextFieldIrsaliyeNo() {
        return textFieldIrsaliyeNo;
    }

    public JTextField getTextFieldFaturaNo() {
        return textFieldFaturaNo;
    }

    public JTextField getTextFieldVade() {
        return textFieldVade;
    }

    public JButton getBtnfaturalandir() {
        return btnfaturalandir;
    }

}
