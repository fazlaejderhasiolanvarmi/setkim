package com.setkim.main;

import com.setkim.ekleme.EklemeController;
import com.setkim.raporlama.secenek.RaporlamaSecenekController;
import com.setkim.siparisdetay.SiparisDetayController;
import com.setkim.stokPanel.StokEkranController;
import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.SiparisBilgisi;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class MainController {
    private MainPanel view;
    private EklemeController eklemeController;
    private RaporlamaSecenekController raporlamaSecenekController;
    private StokEkranController stokEkranController;
    private JFrame frame;

    public MainController() {
        view = new MainPanel();

        DatabaseObjectList.fillListsFromDatabase();

        initListeners();
        initTable();

        hideColumns();

        eklemeController = new EklemeController();
        raporlamaSecenekController = new RaporlamaSecenekController();
        stokEkranController = new StokEkranController();

        frame = new JFrame();
        frame.setBounds(100, 200, 800, 600);
        frame.add(view);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DatabaseObjectList.saveMusteriList();
                DatabaseObjectList.saveSiparisList();
                DatabaseObjectList.saveStokKartiList();
                DatabaseObjectList.saveStokList();
                super.windowClosing(e);
            }
        });
    }

    public static void main(String[] args) {
        new MainController();
    }

    private void hideColumns() {
        JTable table = view.getTable();
        table.removeColumn(table.getColumnModel().getColumn(5)); // Siparis No gizlensin diye var
    }

    private void initTable() {

        JTable table = view.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<Object> tableData = DatabaseObjectList.getMainTableList();

        for (Object tableDatum : tableData) {
            model.addRow(new Vector<>((List<Object>) tableDatum));
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setDefaultEditor(Object.class, null);

        TableCellRenderer dateRenderer = new DefaultTableCellRenderer() {

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                if (value instanceof Date) {
                    value = f.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
            }
        };

        table.getColumnModel().getColumn(3).setCellRenderer(dateRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(dateRenderer);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = table.getSelectedRow();

                if (e.getClickCount() >= 2 && selectedRow != -1) {

                    int siparisNo = (int) table.getModel().getValueAt(selectedRow, 5);

                    SiparisBilgisi siparis = DatabaseObjectList.findSiparisWithSiparisNo(siparisNo);

                    if (siparis != null) {
                        SiparisDetayController siparisDetay = new SiparisDetayController(siparis);

                        JDialog siparisDetayFrame = new JDialog(frame, "Sipariş Detay", true);
                        siparisDetayFrame.setBounds(100, 200, 800, 600);
                        siparisDetayFrame.add(siparisDetay.getView());
                        siparisDetayFrame.setVisible(true);
                        siparisDetayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                }
            }
        });
    }

    private void initListeners() {
        view.getBtnEkleme().addActionListener(e -> showEklemePanel());
        view.getBtnRaporlama().addActionListener(e -> raporla());
        view.getBtnStok().addActionListener(e -> stokEkran());
    }

    private void stokEkran() {
        JFrame stokFrame = new JFrame();
        stokFrame.setBounds(100, 200, 800, 600);
        stokFrame.add(stokEkranController.getView());
        stokFrame.setVisible(true);
        stokFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
