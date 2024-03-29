package com.setkim.main;

import com.setkim.ekleme.EklemeController;
import com.setkim.raporlama.secenek.RaporlamaSecenekController;
import com.setkim.siparisdetay.SiparisDetayController;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

public class MainController {
    private MainPanel view;
    private EklemeController eklemeController;
    private RaporlamaSecenekController raporlamaSecenekController;
    private JFrame frame;

    public MainController() {
        view = new MainPanel();

        initListeners();
        initTable();

        eklemeController = new EklemeController();
        raporlamaSecenekController = new RaporlamaSecenekController();

        frame = new JFrame();
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

        List<Object> tableData = Database.showMainTable();

        for (int i = 0; i < tableData.size(); i++) {
            model.addRow(new Vector<>((List<Object>) tableData.get(i)));
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setDefaultEditor(Object.class, null);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = table.getSelectedRow();

                if (e.getClickCount() == 2 && selectedRow != -1) {

                    List<Object> musteriBilgisi = Database.getMusteriFromMusteriName((String) table.getModel().getValueAt(selectedRow, 0));

                    List<Object> siparisBilgisi = Database.getSiparisBilgisiFromTabloBilgisi((String) table.getModel().getValueAt(selectedRow, 1),
                            (double) table.getModel().getValueAt(selectedRow, 2),
                            (String) table.getModel().getValueAt(selectedRow, 3),
                            (String) table.getModel().getValueAt(selectedRow, 4)
                    );

                    SiparisDetayController siparisDetayController = new SiparisDetayController(musteriBilgisi, siparisBilgisi);

                    JDialog siparisDetayFrame = new JDialog(frame, "Sipariş Detay", true);
                    siparisDetayFrame.setBounds(100, 200, 800, 600);
                    siparisDetayFrame.add(siparisDetayController.getView());
                    siparisDetayFrame.setVisible(true);
                    siparisDetayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
    }

    private void initListeners() {
        view.getBtnEkleme().addActionListener(e -> showEklemePanel());
        view.getBtnRaporlama().addActionListener(e -> raporla());
    }

    private void raporla() {

        JDialog raporlamaFrame = new JDialog(frame, "Raporlama", true);
        raporlamaFrame.setBounds(100, 200, 300, 200);
        raporlamaFrame.add(raporlamaSecenekController.getView());
        raporlamaFrame.setVisible(true);
        raporlamaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
