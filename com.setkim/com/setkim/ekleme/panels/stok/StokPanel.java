package com.setkim.ekleme.panels.stok;

import javax.swing.*;
import java.awt.*;

public class StokPanel extends JPanel {

    private JComboBox cmbBoxStokKart;
    private JTextField txtFieldStokKodu;
    private JTextField txtFieldStokAdi;
    private JTextField txtFieldBirim;
    private JTextField txtFieldFiyat;
    private JTextField txtFieldMiktar;
    private JTextField txtFieldTutar;
    private JButton btnEkle;

    public StokPanel() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        setLayout(gridBagLayout);

        JLabel lblStokKartAdi = new JLabel("Stok Kart Adı:");
        GridBagConstraints gbc_lblStokKartAdi = new GridBagConstraints();
        gbc_lblStokKartAdi.anchor = GridBagConstraints.EAST;
        gbc_lblStokKartAdi.insets = new Insets(0, 0, 5, 5);
        gbc_lblStokKartAdi.gridx = 0;
        gbc_lblStokKartAdi.gridy = 0;
        add(lblStokKartAdi, gbc_lblStokKartAdi);

        cmbBoxStokKart = new JComboBox();
        GridBagConstraints gbc_cmbBoxStokKart = new GridBagConstraints();
        gbc_cmbBoxStokKart.insets = new Insets(0, 0, 5, 0);
        gbc_cmbBoxStokKart.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbBoxStokKart.gridx = 1;
        gbc_cmbBoxStokKart.gridy = 0;
        add(cmbBoxStokKart, gbc_cmbBoxStokKart);

        JLabel lblStokKodu = new JLabel("Stok Kodu:");
        GridBagConstraints gbc_lblStokKodu = new GridBagConstraints();
        gbc_lblStokKodu.anchor = GridBagConstraints.EAST;
        gbc_lblStokKodu.insets = new Insets(0, 0, 5, 5);
        gbc_lblStokKodu.gridx = 0;
        gbc_lblStokKodu.gridy = 1;
        add(lblStokKodu, gbc_lblStokKodu);

        txtFieldStokKodu = new JTextField();
        GridBagConstraints gbc_txtFieldStokKodu = new GridBagConstraints();
        gbc_txtFieldStokKodu.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldStokKodu.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldStokKodu.gridx = 1;
        gbc_txtFieldStokKodu.gridy = 1;
        add(txtFieldStokKodu, gbc_txtFieldStokKodu);
        txtFieldStokKodu.setColumns(10);

        JLabel lblStokAdi = new JLabel("Stok Adı:");
        GridBagConstraints gbc_lblStokAdi = new GridBagConstraints();
        gbc_lblStokAdi.anchor = GridBagConstraints.EAST;
        gbc_lblStokAdi.insets = new Insets(0, 0, 5, 5);
        gbc_lblStokAdi.gridx = 0;
        gbc_lblStokAdi.gridy = 2;
        add(lblStokAdi, gbc_lblStokAdi);

        txtFieldStokAdi = new JTextField();
        GridBagConstraints gbc_txtFieldStokAdi = new GridBagConstraints();
        gbc_txtFieldStokAdi.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldStokAdi.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldStokAdi.gridx = 1;
        gbc_txtFieldStokAdi.gridy = 2;
        add(txtFieldStokAdi, gbc_txtFieldStokAdi);
        txtFieldStokAdi.setColumns(10);

        JLabel lblBirim = new JLabel("Birimi:");
        GridBagConstraints gbc_lblBirim = new GridBagConstraints();
        gbc_lblBirim.anchor = GridBagConstraints.EAST;
        gbc_lblBirim.insets = new Insets(0, 0, 5, 5);
        gbc_lblBirim.gridx = 0;
        gbc_lblBirim.gridy = 3;
        add(lblBirim, gbc_lblBirim);

        txtFieldBirim = new JTextField();
        GridBagConstraints gbc_txtFieldBirim = new GridBagConstraints();
        gbc_txtFieldBirim.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldBirim.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldBirim.gridx = 1;
        gbc_txtFieldBirim.gridy = 3;
        add(txtFieldBirim, gbc_txtFieldBirim);
        txtFieldBirim.setColumns(10);

        JLabel lblFiyat = new JLabel("Fiyat:");
        GridBagConstraints gbc_lblFiyat = new GridBagConstraints();
        gbc_lblFiyat.anchor = GridBagConstraints.EAST;
        gbc_lblFiyat.insets = new Insets(0, 0, 5, 5);
        gbc_lblFiyat.gridx = 0;
        gbc_lblFiyat.gridy = 4;
        add(lblFiyat, gbc_lblFiyat);

        txtFieldFiyat = new JTextField();
        GridBagConstraints gbc_txtFieldFiyat = new GridBagConstraints();
        gbc_txtFieldFiyat.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldFiyat.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldFiyat.gridx = 1;
        gbc_txtFieldFiyat.gridy = 4;
        add(txtFieldFiyat, gbc_txtFieldFiyat);
        txtFieldFiyat.setColumns(10);

        JLabel lblMiktar = new JLabel("Miktar:");
        GridBagConstraints gbc_lblMiktar = new GridBagConstraints();
        gbc_lblMiktar.anchor = GridBagConstraints.EAST;
        gbc_lblMiktar.insets = new Insets(0, 0, 5, 5);
        gbc_lblMiktar.gridx = 0;
        gbc_lblMiktar.gridy = 5;
        add(lblMiktar, gbc_lblMiktar);

        txtFieldMiktar = new JTextField();
        GridBagConstraints gbc_txtFieldMiktar = new GridBagConstraints();
        gbc_txtFieldMiktar.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldMiktar.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldMiktar.gridx = 1;
        gbc_txtFieldMiktar.gridy = 5;
        add(txtFieldMiktar, gbc_txtFieldMiktar);
        txtFieldMiktar.setColumns(10);

        JLabel lblTutar = new JLabel("Tutar:");
        GridBagConstraints gbc_lblTutar = new GridBagConstraints();
        gbc_lblTutar.anchor = GridBagConstraints.EAST;
        gbc_lblTutar.insets = new Insets(0, 0, 5, 5);
        gbc_lblTutar.gridx = 0;
        gbc_lblTutar.gridy = 6;
        add(lblTutar, gbc_lblTutar);

        txtFieldTutar = new JTextField();
        GridBagConstraints gbc_txtFieldTutar = new GridBagConstraints();
        gbc_txtFieldTutar.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldTutar.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldTutar.gridx = 1;
        gbc_txtFieldTutar.gridy = 6;
        add(txtFieldTutar, gbc_txtFieldTutar);
        txtFieldTutar.setColumns(10);

        btnEkle = new JButton("Ekle");
        GridBagConstraints gbc_btnEkle = new GridBagConstraints();
        gbc_btnEkle.gridwidth = 2;
        gbc_btnEkle.gridx = 0;
        gbc_btnEkle.gridy = 8;
        add(btnEkle, gbc_btnEkle);
    }

    public JComboBox getCmbBoxStokKart() {

        return cmbBoxStokKart;
    }

    public JTextField getTxtFieldStokKodu() {

        return txtFieldStokKodu;
    }

    public JTextField getTxtFieldStokAdi() {

        return txtFieldStokAdi;
    }

    public JTextField getTxtFieldBirim() {

        return txtFieldBirim;
    }

    public JTextField getTxtFieldFiyat() {

        return txtFieldFiyat;
    }

    public JTextField getTxtFieldMiktar() {

        return txtFieldMiktar;
    }

    public JTextField getTxtFieldTutar() {

        return txtFieldTutar;
    }

    public JButton getBtnEkle() {

        return btnEkle;
    }

}
