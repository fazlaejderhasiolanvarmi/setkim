package com.setkim.raporlama.musteri;

import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.Musteri;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class MusteriRaporlamaController {

    private List<Musteri> musteriList;
    private MusteriRaporlamaPanel view;
    //inittable doldurulacak müsteriye göre


    public MusteriRaporlamaController() {
        view = new MusteriRaporlamaPanel();
        refreshComboBox();
        initListener();

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

        table.getColumnModel().getColumn(11).setCellRenderer(dateRenderer);
        table.getColumnModel().getColumn(12).setCellRenderer(dateRenderer);

    }

    public void refreshComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        musteriList = DatabaseObjectList.getMusteriList();

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

        for (int i = 0; i < bilgiler.size(); i++) {
            model.addRow(new Vector<>((List<Object>) bilgiler.get(i)));
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setDefaultEditor(Object.class, null);
    }

    public MusteriRaporlamaPanel getView() {
        return view;
    }
}
