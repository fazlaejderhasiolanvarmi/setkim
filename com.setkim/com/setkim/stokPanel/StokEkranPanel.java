package com.setkim.stokPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StokEkranPanel extends JPanel {

    private JTable table;
    private JComboBox comboBox;

    public StokEkranPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 0;
        add(comboBox, gbc_comboBox);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("asdf");

        table = new JTable(model);
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.insets = new Insets(0, 0, 5, 5);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 1;
        gbc_table.gridy = 1;

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, gbc_table);
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

}
