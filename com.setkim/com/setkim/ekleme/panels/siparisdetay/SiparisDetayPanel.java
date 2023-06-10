package com.setkim.ekleme.panels.siparisdetay;

import javax.swing.*;
import java.awt.*;

public class SiparisDetayPanel extends JPanel {
    private JTextField textFieldMalzemeAlimTarihi;
    private JTextField textFieldTeslimTarihi;
    private JTextField textFieldIrsaliyeNo;
    private JTextField textFieldFaturaNo;
    private JTextField textFieldVade;

    private JButton btnEkle;

    public SiparisDetayPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.16, 0.16, 0.16, 0.16, 0.16, 0.2, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Malzeme Alım Tarihi");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 11;
        add(lblNewLabel, gbc_lblNewLabel);

        textFieldMalzemeAlimTarihi = new JTextField();
        GridBagConstraints gbc_textFieldMalzemeAlimTarihi = new GridBagConstraints();
        gbc_textFieldMalzemeAlimTarihi.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldMalzemeAlimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldMalzemeAlimTarihi.gridx = 1;
        gbc_textFieldMalzemeAlimTarihi.gridy = 11;
        add(textFieldMalzemeAlimTarihi, gbc_textFieldMalzemeAlimTarihi);
        textFieldMalzemeAlimTarihi.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Teslim Tarihi");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 12;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

        textFieldTeslimTarihi = new JTextField();
        GridBagConstraints gbc_textFieldTeslimTarihi = new GridBagConstraints();
        gbc_textFieldTeslimTarihi.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldTeslimTarihi.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTeslimTarihi.gridx = 1;
        gbc_textFieldTeslimTarihi.gridy = 12;
        add(textFieldTeslimTarihi, gbc_textFieldTeslimTarihi);
        textFieldTeslimTarihi.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("İrsaliye No");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 13;
        add(lblNewLabel_2, gbc_lblNewLabel_2);

        textFieldIrsaliyeNo = new JTextField();
        GridBagConstraints gbc_textFieldIrsaliyeNo = new GridBagConstraints();
        gbc_textFieldIrsaliyeNo.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldIrsaliyeNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldIrsaliyeNo.gridx = 1;
        gbc_textFieldIrsaliyeNo.gridy = 13;
        add(textFieldIrsaliyeNo, gbc_textFieldIrsaliyeNo);
        textFieldIrsaliyeNo.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Fatura No");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 14;
        add(lblNewLabel_3, gbc_lblNewLabel_3);

        textFieldFaturaNo = new JTextField();
        GridBagConstraints gbc_textFieldFaturaNo = new GridBagConstraints();
        gbc_textFieldFaturaNo.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldFaturaNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFaturaNo.gridx = 1;
        gbc_textFieldFaturaNo.gridy = 14;
        add(textFieldFaturaNo, gbc_textFieldFaturaNo);
        textFieldFaturaNo.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Vade");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 15;
        add(lblNewLabel_4, gbc_lblNewLabel_4);

        textFieldVade = new JTextField();
        GridBagConstraints gbc_textFieldVade = new GridBagConstraints();
        gbc_textFieldVade.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldVade.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldVade.gridx = 1;
        gbc_textFieldVade.gridy = 15;
        add(textFieldVade, gbc_textFieldVade);
        textFieldVade.setColumns(10);

        btnEkle = new JButton("Ekle");
        GridBagConstraints gbc_btnEkle = new GridBagConstraints();
        gbc_btnEkle.fill = GridBagConstraints.VERTICAL;
        gbc_btnEkle.gridwidth = 3;
        gbc_btnEkle.insets = new Insets(0, 0, 0, 5);
        gbc_btnEkle.gridx = 0;
        gbc_btnEkle.gridy = 5;
        add(btnEkle, gbc_btnEkle);
    }

    public JTextField getTextFieldMalzemeAlimTarihi() {
        return textFieldMalzemeAlimTarihi;
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

    public JButton getBtnEkle() {
        return btnEkle;
    }
}
