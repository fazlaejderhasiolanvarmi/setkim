package com.setkim.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainController {

    //TODO: Buralar çok değişecek vaziyet alın
    private MainPanel view;

    public MainController(){
        view = new MainPanel();
        initListeners();
        initTable();
        JFrame frame = new JFrame();
        frame.setBounds(100, 200, 800, 600);
        frame.add(view);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initTable() {
        JTable table = view.getTable();
    }

    private void initListeners() {
        view.getBtnEkleme().addActionListener(e -> showEklemePanel());
        view.getBtnRaporlama().addActionListener(e -> raporla());
    }

    private void raporla() {
    }

    private void showEklemePanel() {
    }
}
