package com.setkim.main;

import com.setkim.ekleme.EklemeController;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        frame.setBounds(100, 200, 800, 600);
        frame.add(view);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainController();
    }

    private void initTable() {

        JTable table = view.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<Object> tableData = Database.showSetkimMain();


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

        eklemeFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                DefaultTableModel dm = (DefaultTableModel) view.getTable().getModel();
                int rowCount = dm.getRowCount();

                for (int i = rowCount - 1; i >= 0; i--) {
                    dm.removeRow(i);
                }

                initTable();

                super.windowClosed(e);
            }
        });
    }
}
