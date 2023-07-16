package com.setkim.raporlama.tarih;

import com.setkim.siparisdetay.SiparisDetayController;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TarihRaporlamaController {
    private TarihRaporlamaPanel view;

    public TarihRaporlamaController() {

        view = new TarihRaporlamaPanel();

        initListeners();
        initTable();
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

                    JDialog siparisDetayFrame = new JDialog();
                    siparisDetayFrame.setTitle("Sipariş Detay");
                    siparisDetayFrame.setModal(true);
                    siparisDetayFrame.setBounds(100, 200, 800, 600);
                    siparisDetayFrame.add(siparisDetayController.getView());
                    siparisDetayFrame.setVisible(true);
                    siparisDetayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });

    }

    private void initListeners() {

        view.getBtnFiltrele().addActionListener(e -> {

            Calendar calendar = Calendar.getInstance();

            Date baslangicTarihi = (Date) view.getSpinnerBaslangicTarih().getValue();
            Date bitisTarihi = (Date) view.getSpinnerBitisTarih().getValue();

            calendar.setTime(baslangicTarihi);
            int baslangicGunu = calendar.get(Calendar.DAY_OF_MONTH);
            int baslangicAy = calendar.get(Calendar.MONTH) + 1;
            int baslangicYil = calendar.get(Calendar.YEAR);

            calendar.setTime(bitisTarihi);
            int bitisGunu = calendar.get(Calendar.DAY_OF_MONTH);
            int bitisAy = calendar.get(Calendar.MONTH) + 1;
            int bitisYil = calendar.get(Calendar.YEAR);

            String baslangicTarih = baslangicGunu + "/" + baslangicAy + "/" + baslangicYil;
            String bitisTarih = bitisGunu + "/" + bitisAy + "/" + bitisYil;

            List<Object> siparisler = new ArrayList<>();

            try {
                siparisler = Database.compareDates(new SimpleDateFormat("dd/MM/yyyy").parse(baslangicTarih), new SimpleDateFormat("dd/MM/yyyy").parse(bitisTarih));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            //Bunun yerine tabloya yazılacak
            if (!siparisler.isEmpty()) {

                DefaultTableModel dm = (DefaultTableModel) view.getTable().getModel();
                int rowCount = dm.getRowCount();

                for (int i = rowCount - 1; i >= 0; i--) {
                    dm.removeRow(i);
                }

                for (Object siparis : siparisler) {
                    List<Object> row = (List<Object>) siparis;

                    Object[] tableRow = new Object[5];

                    tableRow[0] = row.get(11); //Musteri Adi
                    tableRow[1] = row.get(0); //Boyanan Malzeme
                    tableRow[2] = row.get(10); //Tutar
                    tableRow[3] = row.get(12); //Alim Tarihi
                    tableRow[4] = row.get(13); //Teslim Tarihi

                    ((DefaultTableModel) view.getTable().getModel()).addRow(tableRow);

                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Veri bulunamadı!",
                        "Hata",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });
    }

    public TarihRaporlamaPanel getView() {
        return view;
    }
}
