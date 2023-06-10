package com.setkim.siparisdetay;

import java.util.List;

public class SiparisDetayController {
    private SiparisDetayPanel view;

    public SiparisDetayController(List<Object> musteriBilgisi, List<Object> siparisBilgisi) {

        view = new SiparisDetayPanel();

        initMusteriBilgisi(musteriBilgisi);
        initSiparisBilgisi(siparisBilgisi);
    }

    private void initSiparisBilgisi(List<Object> siparisBilgisi) {

        view.getTextFieldBoyananMalzeme().setText((String) siparisBilgisi.get(0));
        view.getTextFieldMalzemeCinsi().setText((String) siparisBilgisi.get(1));
        view.getTextFieldYuzeyIslem().setText((String) siparisBilgisi.get(2));
        view.getTextFieldRenkKodu().setText((String) siparisBilgisi.get(3));
        view.getTextFieldBoyaMiktari().setText(String.valueOf((double) siparisBilgisi.get(4)));
        view.getTextFieldIscilikSuresi().setText(String.valueOf((double) siparisBilgisi.get(5)));
        view.getTextFieldBoyananMalzemeMiktari().setText(String.valueOf((double) siparisBilgisi.get(6)));
        view.getTextFieldBirimi().setText((String) siparisBilgisi.get(7));
        view.getTextFieldHat().setText(String.valueOf((int) siparisBilgisi.get(8)));
        view.getTextFieldBoyamaFiyati().setText(String.valueOf((double) siparisBilgisi.get(9)));
        view.getTextFieldTutar().setText(String.valueOf((double) siparisBilgisi.get(10)));
        view.getTextFieldAlimTarihi().setText((String) siparisBilgisi.get(12));
        view.getTextFieldTeslimTarihi().setText((String) siparisBilgisi.get(13));
        view.getTextFieldIrsaliyeNo().setText((String) siparisBilgisi.get(14));
        view.getTextFieldFaturaNo().setText((String) siparisBilgisi.get(15));
        view.getTextFieldVade().setText(String.valueOf((int) siparisBilgisi.get(16)));
    }

    private void initMusteriBilgisi(List<Object> musteriBilgisi) {

        view.getTextFieldMusteriAdi().setText((String) musteriBilgisi.get(0));
        view.getTextFieldBelgeNumarasi().setText(String.valueOf((int) musteriBilgisi.get(1)));
        view.getTextAreaAdres().setText((String) musteriBilgisi.get(2));
        view.getTextFieldVergiDairesi().setText((String) musteriBilgisi.get(3));
        view.getTextFieldVergiNo().setText((String) musteriBilgisi.get(4));
        view.getTextFieldYetkili().setText((String) musteriBilgisi.get(5));
    }

    public SiparisDetayPanel getView() {
        return view;
    }
}
