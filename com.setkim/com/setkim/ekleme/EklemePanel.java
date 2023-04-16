package com.setkim.ekleme;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class EklemePanel extends JPanel {

    private JPanel wrapperPanel;
    private JComboBox comboBox;
    public EklemePanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0};
        gridBagLayout.rowHeights = new int[]{0, 0};
        gridBagLayout.columnWeights = new double[]{1.0};
        gridBagLayout.rowWeights = new double[]{0.1, 1.0};
        setLayout(gridBagLayout);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Müşteri Bilgisi", "Sipariş", "Sipariş Detayı" }));
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 0;
        gbc_comboBox.gridy = 0;
        add(comboBox, gbc_comboBox);

        wrapperPanel = new JPanel();
        GridBagConstraints gbc_wrapperPanel = new GridBagConstraints();
        gbc_wrapperPanel.fill = GridBagConstraints.BOTH;
        gbc_wrapperPanel.gridx = 0;
        gbc_wrapperPanel.gridy = 1;
        add(wrapperPanel, gbc_wrapperPanel);
    }

    public JPanel getWrapperPanel() {
        return wrapperPanel;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}