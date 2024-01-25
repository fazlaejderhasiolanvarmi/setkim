package com.setkim.raporlama.tarih;

import com.setkim.siparisdetay.SiparisDetayController;
import com.setkim.util.DatabaseObjectList;
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

public class TarihRaporlamaController {
    private TarihRaporlamaPanel view;

    public TarihRaporlamaController() {

        view = new TarihRaporlamaPanel();

        initTable();
        initListeners();
    }

    // Burası okunaklı hale gelebilir belki?
    private void initTable() {

        JTable table = view.getTable();

        table.removeColumn(table.getColumnModel().getColumn(17)); // Sipariş No Gizlemecilik

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<Object> tableData = DatabaseObjectList.getTarihFiltrelemeTable();

        for (Object siparis : tableData) {
            Object[] siparisArray = ((List<Object>) siparis).toArray();
            ((DefaultTableModel) view.getTable().getModel()).addRow(siparisArray);
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

        // Burası acaba Date.class mı olsa?
        table.getColumnModel().getColumn(12).setCellRenderer(dateRenderer);
        table.getColumnModel().getColumn(13).setCellRenderer(dateRenderer);

        // Teknik olarak bu da bi listener
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = table.getSelectedRow();

                if (e.getClickCount() >= 2 && selectedRow != -1) {

                    int siparisNo = (int) table.getModel().getValueAt(selectedRow, 17);

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
        });

    }

    private void initListeners() {

        // OOOOOOOOFFFFFFFF

        view.getBtnFiltrele().addActionListener(e -> {

//            Calendar calendar = Calendar.getInstance();
//
//            Date baslangicTarihi = (Date) view.getSpinnerBaslangicTarih().getValue();
//            Date bitisTarihi = (Date) view.getSpinnerBitisTarih().getValue();
//
//            calendar.setTime(baslangicTarihi);
//            int baslangicGunu = calendar.get(Calendar.DAY_OF_MONTH);
//            int baslangicAy = calendar.get(Calendar.MONTH) + 1;
//            int baslangicYil = calendar.get(Calendar.YEAR);
//
//            calendar.setTime(bitisTarihi);
//            int bitisGunu = calendar.get(Calendar.DAY_OF_MONTH);
//            int bitisAy = calendar.get(Calendar.MONTH) + 1;
//            int bitisYil = calendar.get(Calendar.YEAR);
//
//            String baslangicTarih = baslangicGunu + "/" + baslangicAy + "/" + baslangicYil;
//            String bitisTarih = bitisGunu + "/" + bitisAy + "/" + bitisYil;
//
//            List<Object> siparisler = new ArrayList<>();
//
//            try {
//                siparisler = DatabaseController.compareDates(new SimpleDateFormat("dd/MM/yyyy").parse(baslangicTarih), new SimpleDateFormat("dd/MM/yyyy").parse(bitisTarih));
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            }
//
//            if (!siparisler.isEmpty()) {
//
//                DefaultTableModel dm = (DefaultTableModel) view.getTable().getModel();
//                int rowCount = dm.getRowCount();
//
//                for (int i = rowCount - 1; i >= 0; i--) {
//                    dm.removeRow(i);
//                }
//
//                for (Object siparis : siparisler) {
//                    List<Object> row = (List<Object>) siparis;
//
//                    Object[] tableRow = new Object[17];
//
//                    tableRow[0] = row.get(11);
//                    tableRow[1] = row.get(0);
//                    tableRow[2] = row.get(1);
//                    tableRow[3] = row.get(2);
//                    tableRow[4] = row.get(3);
//                    tableRow[5] = row.get(4);
//                    tableRow[6] = row.get(5);
//                    tableRow[7] = row.get(6);
//                    tableRow[8] = row.get(7);
//                    tableRow[9] = row.get(8);
//                    tableRow[10] = row.get(9);
//                    tableRow[11] = row.get(10);
//                    tableRow[12] = row.get(12);
//                    tableRow[13] = row.get(13);
//                    tableRow[14] = row.get(14);
//                    tableRow[15] = row.get(15);
//                    tableRow[16] = row.get(16);
//
//                    ((DefaultTableModel) view.getTable().getModel()).addRow(tableRow);
//
//                }
//            } else {
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Veri bulunamadı!",
//                        "Hata",
//                        JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        });
        });
    }

    public TarihRaporlamaPanel getView() {
        return view;
    }
}
