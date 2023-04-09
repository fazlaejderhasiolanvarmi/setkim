package com.setkim.ui;

import com.setkim.ekleme.EklemeController;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

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
        frame.setBounds(0, 0, 1200, 1000);
        frame.add(view);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initTable() {

        JTable table = view.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        Database.connect();
        List<Object> tableData = Database.showSetkimMain();
        Database.closeConnection();

        for (int i = 0; i < tableData.size(); i++) {
            model.addRow(new Vector<>((List<Object>) tableData.get(i)));
        }
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
