package com.setkim.ekleme.panels.stokkarti;

import javax.swing.*;
import java.awt.*;

public class StokKartiPanel extends JPanel {

    private JTextField txtFieldStokKartAdi;
    private JButton btnEkle;

    public StokKartiPanel() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
        setLayout(gridBagLayout);

        JLabel lblStokKartAdi = new JLabel("Stok Kart Adı:");
        GridBagConstraints gbc_lblStokKartAdi = new GridBagConstraints();
        gbc_lblStokKartAdi.insets = new Insets(0, 0, 5, 5);
        gbc_lblStokKartAdi.anchor = GridBagConstraints.EAST;
        gbc_lblStokKartAdi.gridx = 0;
        gbc_lblStokKartAdi.gridy = 0;
        add(lblStokKartAdi, gbc_lblStokKartAdi);

        txtFieldStokKartAdi = new JTextField();
        GridBagConstraints gbc_txtFieldStokKartAdi = new GridBagConstraints();
        gbc_txtFieldStokKartAdi.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldStokKartAdi.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldStokKartAdi.gridx = 1;
        gbc_txtFieldStokKartAdi.gridy = 0;
        add(txtFieldStokKartAdi, gbc_txtFieldStokKartAdi);
        txtFieldStokKartAdi.setColumns(10);

        btnEkle = new JButton("Ekle");
        GridBagConstraints gbc_btnEkle = new GridBagConstraints();
        gbc_btnEkle.gridwidth = 2;
        gbc_btnEkle.insets = new Insets(0, 0, 0, 5);
        gbc_btnEkle.gridx = 0;
        gbc_btnEkle.gridy = 2;
        add(btnEkle, gbc_btnEkle);
    }

    public JTextField getTxtFieldStokKartAdi() {
        return txtFieldStokKartAdi;
    }

    public JButton getBtnEkle() {
        return btnEkle;
    }
}
