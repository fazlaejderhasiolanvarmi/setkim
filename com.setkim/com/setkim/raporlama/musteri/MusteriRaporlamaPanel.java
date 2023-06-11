package com.setkim.raporlama.musteri;

import javax.swing.*;
import java.awt.*;

public class MusteriRaporlamaPanel extends JPanel {
    private JTable table;
    private JComboBox musteriDropdown;
    private JButton raporlaBtn;
    public MusteriRaporlamaPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        musteriDropdown = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.gridx = 2;
        gbc_comboBox.gridy = 1;
        add(musteriDropdown, gbc_comboBox);

        table = new JTable();
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.insets = new Insets(0, 0, 5, 5);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 2;
        gbc_table.gridy = 3;
        add(table, gbc_table);

        raporlaBtn = new JButton("Raporla");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 5;
        add(raporlaBtn, gbc_btnNewButton);
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox getMusteriDropdown() {
        return musteriDropdown;
    }

    public JButton getRaporlaBtn() {
        return raporlaBtn;
    }
}
