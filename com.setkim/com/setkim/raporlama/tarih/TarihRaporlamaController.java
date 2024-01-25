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
    private final TarihRaporlamaPanel view;

    public TarihRaporlamaController() {

        view = new TarihRaporlamaPanel();

        initTable();
        initListeners();
    }

    // Burası okunaklı hale gelebilir belki?
    private void initTable() {

        JTable table = view.getTable();

        table.removeColumn(table.getColumnModel().getColumn(17)); // Sipariş No Gizlemecilik

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

        view.getBtnFiltrele().addActionListener(e -> {

            Date baslangicTarihi = (Date) view.getSpinnerBaslangicTarih().getValue();
            Date bitisTarihi = (Date) view.getSpinnerBitisTarih().getValue();

            List<SiparisBilgisi> filteredSiparisList = DatabaseObjectList.findSiparisBetweenDates(baslangicTarihi, bitisTarihi);

            if (!filteredSiparisList.isEmpty()) {

                removeAllRows();

                for (SiparisBilgisi siparis : filteredSiparisList) {

                    Object[] siparisBilgisi = siparisToObjectArray(siparis);

                    ((DefaultTableModel) view.getTable().getModel()).addRow(siparisBilgisi);

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

    private Object[] siparisToObjectArray(SiparisBilgisi siparis) {

        Object[] objectArray = new Object[18];

        objectArray[0] = siparis.getMusteri().getMusteriAdi();
        objectArray[1] = siparis.getBoyananMalzeme();
        objectArray[2] = siparis.getMalzemeCinsi();
        objectArray[3] = siparis.getYuzeyIslem();
        objectArray[4] = siparis.getRenkKodu();
        objectArray[5] = siparis.getBoyaMiktari();
        objectArray[6] = siparis.getIscilikSuresi();
        objectArray[7] = siparis.getBoyananMalzemeMiktari();
        objectArray[8] = siparis.getBirim();
        objectArray[9] = siparis.getHat();
        objectArray[10] = siparis.getBoyamaFiyati();
        objectArray[11] = siparis.getTutar();
        objectArray[12] = siparis.getAlimTarihi();
        objectArray[13] = siparis.getTeslimTarihi();
        objectArray[14] = siparis.getIrsaliyeNo();
        objectArray[15] = siparis.getFaturaNo();
        objectArray[16] = siparis.getVade();
        objectArray[17] = siparis.getSiparisNo();

        return objectArray;
    }

    private void removeAllRows() {

        DefaultTableModel dm = (DefaultTableModel) view.getTable().getModel();
        int rowCount = dm.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }

    }

    public TarihRaporlamaPanel getView() {
        return view;
    }
}
