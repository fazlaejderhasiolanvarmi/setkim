package com.setkim.ekleme.panels.musteri;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MusteriPanel extends JPanel {
    private JTextField textFieldMusteriAdi;
    private JTextField textFieldBelgeNo;
    private JTextField textFieldAdres;
    private JTextField textFieldVergiDairesi;
    private JTextField textFieldVergiNo;
    private JTextField textFieldYetkili;
    private JButton btnEkle;

    public MusteriPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125 };
        setLayout(gridBagLayout);

        JLabel lblNewLabel_2 = new JLabel("Müşteri Adı");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.gridwidth = 2;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 0;
        add(lblNewLabel_2, gbc_lblNewLabel_2);

        textFieldMusteriAdi = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 0;
        add(textFieldMusteriAdi, gbc_textField_1);
        textFieldMusteriAdi.setColumns(10);

        JLabel lblNewLabel = new JLabel("Belge No");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 2;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        add(lblNewLabel, gbc_lblNewLabel);

        textFieldBelgeNo = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 1;
        add(textFieldBelgeNo, gbc_textField_2);
        textFieldBelgeNo.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Adres");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.gridwidth = 2;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 2;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

        textFieldAdres = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 0);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 2;
        add(textFieldAdres, gbc_textField_3);
        textFieldAdres.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Vergi Dairesi");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.gridwidth = 2;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        add(lblNewLabel_3, gbc_lblNewLabel_3);

        textFieldVergiDairesi = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 0);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 2;
        gbc_textField_4.gridy = 3;
        add(textFieldVergiDairesi, gbc_textField_4);
        textFieldVergiDairesi.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Vergi No");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.gridwidth = 2;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 4;
        add(lblNewLabel_4, gbc_lblNewLabel_4);

        textFieldVergiNo = new JTextField();
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.insets = new Insets(0, 0, 5, 0);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 2;
        gbc_textField_5.gridy = 4;
        add(textFieldVergiNo, gbc_textField_5);
        textFieldVergiNo.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Yetkili");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.gridwidth = 2;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 5;
        add(lblNewLabel_5, gbc_lblNewLabel_5);

        textFieldYetkili = new JTextField();
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.insets = new Insets(0, 0, 5, 0);
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.gridx = 2;
        gbc_textField_6.gridy = 5;
        add(textFieldYetkili, gbc_textField_6);
        textFieldYetkili.setColumns(10);

        btnEkle = new JButton("Ekle");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
        gbc_btnNewButton.gridwidth = 3;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 7;
        add(btnEkle, gbc_btnNewButton);
    }

    public JButton getBtnEkle() {
        return btnEkle;
    }

    public JTextField getTextFieldMusteriAdi() {
        return textFieldMusteriAdi;
    }

    public JTextField getTextFieldBelgeNo() {
        return textFieldBelgeNo;
    }

    public JTextField getTextFieldAdres() {
        return textFieldAdres;
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
}
