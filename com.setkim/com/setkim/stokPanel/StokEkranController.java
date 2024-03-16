package com.setkim.stokPanel;

import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.StokKarti;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class StokEkranController {

    private StokEkranPanel view;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            StokKarti selectedStokKarti = (StokKarti) view.getComboBox().getSelectedItem();

            DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
            model.setRowCount(0);

            List<Object> newList = DatabaseObjectList.getFilteredStokList(selectedStokKarti);

            for (Object o : newList) {
                model.addRow(new Vector<>((List<Object>) o));
            }

            model.fireTableStructureChanged();

        }
    };

    public StokEkranController() {


        view = new StokEkranPanel();
        refreshComboBox();

        initTable();

    }

    private void initTable() {

        view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        view.getTable().setDefaultEditor(Object.class, null);

        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();

        List<Object> stokList = DatabaseObjectList.getStokTableList();

        for (Object o : stokList) {
            model.addRow(new Vector<>((List<Object>) o));
        }

        model.fireTableStructureChanged();

        view.getComboBox().addActionListener(actionListener);

    }

    public void refreshComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        List<StokKarti> stokKartiList = DatabaseObjectList.getStokKartiList();

        for (StokKarti stokKarti : stokKartiList) {
            model.addElement(stokKarti);
        }

        view.getComboBox().setModel(model);
        view.getComboBox().setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                if (value instanceof StokKarti)
                    setText(((StokKarti) value).getStokKartiAdi());

                return this;
            }
        });

    }

    public StokEkranPanel getView() {
        return view;
    }
}
