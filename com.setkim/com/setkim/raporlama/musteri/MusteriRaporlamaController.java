package com.setkim.raporlama.musteri;

import com.setkim.siparisdetay.SiparisDetayController;
import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.SiparisBilgisi;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class MusteriRaporlamaController {

    private MusteriRaporlamaPanel view;

    public MusteriRaporlamaController() {
        view = new MusteriRaporlamaPanel();

        refreshComboBox();
        initTable();
        initListener();

    }

    private void initTable() {

        JTable table = view.getTable();

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

        // Tek tek column almak yerine Date.class mı olsa bi bakınılsın
        table.getColumnModel().getColumn(11).setCellRenderer(dateRenderer);
        table.getColumnModel().getColumn(12).setCellRenderer(dateRenderer);

        table.removeColumn(table.getColumnModel().getColumn(16));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (e.getClickCount() >= 2) {

                    int selectedRow = table.getSelectedRow();

                    if (selectedRow != -1) {

                        int siparisNo = (int) table.getModel().getValueAt(selectedRow, 16);

                        SiparisBilgisi siparis = DatabaseObjectList.findSiparisWithSiparisNo(siparisNo);

                        if (siparis != null) {

                            SiparisDetayController siparisDetayController = new SiparisDetayController(siparis);

                            JDialog siparisDetayFrame = new JDialog((JFrame) SwingUtilities.getWindowAncestor(view), "Sipariş Detay", true);
                            siparisDetayFrame.setBounds(100, 200, 800, 600);
                            siparisDetayFrame.add(siparisDetayController.getView());
                            siparisDetayFrame.setVisible(true);
                            siparisDetayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        }
                    }
                }
            }
        });
    }

    public void refreshComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        List<Musteri> musteriList = DatabaseObjectList.getMusteriList();

        for (Musteri musteri : musteriList) {
            model.addElement(musteri);
        }

        view.getMusteriDropdown().setModel(model);
        view.getMusteriDropdown().setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                if (value instanceof Musteri)
                    setText(((Musteri) value).getMusteriAdi());

                return this;
            }
        });

    }

    private void initListener() {
        view.getRaporlaBtn().addActionListener(e -> {

            Musteri musteri = ((Musteri) view.getMusteriDropdown().getSelectedItem());

            DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
            model.setRowCount(0);

            updateTable(musteri);

        });
    }

    public void updateTable(Musteri musteri) {

        JTable table = view.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<Object> bilgiler = DatabaseObjectList.getSiparisListOfMusteri(musteri);

        for (Object o : bilgiler) {
            model.addRow(new Vector<>((List<Object>) o));
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setDefaultEditor(Object.class, null);
    }

    public MusteriRaporlamaPanel getView() {
        return view;
    }
}
