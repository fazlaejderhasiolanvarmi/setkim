package com.setkim.ekleme;

import java.awt.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class EklemePanel extends JPanel {

    private JPanel wrapperPanel;
    private JComboBox comboBox;
    private JButton btnSec;

    public EklemePanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.15, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        setLayout(gridBagLayout);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Müşteri Bilgisi", "Sipariş", "Sipariş Detayı" }));
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 0;
        gbc_comboBox.gridy = 0;
        add(comboBox, gbc_comboBox);

        btnSec = new JButton("Seç");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 0;
        add(btnSec, gbc_btnNewButton);

        wrapperPanel = new JPanel();
        GridBagConstraints gbc_wrapperPanel = new GridBagConstraints();
        gbc_wrapperPanel.gridwidth = 3;
        gbc_wrapperPanel.insets = new Insets(0, 0, 0, 5);
        gbc_wrapperPanel.fill = GridBagConstraints.BOTH;
        gbc_wrapperPanel.gridx = 0;
        gbc_wrapperPanel.gridy = 1;

        add(wrapperPanel, gbc_wrapperPanel);
    }

    public JPanel getWrapperPanel() {
        return wrapperPanel;
    }

    public void setWrapperPanel(JPanel wrapperPanel) {
        this.wrapperPanel = wrapperPanel;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JButton getBtnSec() {
        return btnSec;
    }

}
