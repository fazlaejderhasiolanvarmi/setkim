package com.setkim.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainPanel extends JPanel {
    private JTable table;
    private JButton btnEkleme;
    private JButton btnRaporlama;

    public MainPanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{260, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.95, 0.05};
        panel.setLayout(gbl_panel);

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Boyanan Malzeme");
        tableModel.addColumn("Malzeme Cinsi");
        tableModel.addColumn("Yüzey İşlem");
        tableModel.addColumn("Renk Kodu");
        tableModel.addColumn("Boya Miktarı");
        tableModel.addColumn("İşçilik Süresi");
        tableModel.addColumn("Boyanan Malzeme Miktarı");
        tableModel.addColumn("Birimi");
        tableModel.addColumn("Hat");
        tableModel.addColumn("Boyama Fiyatı");
        tableModel.addColumn("Tutar");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        panel.add(scrollPane, gbc_scrollPane);

        JPanel buttonWrapper = new JPanel();
        GridBagConstraints gbc_buttonWrapper = new GridBagConstraints();
        gbc_buttonWrapper.fill = GridBagConstraints.BOTH;
        gbc_buttonWrapper.gridx = 0;
        gbc_buttonWrapper.gridy = 1;
        panel.add(buttonWrapper, gbc_buttonWrapper);
        GridBagLayout gbl_buttonWrapper = new GridBagLayout();
        gbl_buttonWrapper.columnWidths = new int[]{0, 0};
        gbl_buttonWrapper.rowHeights = new int[]{0};
        gbl_buttonWrapper.columnWeights = new double[]{0.3, 0.4, 0.3};
        gbl_buttonWrapper.rowWeights = new double[]{Double.MIN_VALUE};
        buttonWrapper.setLayout(gbl_buttonWrapper);

        btnEkleme = new JButton("Ekle");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 0;
        buttonWrapper.add(btnEkleme, gbc_btnNewButton);

        btnRaporlama = new JButton("Raporlama");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton_1.gridx = 2;
        gbc_btnNewButton_1.gridy = 0;
        buttonWrapper.add(btnRaporlama, gbc_btnNewButton_1);
    }

    public JTable getTable() {
        return table;
    }

    public JButton getBtnEkleme() {
        return btnEkleme;
    }

    public JButton getBtnRaporlama() {
        return btnRaporlama;
    }

}
