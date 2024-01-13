package com.setkim.siparisdetay;

import com.setkim.util.objects.Musteri;
import com.setkim.util.objects.SiparisBilgisi;

import java.text.SimpleDateFormat;

public class SiparisDetayController {
    private static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    private SiparisDetayPanel view;

    public SiparisDetayController(SiparisBilgisi siparisBilgisi) {

        view = new SiparisDetayPanel();

        initMusteriBilgisi(siparisBilgisi.getMusteri());
        initSiparisBilgisi(siparisBilgisi);

        initListener();
    }

    private void initListener() {

        view.getBtnfaturalandir().addActionListener(e -> {
            //TODO faturalandırma
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
        view.getTextFieldBirimi().setText(siparisBilgisi.getBirim());
        view.getTextFieldHat().setText(String.valueOf(siparisBilgisi.getHat()));
        view.getTextFieldBoyamaFiyati().setText(String.valueOf(siparisBilgisi.getBoyamaFiyati()));
        view.getTextFieldTutar().setText(String.valueOf(siparisBilgisi.getTutar()));
        view.getTextFieldAlimTarihi().setText(f.format(siparisBilgisi.getAlimTarihi()));
        view.getTextFieldTeslimTarihi().setText(f.format(siparisBilgisi.getTeslimTarihi()));
        view.getTextFieldIrsaliyeNo().setText(siparisBilgisi.getIrsaliyeNo());
        view.getTextFieldFaturaNo().setText(siparisBilgisi.getFaturaNo());
        view.getTextFieldVade().setText(String.valueOf(siparisBilgisi.getVade()));
    }

    private void initMusteriBilgisi(Musteri musteriBilgisi) {

        view.getTextFieldMusteriAdi().setText(musteriBilgisi.getMusteriAdi());
        view.getTextFieldBelgeNumarasi().setText(String.valueOf(musteriBilgisi.getBelgeNo()));
        view.getTextAreaAdres().setText(musteriBilgisi.getAdres());
        view.getTextFieldVergiDairesi().setText(musteriBilgisi.getVergiDairesi());
        view.getTextFieldVergiNo().setText(musteriBilgisi.getVergiNo());
        view.getTextFieldYetkili().setText(musteriBilgisi.getYetkili());
    }

    public SiparisDetayPanel getView() {
        return view;
    }
}
