package com.setkim.raporlama.musteri;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class MusteriRaporlamaPanel extends JPanel {
    private JTable table;
    private JComboBox<MusteriNoVeAdPair> musteriDropdown;
    private JButton raporlaBtn;

    private JTextField iscilikSuresiToplamTextField;
    private JTextField boyaMiktarıToplamTextField;
    private JTextField tutarToplamTextField;
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
        gbc_btnNewButton.gridy = 8;
        add(raporlaBtn, gbc_btnNewButton);

        JPanel zamanFiltresiPanel = new JPanel();
        GridBagConstraints gbc_zamanFiltresiPanel = new GridBagConstraints();
        gbc_zamanFiltresiPanel.gridwidth = 4;
        gbc_zamanFiltresiPanel.insets = new Insets(0, 0, 5, 5);
        gbc_zamanFiltresiPanel.fill = GridBagConstraints.VERTICAL;
        gbc_zamanFiltresiPanel.gridx = 0;
        gbc_zamanFiltresiPanel.gridy = 2;
        add(zamanFiltresiPanel, gbc_zamanFiltresiPanel);
        GridBagLayout gbl_zamanFiltresiPanel = new GridBagLayout();
        gbl_zamanFiltresiPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_zamanFiltresiPanel.rowHeights = new int[]{0, 0};
        gbl_zamanFiltresiPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_zamanFiltresiPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        zamanFiltresiPanel.setLayout(gbl_zamanFiltresiPanel);

        JLabel lblNewLabel = new JLabel("Başlangıç Tarihi");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel.gridx = 5;
        gbc_lblNewLabel.gridy = 0;
        zamanFiltresiPanel.add(lblNewLabel, gbc_lblNewLabel);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(1698440459000L), null, null, Calendar.DAY_OF_MONTH));
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.insets = new Insets(0, 0, 0, 5);
        gbc_spinner.gridx = 6;
        gbc_spinner.gridy = 0;
        zamanFiltresiPanel.add(spinner, gbc_spinner);

        JLabel lblNewLabel_1 = new JLabel("Bitiş Tarihi");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_1.gridx = 8;
        gbc_lblNewLabel_1.gridy = 0;
        zamanFiltresiPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        JSpinner spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerDateModel(new Date(1698440400000L), null, null, Calendar.DAY_OF_MONTH));
        GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
        gbc_spinner_1.insets = new Insets(0, 0, 0, 5);
        gbc_spinner_1.gridx = 9;
        gbc_spinner_1.gridy = 0;
        zamanFiltresiPanel.add(spinner_1, gbc_spinner_1);

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
