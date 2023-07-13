package com.setkim.raporlama.secenek;

import javax.swing.*;
import java.awt.*;

public class RaporlamaSecenekPanel extends JPanel {
    JRadioButton rdbtnMusteri;
    JRadioButton rdbtnTarih;
    JButton btnRaporla;

    public RaporlamaSecenekPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Raporlama Seçenekleri");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(10, 5, 15, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);

        rdbtnMusteri = new JRadioButton("Müşteriye Göre Raporlama");
        GridBagConstraints gbc_rdbtnMusteri = new GridBagConstraints();
        gbc_rdbtnMusteri.insets = new Insets(0, 5, 5, 5);
        gbc_rdbtnMusteri.gridx = 0;
        gbc_rdbtnMusteri.gridy = 1;
        add(rdbtnMusteri, gbc_rdbtnMusteri);

        rdbtnTarih = new JRadioButton("Tarihe Göre Raporlama");
        GridBagConstraints gbc_rdbtnTarih = new GridBagConstraints();
        gbc_rdbtnTarih.insets = new Insets(0, 5, 5, 5);
        gbc_rdbtnTarih.gridx = 0;
        gbc_rdbtnTarih.gridy = 2;
        add(rdbtnTarih, gbc_rdbtnTarih);

        btnRaporla = new JButton("Raporla");

        GridBagConstraints gbc_btnRaporla = new GridBagConstraints();
        gbc_btnRaporla.gridx = 0;
        gbc_btnRaporla.gridy = 4;
        add(btnRaporla, gbc_btnRaporla);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdbtnMusteri);
        btnGroup.add(rdbtnTarih);

        rdbtnMusteri.setSelected(true);
    }

    public JRadioButton getRdbtnMusteri() {
        return rdbtnMusteri;
    }

    public JRadioButton getRdbtnTarih() {
        return rdbtnTarih;
    }

    public JButton getBtnRaporla() {
        return btnRaporla;
    }

}
