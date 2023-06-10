package com.setkim.raporlama.secenek;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RaporlamaSecenekPanel extends JPanel{
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

        JRadioButton rdbtnMusteri = new JRadioButton("Müşteriye Göre Raporlama");
        GridBagConstraints gbc_rdbtnMusteri = new GridBagConstraints();
        gbc_rdbtnMusteri.insets = new Insets(0, 5, 5, 5);
        gbc_rdbtnMusteri.gridx = 0;
        gbc_rdbtnMusteri.gridy = 1;
        add(rdbtnMusteri, gbc_rdbtnMusteri);

        JRadioButton rdbtnTarih = new JRadioButton("Tarihe Göre Raporlama");
        GridBagConstraints gbc_rdbtnTarih = new GridBagConstraints();
        gbc_rdbtnTarih.insets = new Insets(0, 5, 5, 5);
        gbc_rdbtnTarih.gridx = 0;
        gbc_rdbtnTarih.gridy = 2;
        add(rdbtnTarih, gbc_rdbtnTarih);

        JButton btnRaporla = new JButton("Raporla");
        btnRaporla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        GridBagConstraints gbc_btnRaporla = new GridBagConstraints();
        gbc_btnRaporla.gridx = 0;
        gbc_btnRaporla.gridy = 4;
        add(btnRaporla, gbc_btnRaporla);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdbtnMusteri);
        btnGroup.add(rdbtnTarih);
    }

}
