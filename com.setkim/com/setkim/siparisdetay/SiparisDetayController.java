package com.setkim.siparisdetay;

import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.SiparisBilgisi;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class SiparisDetayController {
    private static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    private SiparisDetayPanel view;
    private SiparisBilgisi siparisBilgisi;

    public SiparisDetayController(SiparisBilgisi siparisBilgisi) {

        view = new SiparisDetayPanel();

        this.siparisBilgisi = siparisBilgisi;

        initMusteriBilgisi(siparisBilgisi.getMusteri());
        initSiparisBilgisi(siparisBilgisi);

        initListener();
    }

    private void initListener() {

        view.getBtnGuncelle().addActionListener(e -> {

            Musteri musteri = siparisBilgisi.getMusteri();

            // Müşteri Güncelleme
            musteri.setMusteriAdi(view.getTextFieldMusteriAdi().getText());
            musteri.setAdres(view.getTextAreaAdres().getText());
            musteri.setVergiDairesi(view.getTextFieldVergiDairesi().getText());
            musteri.setVergiNo(view.getTextFieldVergiNo().getText());
            musteri.setYetkili(view.getTextFieldYetkili().getText());

            // Sipariş Bilgisi Güncelleme
            siparisBilgisi.setBoyananMalzeme(view.getTextFieldBoyananMalzeme().getText());
            siparisBilgisi.setMalzemeCinsi(view.getTextFieldMalzemeCinsi().getText());
            siparisBilgisi.setYuzeyIslem(view.getTextFieldYuzeyIslem().getText());
            siparisBilgisi.setRenkKodu(view.getTextFieldRenkKodu().getText());
            siparisBilgisi.setBoyamaFiyati(Double.parseDouble(view.getTextFieldBoyamaFiyati().getText()));
            siparisBilgisi.setIscilikSuresi(Double.parseDouble(view.getTextFieldIscilikSuresi().getText()));
            siparisBilgisi.setBoyananMalzemeMiktari(Double.parseDouble(view.getTextFieldBoyananMalzemeMiktari().getText()));
            siparisBilgisi.setAdet(Double.parseDouble(view.getTextFieldAdet().getText()));
            siparisBilgisi.setBirim(view.getTextFieldBirimi().getText());
            siparisBilgisi.setHat(Integer.parseInt(view.getTextFieldHat().getText()));
            //null
            if (!view.getTextFieldBoyamaFiyati().getText().equals("")) {

                siparisBilgisi.setBoyamaFiyati(Double.parseDouble(view.getTextFieldBoyamaFiyati().getText()));
            }
            //null
            if (!view.getTextFieldTutar().getText().equals("")) {

                siparisBilgisi.setTutar(Double.parseDouble(view.getTextFieldTutar().getText()));
            }

            //alim tarihi, teslim tarihi
            try {
                siparisBilgisi.setAlimTarihi(new SimpleDateFormat("dd/MM/yyyy").parse(view.getTextFieldAlimTarihi().getText()));
                siparisBilgisi.setTeslimTarihi(new SimpleDateFormat("dd/MM/yyyy").parse(view.getTextFieldTeslimTarihi().getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            siparisBilgisi.setIrsaliyeNo(view.getTextFieldIrsaliyeNo().getText());
            // null
            siparisBilgisi.setFaturaNo(view.getTextFieldFaturaNo().getText());
            siparisBilgisi.setVade(Integer.parseInt(view.getTextFieldVade().getText()));

            JOptionPane.showMessageDialog(
                    null,
                    "Bilgiler eklendi!",
                    "Başarılı",
                    JOptionPane.INFORMATION_MESSAGE);

        });
    }

    private void initSiparisBilgisi(SiparisBilgisi siparisBilgisi) {

        view.getTextFieldBoyananMalzeme().setText(siparisBilgisi.getBoyananMalzeme());
        view.getTextFieldMalzemeCinsi().setText(siparisBilgisi.getMalzemeCinsi());
        view.getTextFieldYuzeyIslem().setText(siparisBilgisi.getYuzeyIslem());
        view.getTextFieldRenkKodu().setText(siparisBilgisi.getRenkKodu());
        view.getTextFieldBoyaMiktari().setText(String.valueOf(siparisBilgisi.getBoyaMiktari()));
        view.getTextFieldIscilikSuresi().setText(String.valueOf(siparisBilgisi.getIscilikSuresi()));
        view.getTextFieldBoyananMalzemeMiktari().setText(String.valueOf(siparisBilgisi.getBoyananMalzemeMiktari()));
        view.getTextFieldAdet().setText(String.valueOf(siparisBilgisi.getAdet()));
        view.getTextFieldBirimi().setText(siparisBilgisi.getBirim());
        view.getTextFieldHat().setText(String.valueOf(siparisBilgisi.getHat()));

        if (siparisBilgisi.getBoyamaFiyati() != 0) {
            view.getTextFieldBoyamaFiyati().setText(String.valueOf(siparisBilgisi.getBoyamaFiyati()));
        }

        if (siparisBilgisi.getTutar() != 0) {
            view.getTextFieldTutar().setText(String.valueOf(siparisBilgisi.getTutar()));
        }

        view.getTextFieldAlimTarihi().setText(f.format(siparisBilgisi.getAlimTarihi()));
        view.getTextFieldTeslimTarihi().setText(f.format(siparisBilgisi.getTeslimTarihi()));
        view.getTextFieldIrsaliyeNo().setText(siparisBilgisi.getIrsaliyeNo());
        view.getTextFieldFaturaNo().setText(siparisBilgisi.getFaturaNo());
        view.getTextFieldVade().setText(String.valueOf(siparisBilgisi.getVade()));
    }

    private void initMusteriBilgisi(Musteri musteriBilgisi) {

        view.getTextFieldMusteriAdi().setText(musteriBilgisi.getMusteriAdi());
        view.getTextAreaAdres().setText(musteriBilgisi.getAdres());
        view.getTextFieldVergiDairesi().setText(musteriBilgisi.getVergiDairesi());
        view.getTextFieldVergiNo().setText(musteriBilgisi.getVergiNo());
        view.getTextFieldYetkili().setText(musteriBilgisi.getYetkili());
    }

    public SiparisDetayPanel getView() {
        return view;
    }
}
