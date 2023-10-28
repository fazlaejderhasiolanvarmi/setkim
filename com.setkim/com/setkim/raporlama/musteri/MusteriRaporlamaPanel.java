package com.setkim.raporlama.musteri;

import com.setkim.util.objects.Musteri;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MusteriRaporlamaPanel extends JPanel {
    private JTable table;
    private JComboBox<Musteri> musteriDropdown;
    private JButton raporlaBtn;

    public MusteriRaporlamaPanel() {
        setBounds(100, 100, 800, 800);

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
        tableModel.addColumn("Alım Tarihi");
        tableModel.addColumn("Teslim Tarihi");
        tableModel.addColumn("İrsaliye No");
        tableModel.addColumn("Fatura No");
        tableModel.addColumn("Vade");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.insets = new Insets(0, 0, 5, 5);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 2;
        gbc_table.gridy = 3;
        add(scrollPane, gbc_table);


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
