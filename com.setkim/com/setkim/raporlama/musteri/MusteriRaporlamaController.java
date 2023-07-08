package com.setkim.raporlama.musteri;

import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class MusteriRaporlamaController {

    private List<MusteriNoVeAdPair> musteriList;
    private MusteriRaporlamaPanel view;
   //inittable doldurulacak müsteriye göre


    public MusteriRaporlamaController() {
        view = new MusteriRaporlamaPanel();
        initComboBox();
        initListener();
    }

    private void initComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        musteriList = Database.getMusteriList();

        for (MusteriNoVeAdPair musteri : musteriList) {
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
                if (value instanceof MusteriNoVeAdPair)
                    setText(((MusteriNoVeAdPair) value).getMusteriAdi());

                return this;
            }
        });

    }

    private void initListener(){
        view.getRaporlaBtn().addActionListener(e -> {

            int musteriNo =  ((MusteriNoVeAdPair)view.getMusteriDropdown().getSelectedItem()).getMusteriNo();

            DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
            model.setRowCount(0);

            updateTable(musteriNo);

        });
    }

    public void updateTable(int musteriNo){

        JTable table = view.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<Object> bilgiler = Database.getBilgilerFromMusteri(musteriNo);

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
