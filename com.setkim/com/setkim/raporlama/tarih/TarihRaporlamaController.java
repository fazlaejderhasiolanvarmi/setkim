package com.setkim.raporlama.tarih;

import com.setkim.siparisdetay.SiparisDetayController;
import com.setkim.util.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TarihRaporlamaController {
    private TarihRaporlamaPanel view;

    public TarihRaporlamaController() {

        view = new TarihRaporlamaPanel();

        initListeners();
        initTable();
        refreshToplamFields();
    }

    private void initTable() {

        JTable table = view.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<Object> tableData = Database.getTarihFiltrelemeTable();

        for (Object siparis : tableData) {
            Object[] tableRow = new Object[17];

            List<Object> row = (List<Object>) siparis;

            tableRow[0] = row.get(11);
            tableRow[1] = row.get(0);
            tableRow[2] = row.get(1);
            tableRow[3] = row.get(2);
            tableRow[4] = row.get(3);
            tableRow[5] = row.get(4);
            tableRow[6] = row.get(5);
            tableRow[7] = row.get(6);
            tableRow[8] = row.get(7);
            tableRow[9] = row.get(8);
            tableRow[10] = row.get(9);
            tableRow[11] = row.get(10);
            tableRow[12] = row.get(12);
            tableRow[13] = row.get(13);
            tableRow[14] = row.get(14);
            tableRow[15] = row.get(15);
            tableRow[16] = row.get(16);

            ((DefaultTableModel) view.getTable().getModel()).addRow(tableRow);
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
                            (double) table.getModel().getValueAt(selectedRow, 11),
                            (String) table.getModel().getValueAt(selectedRow, 12),
                            (String) table.getModel().getValueAt(selectedRow, 13)
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

    private void refreshToplamFields(){
        JTable table = view.getTable();

        int rowCount = table.getModel().getRowCount();

        double toplamIsclikSuresi = 0;
        double toplamBoyaMiktari = 0;
        double toplamTutar = 0;

        for(int i = 0; i < rowCount; i++){
           toplamIsclikSuresi += (double)table.getValueAt(i,6);
           toplamBoyaMiktari += (double)table.getValueAt(i,5);
           toplamTutar += (double)table.getValueAt(i,11);

        }
        view.getBoyaMiktarıToplamTextField().setText(String.valueOf(toplamBoyaMiktari));
        view.getIscilikSuresiToplamTextField().setText(String.valueOf(toplamIsclikSuresi));
        view.getTutarToplamTextField().setText(String.valueOf(toplamTutar));


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

            if (!siparisler.isEmpty()) {

                DefaultTableModel dm = (DefaultTableModel) view.getTable().getModel();
                int rowCount = dm.getRowCount();

                for (int i = rowCount - 1; i >= 0; i--) {
                    dm.removeRow(i);
                }

                for (Object siparis : siparisler) {
                    List<Object> row = (List<Object>) siparis;

                    Object[] tableRow = new Object[17];

                    tableRow[0] = row.get(11);
                    tableRow[1] = row.get(0);
                    tableRow[2] = row.get(1);
                    tableRow[3] = row.get(2);
                    tableRow[4] = row.get(3);
                    tableRow[5] = row.get(4);
                    tableRow[6] = row.get(5);
                    tableRow[7] = row.get(6);
                    tableRow[8] = row.get(7);
                    tableRow[9] = row.get(8);
                    tableRow[10] = row.get(9);
                    tableRow[11] = row.get(10);
                    tableRow[12] = row.get(12);
                    tableRow[13] = row.get(13);
                    tableRow[14] = row.get(14);
                    tableRow[15] = row.get(15);
                    tableRow[16] = row.get(16);

                    ((DefaultTableModel) view.getTable().getModel()).addRow(tableRow);

                    refreshToplamFields();

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
