package com.setkim.ui;

import com.setkim.ekleme.EklemeController;

import javax.swing.*;

public class MainController {

    //TODO: Buralar çok değişecek vaziyet alın
    private MainPanel view;

    private EklemeController eklemeController;

    public MainController() {
        view = new MainPanel();

        initListeners();
        initTable();

        eklemeController = new EklemeController();

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
        JFrame eklemeFrame = new JFrame();
        eklemeFrame.setBounds(100, 200, 800, 600);
        eklemeFrame.add(eklemeController.getView());
        eklemeFrame.setVisible(true);
        eklemeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainController();
    }
}
