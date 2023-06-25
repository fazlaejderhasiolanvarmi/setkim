package com.setkim.raporlama.musteri;

import com.setkim.siparisdetay.SiparisDetayController;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class MusteriRaporlamaController extends MusteriRaporlamaPanel {

    private List<MusteriNoVeAdPair> musteriList;
    private MusteriRaporlamaPanel view;
    private JFrame frame;
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
            List<Object> bilgiler = Database.getBilgilerFromMusteri(musteriNo);
          //  initTable();

        });
    }


    public MusteriRaporlamaPanel getView() {
        return view;
    }
}
