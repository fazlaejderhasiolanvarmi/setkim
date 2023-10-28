package com.setkim.raporlama.tarih;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TarihRaporlamaPanel extends JPanel {
    private JPanel tablePanel;
    private JTable table;
    private JScrollPane scrollPane;
    private JSpinner spinnerBaslangicTarih;
    private JSpinner spinnerBitisTarih;
    private JButton btnFiltrele;

    private JTextField iscilikSuresiToplamTextField;
    private JTextField boyaMiktarıToplamTextField;
    private JTextField tutarToplamTextField;

    public TarihRaporlamaPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        SpinnerDateModel solTarihModel = new SpinnerDateModel();

        JLabel lblNewLabel = new JLabel("Başlangıç Tarihi:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);

        spinnerBaslangicTarih = new JSpinner(solTarihModel);
        JComponent solTarih = new JSpinner.DateEditor(spinnerBaslangicTarih, "dd/MM/yyyy");
        spinnerBaslangicTarih.setEditor(solTarih);
        GridBagConstraints gbc_spinnerSolTarih = new GridBagConstraints();
        gbc_spinnerSolTarih.insets = new Insets(5, 5, 5, 5);
        gbc_spinnerSolTarih.gridx = 1;
        gbc_spinnerSolTarih.gridy = 0;
        add(spinnerBaslangicTarih, gbc_spinnerSolTarih);

        SpinnerDateModel sagTarihModel = new SpinnerDateModel();

        JLabel lblNewLabel_1 = new JLabel("Bitiş Tarihi:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel_1.gridx = 3;
        gbc_lblNewLabel_1.gridy = 0;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        spinnerBitisTarih = new JSpinner(sagTarihModel);
        JComponent sagTarih = new JSpinner.DateEditor(spinnerBitisTarih, "dd/MM/yyyy");
        spinnerBitisTarih.setEditor(sagTarih);
        GridBagConstraints gbc_spinnerSagTarih = new GridBagConstraints();
        gbc_spinnerSagTarih.insets = new Insets(5, 5, 5, 5);
        gbc_spinnerSagTarih.gridx = 4;
        gbc_spinnerSagTarih.gridy = 0;
        add(spinnerBitisTarih, gbc_spinnerSagTarih);

        btnFiltrele = new JButton("Filtrele");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.insets = new Insets(5, 5, 5, 5);
        gbc_btnNewButton.gridx = 6;
        gbc_btnNewButton.gridy = 0;
        add(btnFiltrele, gbc_btnNewButton);

        tablePanel = new JPanel();
        GridBagConstraints gbc_tablePanel = new GridBagConstraints();
        gbc_tablePanel.gridwidth = 7;
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

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Müşteri Adı");
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
        table.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(table);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        tablePanel.add(scrollPane, gbc_scrollPane);

        JPanel toplamPanel = new JPanel();
        GridBagConstraints gbc_toplamPanel = new GridBagConstraints();
        gbc_toplamPanel.insets = new Insets(0, 0, 5, 5);
        gbc_toplamPanel.fill = GridBagConstraints.BOTH;
        gbc_toplamPanel.gridx = 2;
        gbc_toplamPanel.gridy = 5;
        add(toplamPanel, gbc_toplamPanel);
        GridBagLayout gbl_toplamPanel = new GridBagLayout();
        gbl_toplamPanel.columnWidths = new int[]{62, 46, 46, 46, 0};
        gbl_toplamPanel.rowHeights = new int[]{14, 0, 0, 0};
        gbl_toplamPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_toplamPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        toplamPanel.setLayout(gbl_toplamPanel);

        iscilikSuresiToplamTextField = new JTextField();
        GridBagConstraints gbc_iscilikSuresiToplamTextField = new GridBagConstraints();
        gbc_iscilikSuresiToplamTextField.insets = new Insets(0, 0, 5, 5);
        gbc_iscilikSuresiToplamTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_iscilikSuresiToplamTextField.gridx = 2;
        gbc_iscilikSuresiToplamTextField.gridy = 0;
        toplamPanel.add(iscilikSuresiToplamTextField, gbc_iscilikSuresiToplamTextField);
        iscilikSuresiToplamTextField.setColumns(10);

        boyaMiktarıToplamTextField = new JTextField();
        GridBagConstraints gbc_boyaMiktarıToplamTextField = new GridBagConstraints();
        gbc_boyaMiktarıToplamTextField.insets = new Insets(0, 0, 5, 5);
        gbc_boyaMiktarıToplamTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_boyaMiktarıToplamTextField.gridx = 2;
        gbc_boyaMiktarıToplamTextField.gridy = 1;
        toplamPanel.add(boyaMiktarıToplamTextField, gbc_boyaMiktarıToplamTextField);
        boyaMiktarıToplamTextField.setColumns(10);

        JLabel tutarToplamLabel = new JLabel("Tutar");
        GridBagConstraints gbc_tutarToplamLabel = new GridBagConstraints();
        gbc_tutarToplamLabel.anchor = GridBagConstraints.NORTHWEST;
        gbc_tutarToplamLabel.insets = new Insets(0, 0, 0, 5);
        gbc_tutarToplamLabel.gridx = 0;
        gbc_tutarToplamLabel.gridy = 2;
        toplamPanel.add(tutarToplamLabel, gbc_tutarToplamLabel);

        JLabel boyaMiktariToplamLabel = new JLabel("Boya Miktarı");
        GridBagConstraints gbc_boyaMiktariToplamLabel = new GridBagConstraints();
        gbc_boyaMiktariToplamLabel.anchor = GridBagConstraints.NORTHWEST;
        gbc_boyaMiktariToplamLabel.insets = new Insets(0, 0, 5, 5);
        gbc_boyaMiktariToplamLabel.gridx = 0;
        gbc_boyaMiktariToplamLabel.gridy = 1;
        toplamPanel.add(boyaMiktariToplamLabel, gbc_boyaMiktariToplamLabel);

        JLabel iscilikSuresiToplamLabel = new JLabel("İşçilik Süresi");
        GridBagConstraints gbc_iscilikSuresiToplamLabel = new GridBagConstraints();
        gbc_iscilikSuresiToplamLabel.insets = new Insets(0, 0, 5, 5);
        gbc_iscilikSuresiToplamLabel.anchor = GridBagConstraints.NORTHWEST;
        gbc_iscilikSuresiToplamLabel.gridx = 0;
        gbc_iscilikSuresiToplamLabel.gridy = 0;
        toplamPanel.add(iscilikSuresiToplamLabel, gbc_iscilikSuresiToplamLabel);

        tutarToplamTextField = new JTextField();
        GridBagConstraints gbc_tutarToplamTextField = new GridBagConstraints();
        gbc_tutarToplamTextField.insets = new Insets(0, 0, 0, 5);
        gbc_tutarToplamTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_tutarToplamTextField.gridx = 2;
        gbc_tutarToplamTextField.gridy = 2;
        toplamPanel.add(tutarToplamTextField, gbc_tutarToplamTextField);
        tutarToplamTextField.setColumns(10);
    }

    public JPanel getTablePanel() {
        return tablePanel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JSpinner getSpinnerBaslangicTarih() {
        return spinnerBaslangicTarih;
    }

    public JSpinner getSpinnerBitisTarih() {
        return spinnerBitisTarih;
    }

    public JButton getBtnFiltrele() {
        return btnFiltrele;
    }

    public JTable getTable() {
        return table;
    }
}
