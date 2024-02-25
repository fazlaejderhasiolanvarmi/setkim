package com.setkim.raporlama.musteri;

import com.setkim.util.objects.Musteri;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MusteriRaporlamaPanel extends JPanel {
    private JTable table;
    private JComboBox<Musteri> musteriDropdown;
    private JButton raporlaBtn;

    private JRadioButton rdBtnIsTarihFilterEnabled;
    private JSpinner baslangicDateSpinner;
    private JSpinner bitisDateSpinner;
    private JTextField txtFieldToplamIscilik;
    private JTextField txtFieldToplamBoya;
    private JTextField txtFieldToplamTutar;

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
        tableModel.addColumn("Sipariş No"); // Gizli ama aramayı kolaylaştırsın diye var

        JPanel tarihPanel = new JPanel();
        GridBagConstraints gbc_tarihPanel = new GridBagConstraints();
        gbc_tarihPanel.insets = new Insets(0, 0, 5, 5);
        gbc_tarihPanel.fill = GridBagConstraints.BOTH;
        gbc_tarihPanel.gridx = 2;
        gbc_tarihPanel.gridy = 2;
        add(tarihPanel, gbc_tarihPanel);
        GridBagLayout gbl_tarihPanel = new GridBagLayout();
        gbl_tarihPanel.columnWidths = new int[]{0, 0, 0, 30, 0, 0, 0, 0};
        gbl_tarihPanel.rowHeights = new int[]{20, 0};
        gbl_tarihPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_tarihPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        tarihPanel.setLayout(gbl_tarihPanel);

        rdBtnIsTarihFilterEnabled = new JRadioButton("Tarihe Göre Filtrele");
        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 0, 5);
        gbc_rdbtnNewRadioButton.gridx = 0;
        gbc_rdbtnNewRadioButton.gridy = 0;
        tarihPanel.add(rdBtnIsTarihFilterEnabled, gbc_rdbtnNewRadioButton);

        JSeparator separator = new JSeparator();
        GridBagConstraints gbc_separator = new GridBagConstraints();
        gbc_separator.insets = new Insets(0, 0, 0, 5);
        gbc_separator.gridx = 1;
        gbc_separator.gridy = 0;
        tarihPanel.add(separator, gbc_separator);

        JLabel lblBaslangicTarih = new JLabel("Başlangıç Tarihi:");
        GridBagConstraints gbc_lblBaslangicTarih = new GridBagConstraints();
        gbc_lblBaslangicTarih.insets = new Insets(0, 0, 0, 5);
        gbc_lblBaslangicTarih.gridx = 2;
        gbc_lblBaslangicTarih.gridy = 0;
        tarihPanel.add(lblBaslangicTarih, gbc_lblBaslangicTarih);

        SpinnerDateModel baslangicTarihModel = new SpinnerDateModel();

        baslangicDateSpinner = new JSpinner(baslangicTarihModel);
        JComponent baslangicTarih = new JSpinner.DateEditor(baslangicDateSpinner, "dd/MM/yyyy");
        baslangicDateSpinner.setEditor(baslangicTarih);
        GridBagConstraints gbc_baslangicDateSpinner = new GridBagConstraints();
        gbc_baslangicDateSpinner.insets = new Insets(0, 0, 0, 5);
        gbc_baslangicDateSpinner.anchor = GridBagConstraints.NORTHWEST;
        gbc_baslangicDateSpinner.gridx = 3;
        gbc_baslangicDateSpinner.gridy = 0;
        tarihPanel.add(baslangicDateSpinner, gbc_baslangicDateSpinner);

        JLabel lblBitisTarih = new JLabel("Bitiş Tarihi:");
        GridBagConstraints gbc_lblBitisTarih = new GridBagConstraints();
        gbc_lblBitisTarih.insets = new Insets(0, 0, 0, 5);
        gbc_lblBitisTarih.gridx = 5;
        gbc_lblBitisTarih.gridy = 0;
        tarihPanel.add(lblBitisTarih, gbc_lblBitisTarih);

        SpinnerDateModel bitisTarihModel = new SpinnerDateModel();

        bitisDateSpinner = new JSpinner(bitisTarihModel);
        JComponent bitisTarih = new JSpinner.DateEditor(bitisDateSpinner, "dd/MM/yyyy");
        bitisDateSpinner.setEditor(bitisTarih);
        GridBagConstraints gbc_bitisDateSpinner = new GridBagConstraints();
        gbc_bitisDateSpinner.gridx = 6;
        gbc_bitisDateSpinner.gridy = 0;
        tarihPanel.add(bitisDateSpinner, gbc_bitisDateSpinner);

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.insets = new Insets(0, 0, 5, 5);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 2;
        gbc_table.gridy = 3;
        add(scrollPane, gbc_table);

        JPanel toplamPanel = new JPanel();
        GridBagConstraints gbc_toplamPanel = new GridBagConstraints();
        gbc_toplamPanel.insets = new Insets(0, 0, 5, 5);
        gbc_toplamPanel.fill = GridBagConstraints.BOTH;
        gbc_toplamPanel.gridx = 2;
        gbc_toplamPanel.gridy = 4;
        add(toplamPanel, gbc_toplamPanel);
        GridBagLayout gbl_toplamPanel = new GridBagLayout();
        gbl_toplamPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_toplamPanel.rowHeights = new int[]{0, 0};
        gbl_toplamPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_toplamPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        toplamPanel.setLayout(gbl_toplamPanel);

        JLabel lblToplamIscilik = new JLabel("Toplam İşçilik Süresi:");
        GridBagConstraints gbc_lblToplamIscilik = new GridBagConstraints();
        gbc_lblToplamIscilik.insets = new Insets(0, 0, 0, 5);
        gbc_lblToplamIscilik.anchor = GridBagConstraints.EAST;
        gbc_lblToplamIscilik.gridx = 0;
        gbc_lblToplamIscilik.gridy = 0;
        toplamPanel.add(lblToplamIscilik, gbc_lblToplamIscilik);

        txtFieldToplamIscilik = new JTextField();
        GridBagConstraints gbc_txtFieldToplamIscilik = new GridBagConstraints();
        gbc_txtFieldToplamIscilik.insets = new Insets(0, 0, 0, 5);
        gbc_txtFieldToplamIscilik.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldToplamIscilik.gridx = 1;
        gbc_txtFieldToplamIscilik.gridy = 0;
        toplamPanel.add(txtFieldToplamIscilik, gbc_txtFieldToplamIscilik);
        txtFieldToplamIscilik.setColumns(10);

        JLabel lblToplamBoya = new JLabel("Toplam Boya Miktarı:");
        GridBagConstraints gbc_lblToplamBoya = new GridBagConstraints();
        gbc_lblToplamBoya.anchor = GridBagConstraints.EAST;
        gbc_lblToplamBoya.insets = new Insets(0, 0, 0, 5);
        gbc_lblToplamBoya.gridx = 3;
        gbc_lblToplamBoya.gridy = 0;
        toplamPanel.add(lblToplamBoya, gbc_lblToplamBoya);

        txtFieldToplamBoya = new JTextField();
        GridBagConstraints gbc_txtFieldToplamBoya = new GridBagConstraints();
        gbc_txtFieldToplamBoya.insets = new Insets(0, 0, 0, 5);
        gbc_txtFieldToplamBoya.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldToplamBoya.gridx = 4;
        gbc_txtFieldToplamBoya.gridy = 0;
        toplamPanel.add(txtFieldToplamBoya, gbc_txtFieldToplamBoya);
        txtFieldToplamBoya.setColumns(10);

        JLabel lblToplamTutar = new JLabel("Toplam Tutar:");
        GridBagConstraints gbc_lblToplamTutar = new GridBagConstraints();
        gbc_lblToplamTutar.anchor = GridBagConstraints.EAST;
        gbc_lblToplamTutar.insets = new Insets(0, 0, 0, 5);
        gbc_lblToplamTutar.gridx = 6;
        gbc_lblToplamTutar.gridy = 0;
        toplamPanel.add(lblToplamTutar, gbc_lblToplamTutar);

        txtFieldToplamTutar = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 7;
        gbc_textField.gridy = 0;
        toplamPanel.add(txtFieldToplamTutar, gbc_textField);
        txtFieldToplamTutar.setColumns(10);

        raporlaBtn = new JButton("Raporla");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 5;
        add(raporlaBtn, gbc_btnNewButton);

        baslangicDateSpinner.setEnabled(false);
        bitisDateSpinner.setEnabled(false);
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

    public JRadioButton getRdBtnIsTarihFilterEnabled() {
        return rdBtnIsTarihFilterEnabled;
    }

    public JSpinner getBaslangicDateSpinner() {
        return baslangicDateSpinner;
    }

    public JSpinner getBitisDateSpinner() {
        return bitisDateSpinner;
    }

    public JTextField getTxtFieldToplamIscilik() {
        return txtFieldToplamIscilik;
    }

    public JTextField getTxtFieldToplamBoya() {
        return txtFieldToplamBoya;
    }

    public JTextField getTxtFieldToplamTutar() {
        return txtFieldToplamTutar;
    }
}
