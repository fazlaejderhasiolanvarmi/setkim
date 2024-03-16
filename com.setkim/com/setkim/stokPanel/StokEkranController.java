package com.setkim.stokPanel;

import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.Stok;
import com.setkim.util.objects.StokKarti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class StokEkranController {

    private StokEkranPanel view;

    public StokEkranController(){


        view = new StokEkranPanel();
        refreshComboBox();
        DatabaseObjectList.getStokKartiList();

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

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selection = (String) view.getComboBox().getSelectedItem();


        }
    };


    public StokEkranPanel getView() {
        return view;
    }
}
