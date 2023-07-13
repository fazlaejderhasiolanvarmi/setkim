package com.setkim.raporlama.tarih;

import javax.swing.*;
import java.awt.*;

public class TarihRaporlamaPanel extends JPanel {

    private JTextField textFieldTarihKucuk;
    private JTextField textFieldTarihBuyuk;
    private JScrollPane scrollPane;
    private JButton btnTarihSecKucuk;
    private JButton btnTarihSecBuyuk;

    public TarihRaporlamaPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        textFieldTarihKucuk = new JTextField();
        GridBagConstraints gbc_textFieldTarihKucuk = new GridBagConstraints();
        gbc_textFieldTarihKucuk.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldTarihKucuk.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTarihKucuk.gridx = 0;
        gbc_textFieldTarihKucuk.gridy = 0;
        add(textFieldTarihKucuk, gbc_textFieldTarihKucuk);
        textFieldTarihKucuk.setColumns(10);

        btnTarihSecKucuk = new JButton("Seç");
        GridBagConstraints gbc_btnTarihSecKucuk = new GridBagConstraints();
        gbc_btnTarihSecKucuk.insets = new Insets(5, 5, 5, 5);
        gbc_btnTarihSecKucuk.gridx = 1;
        gbc_btnTarihSecKucuk.gridy = 0;
        add(btnTarihSecKucuk, gbc_btnTarihSecKucuk);

        textFieldTarihBuyuk = new JTextField();
        GridBagConstraints gbc_textFieldTarihBuyuk = new GridBagConstraints();
        gbc_textFieldTarihBuyuk.insets = new Insets(5, 5, 5, 5);
        gbc_textFieldTarihBuyuk.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTarihBuyuk.gridx = 2;
        gbc_textFieldTarihBuyuk.gridy = 0;
        add(textFieldTarihBuyuk, gbc_textFieldTarihBuyuk);
        textFieldTarihBuyuk.setColumns(10);

        btnTarihSecBuyuk = new JButton("Seç");
        GridBagConstraints gbc_btnTarihSecBuyuk = new GridBagConstraints();
        gbc_btnTarihSecBuyuk.insets = new Insets(5, 5, 5, 5);
        gbc_btnTarihSecBuyuk.gridx = 3;
        gbc_btnTarihSecBuyuk.gridy = 0;
        add(btnTarihSecBuyuk, gbc_btnTarihSecBuyuk);

        JPanel tablePanel = new JPanel();
        GridBagConstraints gbc_tablePanel = new GridBagConstraints();
        gbc_tablePanel.gridwidth = 4;
        gbc_tablePanel.fill = GridBagConstraints.BOTH;
        gbc_tablePanel.gridx = 0;
        gbc_tablePanel.gridy = 1;
        add(tablePanel, gbc_tablePanel);
        GridBagLayout gbl_tablePanel = new GridBagLayout();
        gbl_tablePanel.columnWidths = new int[]{0, 0};
        gbl_tablePanel.rowHeights = new int[]{0, 0};
        gbl_tablePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_tablePanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        tablePanel.setLayout(gbl_tablePanel);

        scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        tablePanel.add(scrollPane, gbc_scrollPane);
    }

    public JTextField getTextFieldTarihKucuk() {
        return textFieldTarihKucuk;
    }

    public JTextField getTextFieldTarihBuyuk() {
        return textFieldTarihBuyuk;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JButton getBtnTarihSecKucuk() {
        return btnTarihSecKucuk;
    }

    public JButton getBtnTarihSecBuyuk() {
        return btnTarihSecBuyuk;
    }

}

