package com.setkim.raporlama.export;

import com.setkim.util.DatabaseObjectList;
import com.setkim.util.objects.SiparisBilgisi;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TableExportController {

    private static FileFilter filter = new FileNameExtensionFilter("Excel (.xlsx)", "xlsx");
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void siparisiDisaAktar(List<Integer> siparisListesi) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        fileChooser.setFileFilter(filter);

        File file = new File(System.getProperty("user.home") + "/Desktop");

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            file = fileChooser.getSelectedFile();

        }

        try (Workbook workbook = new SXSSFWorkbook()) {

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER);

            Font font = ((SXSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);

            String musteriIsmi = "";

            try {
                musteriIsmi = DatabaseObjectList.findSiparisWithSiparisNo(siparisListesi.get(0)).getMusteri().getMusteriAdi();
            } catch (Exception e) {

                // liste boş müşteri yok
                return;
            }

            Sheet sheet = workbook.createSheet(musteriIsmi);

            createHeader(sheet, headerStyle);

            for (int i = 0; i < siparisListesi.size(); i++) {

                Row row = sheet.createRow(i + 1);

                SiparisBilgisi siparisBilgisi = DatabaseObjectList.findSiparisWithSiparisNo(siparisListesi.get(i));

                if (siparisBilgisi != null) {
                    createRowFromSiparis(row, siparisBilgisi);
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath() + ".xlsx")) {
                workbook.write(outputStream);
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Veri başarıyla dışarı aktarıldı",
                    "Dışa Aktarma",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tarihRaporlamaDisaAktar(String sheetName, List<Integer> siparisListesi) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        fileChooser.setFileFilter(filter);

        File file = new File(System.getProperty("user.home") + "/Desktop");

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            file = fileChooser.getSelectedFile();

        }

        try (Workbook workbook = new SXSSFWorkbook()) {

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER);

            Font font = ((SXSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);

            Sheet sheet = workbook.createSheet(sheetName);

            createTarihRaporlamaHeader(sheet, headerStyle);

            for (int i = 0; i < siparisListesi.size(); i++) {

                Row row = sheet.createRow(i + 1);

                SiparisBilgisi siparisBilgisi = DatabaseObjectList.findSiparisWithSiparisNo(siparisListesi.get(i));

                if (siparisBilgisi != null) {
                    createTarihRaporlamaRowFromSiparis(row, siparisBilgisi);
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath() + ".xlsx")) {
                workbook.write(outputStream);
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Veri başarıyla dışarı aktarıldı",
                    "Dışa Aktarma",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createTarihRaporlamaHeader(Sheet sheet, CellStyle headerStyle) {
        Row header = sheet.createRow(0);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Müşteri Adı");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(0, getWidth("Müşteri Adı"));

        headerCell = header.createCell(1);
        headerCell.setCellValue("Boyanan Malzeme");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(0, getWidth("Boyanan Malzeme"));

        headerCell = header.createCell(2);
        headerCell.setCellValue("Malzeme Cinsi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(1, getWidth("Malzeme Cinsi"));

        headerCell = header.createCell(3);
        headerCell.setCellValue("Yüzey İşlem");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(2, getWidth("Yüzey İşlem"));

        headerCell = header.createCell(4);
        headerCell.setCellValue("Renk Kodu");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(3, getWidth("Renk Kodu"));

        headerCell = header.createCell(5);
        headerCell.setCellValue("Boya Miktarı");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(4, getWidth("Boya Miktarı"));

        headerCell = header.createCell(6);
        headerCell.setCellValue("İşçilik Süresi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(5, getWidth("İşçilik Süresi"));

        headerCell = header.createCell(7);
        headerCell.setCellValue("Boyanan Malzeme Miktarı");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(6, getWidth("Boyanan Malzeme Miktarı"));

        headerCell = header.createCell(8);
        headerCell.setCellValue("Birim");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(7, getWidth("Birim"));

        headerCell = header.createCell(9);
        headerCell.setCellValue("Hat");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(8, getWidth("Hat"));

        headerCell = header.createCell(10);
        headerCell.setCellValue("Boyama Fiyatı");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(9, getWidth("Boyama Fiyatı"));

        headerCell = header.createCell(11);
        headerCell.setCellValue("Tutar");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(10, getWidth("Tutar"));

        headerCell = header.createCell(12);
        headerCell.setCellValue("Alım Tarihi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(11, getWidth("Alım Tarihi"));

        headerCell = header.createCell(13);
        headerCell.setCellValue("Teslim Tarihi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(12, getWidth("Teslim Tarihi"));

        headerCell = header.createCell(14);
        headerCell.setCellValue("İrsaliye No");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(13, getWidth("İrsaliye No"));

        headerCell = header.createCell(15);
        headerCell.setCellValue("Fatura No");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(14, getWidth("Fatura No"));

        headerCell = header.createCell(16);
        headerCell.setCellValue("Vade");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(15, getWidth("Vade"));
    }

    private static void createHeader(Sheet sheet, CellStyle headerStyle) {

        Row header = sheet.createRow(0);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Boyanan Malzeme");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(0, getWidth("Boyanan Malzeme"));

        headerCell = header.createCell(1);
        headerCell.setCellValue("Malzeme Cinsi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(1, getWidth("Malzeme Cinsi"));

        headerCell = header.createCell(2);
        headerCell.setCellValue("Yüzey İşlem");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(2, getWidth("Yüzey İşlem"));

        headerCell = header.createCell(3);
        headerCell.setCellValue("Renk Kodu");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(3, getWidth("Renk Kodu"));

        headerCell = header.createCell(4);
        headerCell.setCellValue("Boya Miktarı");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(4, getWidth("Boya Miktarı"));

        headerCell = header.createCell(5);
        headerCell.setCellValue("İşçilik Süresi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(5, getWidth("İşçilik Süresi"));

        headerCell = header.createCell(6);
        headerCell.setCellValue("Boyanan Malzeme Miktarı");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(6, getWidth("Boyanan Malzeme Miktarı"));

        headerCell = header.createCell(7);
        headerCell.setCellValue("Birim");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(7, getWidth("Birim"));

        headerCell = header.createCell(8);
        headerCell.setCellValue("Hat");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(8, getWidth("Hat"));

        headerCell = header.createCell(9);
        headerCell.setCellValue("Boyama Fiyatı");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(9, getWidth("Boyama Fiyatı"));

        headerCell = header.createCell(10);
        headerCell.setCellValue("Tutar");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(10, getWidth("Tutar"));

        headerCell = header.createCell(11);
        headerCell.setCellValue("Alım Tarihi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(11, getWidth("Alım Tarihi"));

        headerCell = header.createCell(12);
        headerCell.setCellValue("Teslim Tarihi");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(12, getWidth("Teslim Tarihi"));

        headerCell = header.createCell(13);
        headerCell.setCellValue("İrsaliye No");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(13, getWidth("İrsaliye No"));

        headerCell = header.createCell(14);
        headerCell.setCellValue("Fatura No");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(14, getWidth("Fatura No"));

        headerCell = header.createCell(15);
        headerCell.setCellValue("Vade");
        headerCell.setCellStyle(headerStyle);
        sheet.setColumnWidth(15, getWidth("Vade"));

    }

    private static int getWidth(String string) {
        return (int) (string.length() * 2 * 256);
    }

    private static void createRowFromSiparis(Row row, SiparisBilgisi siparisBilgisi) {

        Cell cell = row.createCell(0);
        cell.setCellValue(siparisBilgisi.getBoyananMalzeme());

        cell = row.createCell(1);
        cell.setCellValue(siparisBilgisi.getMalzemeCinsi());

        cell = row.createCell(2);
        cell.setCellValue(siparisBilgisi.getYuzeyIslem());

        cell = row.createCell(3);
        cell.setCellValue(siparisBilgisi.getRenkKodu());

        cell = row.createCell(4);
        cell.setCellValue(siparisBilgisi.getBoyaMiktari());

        cell = row.createCell(5);
        cell.setCellValue(siparisBilgisi.getIscilikSuresi());

        cell = row.createCell(6);
        cell.setCellValue(siparisBilgisi.getBoyananMalzemeMiktari());

        cell = row.createCell(7);
        cell.setCellValue(siparisBilgisi.getBirim());

        cell = row.createCell(8);
        cell.setCellValue(siparisBilgisi.getHat());

        cell = row.createCell(9);
        cell.setCellValue(siparisBilgisi.getBoyamaFiyati());

        cell = row.createCell(10);
        cell.setCellValue(siparisBilgisi.getTutar());

        cell = row.createCell(11);
        cell.setCellValue(dateFormat.format(siparisBilgisi.getAlimTarihi()));

        cell = row.createCell(12);
        cell.setCellValue(dateFormat.format(siparisBilgisi.getTeslimTarihi()));

        cell = row.createCell(13);
        cell.setCellValue(siparisBilgisi.getIrsaliyeNo());

        cell = row.createCell(14);
        cell.setCellValue(siparisBilgisi.getFaturaNo());

        cell = row.createCell(15);
        cell.setCellValue(siparisBilgisi.getVade());
    }

    private static void createTarihRaporlamaRowFromSiparis(Row row, SiparisBilgisi siparisBilgisi) {

        Cell cell = row.createCell(0);
        cell.setCellValue(siparisBilgisi.getMusteri().getMusteriAdi());

        cell = row.createCell(1);
        cell.setCellValue(siparisBilgisi.getBoyananMalzeme());

        cell = row.createCell(2);
        cell.setCellValue(siparisBilgisi.getMalzemeCinsi());

        cell = row.createCell(3);
        cell.setCellValue(siparisBilgisi.getYuzeyIslem());

        cell = row.createCell(4);
        cell.setCellValue(siparisBilgisi.getRenkKodu());

        cell = row.createCell(5);
        cell.setCellValue(siparisBilgisi.getBoyaMiktari());

        cell = row.createCell(6);
        cell.setCellValue(siparisBilgisi.getIscilikSuresi());

        cell = row.createCell(7);
        cell.setCellValue(siparisBilgisi.getBoyananMalzemeMiktari());

        cell = row.createCell(8);
        cell.setCellValue(siparisBilgisi.getBirim());

        cell = row.createCell(9);
        cell.setCellValue(siparisBilgisi.getHat());

        cell = row.createCell(10);
        cell.setCellValue(siparisBilgisi.getBoyamaFiyati());

        cell = row.createCell(11);
        cell.setCellValue(siparisBilgisi.getTutar());

        cell = row.createCell(12);
        cell.setCellValue(dateFormat.format(siparisBilgisi.getAlimTarihi()));

        cell = row.createCell(13);
        cell.setCellValue(dateFormat.format(siparisBilgisi.getTeslimTarihi()));

        cell = row.createCell(14);
        cell.setCellValue(siparisBilgisi.getIrsaliyeNo());

        cell = row.createCell(15);
        cell.setCellValue(siparisBilgisi.getFaturaNo());

        cell = row.createCell(16);
        cell.setCellValue(siparisBilgisi.getVade());
    }
}
