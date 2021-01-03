package com.example.kalorikocum;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.banner.BannerView;



public class MainActivity2 extends AppCompatActivity {
    ListView mListView;
    InterstitialAd interstitialAd;
    String []Yemekisimleri ={"Urfa Kebap","Pilav","Bulgur Pilavı","İçli köfte","Adana Kebap","Taze Fasulye","Kuru fasulye","Ispanak","Kelle Paça","Mercimek Çorbası","Yayla Çorbası","İşkembe Çorbası","İmam Bayıldı","Karnıyarık","İncik","Dalyan Köfte","Et Döner","Tavuk Döner","Tavuk Şiş","Kuzu Pirzola","Barbunya","Mantı","Hamsi","Lahmacun","Fırın köfte"
            ,"Kıymalı Pide","Kaşarlı Pide","Kavurma","Etli Güveç","Etli Ekmek","Su Böreği","Menemen","Tantuni","Kıymalı Enginar"};
    String []YemekBilgileri = {"1 Porsiyon Urfa Kebap 265 kcal'dir (kalori). \n" +
            "\n" +
            "%4 Karbonhidrat\n" +
            "%35 Protein\n" +
            "%61 Yağ\n" +
            "\n" +
            "44 dakika Yürümek \n" +
            "20 dakika koşmak\t\n" +
            "37 dakika bisiklete sürmek\n" +
            "26 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 265 kaloriyi yakmış olacaksınız.\n" +
            "\n" ,"1 Porsiyon Tereyağlı Pirinç Pilavı 283 kcal'dir (kalori).\n" +
            "\n" +
            "%66 Karbonhidrat\n" +
            "%6 Protein\n" +
            "%28 Yağ\n" +
            "\n" +
            "47 dakika yürümek\n" +
            "21 dakika koşmak\n" +
            "40 dakika bisiklet sürmek\n" +
            "28 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 283 kaloriyi yakmış olacaksınız.","1 Porsiyon (250gr) Bulgur Pilavı 290 kcal'dir (kalori).\n" +
            "\n" +
            "%63 Karbonhidrat\n" +
            "%10 Protein\n" +
            "%27 Yağ\n" +
            "\n" +
            "68 dakika yürümek\n" +
            "22 dakika koşmak\n" +
            "41 dakika bisiklet sürmek\n" +
            "29 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 290 kaloriyi yakmış olacaksınız.\n" +
            "\n","1 Adet içli köfte (100g)232 kcal\n" +
            "\n" +
            "Besin değerleri:\n" +
            "Karbonhidrat %49\n" +
            "Protein% 15\n" +
            "Yağ %36\n" +
            "38 dakika yürümek\n" +
            "17 dakika koşmak\n" +
            "33 dakika bisiklet Sürmek\n" +
            "23 dakika yüzmek\n" +
            "\n" + "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 232 kaloriyi yakmış olacaksınız. ","1 Porsiyon Adana Kebap 361 kcal'dir (kalori). \n" +
            "\n" +
            "%2 Karbonhidrat\n" +
            "%24 Protein\n" +
            "%74 Yağ\n" +
            "\n" +
            "60 dakika yürümek\n" +
            "27 dakika koşmak\n" +
            "51 dakika bisiklet sürmek\n" +
            "36 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 361 kaloriyi yakmış olacaksınız.","1 Porsiyon Pişmiş Taze Fasulye 52 kcal'dir (kalori). \n" +
            "\n" +
            "%74 Karbonhidrat\n" +
            "%19 Protein\n" +
            "%7 Yağ\n" +
            "\n" +
            "8 dakika yürümek\n" +
            "4 dakika koşmak\n" +
            "7 dakika bisiklet sürmek\n" +
            "5 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 52 kaloriyi yakmış olacaksınız.","1 Porsiyon (200gr) Kuru Fasulye (Etsiz) 240 kcal'dir (kalori). \n" +
            "\n" +
            "%70 Karbonhidrat\n" +
            "%27 Protein\n" +
            "%2 Yağ\n" +
            "\n" +
            "40 dakika Yürümek \n" +
            "18 dakika koşmak\t\n" +
            "34 dakika bisiklete sürmek\n" +
            "24 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 240 kaloriyi yakmış olacaksınız.","1 Porsiyon Ispanak Yemeği 133 kcal'dir (kalori).\n" +
            "\n" +
            "%31 Karbonhidrat\n" +
            "%13 Protein\n" +
            "%56 Yağ\n" +
            "\n" +
            "22 dakika yürümek\n" +
            "10 dakika koşmak\n" +
            "19 dakika bisiklet sürmek\n" +
            "13 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 133 kaloriyi yakmış olacaksınız.","1 Kase Kelle Paça Çorbası 330 kcal'dir (kalori)\n" +
            "\n" +
            "%14 Karbonhidrat\n" +
            "%39 Protein\n" +
            "%47 Yağ\n" +
            "\n" +
            "55 dakika yürümek\t\n" +
            "25 dakika koşmak\n" +
            "47 dakika bisiklet sürmek\n" +
            "33 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 330 kaloriyi yakmış olacaksınız.","1 Porsiyon Mercimek Çorbası 139 kcal'dir (kalori).\n" +
            "\n" +
            "%73 Karbonhidrat\n" +
            "%22 Protein\n" +
            "%4 Yağ\n" +
            "\n" +
            "23 dakika yürümek\n" +
            "10 dakika koşmak\n" +
            "29 dakika bisiklet sürmek\n" +
            "13 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 139 kaloriyi yakmış olacaksınız.","1 Porsiyon Yayla Çorbası 98 kcal'dir (kalori).\n" +
            "\n" +
            "%57 Karbonhidrat\n" +
            "%13 Protein\n" +
            "%30 Yağ\n" +
            "\n" +
            "16 dakika yürümek\n" +
            "7 dakika koşmak\n" +
            "14 dakika bisiklet sürmek\n" +
            "9 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 98 kaloriyi yakmış olacaksınız.","1 Kase (200gr) İşkembe Çorbası 278 kcal'dir (kalori).\n" +
            "\n" +
            "%14 Karbonhidrat\n" +
            "%44 Protein\n" +
            "%41 Yağ\n" +
            "\n" +
            "46 dakika yürümek\n" +
            "21 dakika koşmak\n" +
            "39 dakika bisiklet sürmek\n" +
            "27 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 278 kaloriyi yakmış olacaksınız.\n","1 Porsiyon İmambayıldı 164 kcal'dir (kalori).\n" +
            "\n" +
            "%40 Karbonhidrat\n" +
            "%17 Protein\n" +
            "%43 Yağ\n" +
            "\n" +
            "27 dakika yürümek\n" +
            "12 dakika koşmak\n" +
            "23 dakika bisiklet sürmek\n" +
            "16 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 164 kaloriyi yakmış olacaksınız.","1 Porsiyon Karnıyarık 191 kcal'dir (kalori). \n" +
            "%18 Karbonhidrat\n" +
            "%24 Protein\n" +
            "%58 Yağ\n" +
            "\n" +
            "31 dakika yürümek\n" +
            "14 dakika koşmak\n" +
            "27 dakika bisiklet sürmek\n" +
            "19 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 191 kaloriyi yakmış olacaksınız.","1 Porsiyon Kuzu İncik 450 kcal'dir (kalori).\n" +
            "%5 Karbonhidrat\n" +
            "%36 Protein\n" +
            "%60 Yağ\n" +
            "\n" +
            "75 dakika yürümek\n" +
            "34 dakika koşmak\n" +
            "64 dakika  bisiklet sürmek\n" +
            "45 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 450 kaloriyi yakmış olacaksınız.","1 Porsiyon Dalyan Köfte 360 kcal'dir (kalori). \n" +
            "\n" +
            "%10 Karbonhidrat\n" +
            "%42 Protein\n" +
            "%48 Yağ\n" +
            "\n" +
            "60 dakika yürümek\n" +
            "27 dakika koşmak\n" +
            "51 dakika bisiklet sürmek\n" +
            "36 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 360 kaloriyi yakmış olacaksınız.","1 Porsiyon Et Döner 478 kcal'dir (kalori).\n" +
            "\n" +
            "%38 Karbonhidrat\n" +
            "%20 Protein\n" +
            "%42 Yağ\n" +
            "\n" +
            "79 dakika yürümek\n" +
            "26 dakika koşmak\n" +
            "68 dakika bisiklet sürmek\n" +
            "47 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 478 kaloriyi yakmış olacaksınız.","1 Porsiyon Tavuk Döner 250 kcal'dir (kalori)\n" +
            "\n" +
            "%10 Karbonhidrat\n" +
            "%29 Protein\n" +
            "%61 Yağ\n" +
            "\n" +
            "41 dakika yürümek\n" +
            "19 dakika koşmak\n" +
            "35 dakika bisiklet sürmek\n" +
            "25 dakika yüzmek\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 250 kaloriyi yakmış olacaksınız.","1 Porsiyon Tavuk Şiş 208 kcal'dir (kalori)\n" +
            "\n" +
            "%6 Karbonhidrat\n" +
            "%59 Protein\n" +
            "%34 Yağ\n" +
            "\n" +
            "\n" +
            "34 dakika yürümek\n" +
            "16 dakika koşmak\n" +
            "29 dakika bisiklet sürmek\n" +
            "20 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 208 kaloriyi yakmış olacaksınız."," 1 Porsiyon Kuzu Pirzola 242 kcal'dir (kalori).\n" +
            "\n" +
            "%8 Karbonhidrat\n" +
            "%24 Protein\n" +
            "%68 Yağ\n" +
            "\n" +
            "40 dakika yürümek\n" +
            "18 dakika koşmak\n" +
            "34 dakika bisiklet sürmek\n" +
            "24 dakika yüzmekn" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 242 kaloriyi yakmış olacaksınız.","1 Porsiyon Barbunya 413 kcal'dir (kalori)\n" +
            "\n" +
            "%40 Karbonhidrat\n" +
            "%23 Protein\n" +
            "%37 Yağ\n" +
            "\n" +
            "\n" +
            "68 dakika yürümek\n" +
            "31 dakika koşmak\n" +
            "59 dakika bisiklet sürmek\n" +
            "41 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 413 kaloriyi yakmış olacaksınız.","1 Porsiyon Mantı 399 kcal'dir (kalori).\n" +
            "\n" +
            "%48 Karbonhidrat\n" +
            "%24 Protein\n" +
            "%28 Yağ\n" +
            "\n" +
            "66 dakika yürümek\n" +
            "30 dakika koşmak\n" +
            "57 bisiklet sürmek\n" +
            "39 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 399 kaloriyi yakmış olacaksınız.","1 Porsiyon Hamsi 230 kcal'dir (kalori). \n" +
            "\n" +
            "%0 Karbonhidrat\n" +
            "%60 Protein\n" +
            "%40 Yağ\n" +
            "\n" +
            "38 dakika yürümek\n" +
            "17 dakika koşmak\n" +
            "32 bisiklet sürmek\n" +
            "23 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 230 kaloriyi yakmış olacaksınız.","1 Porsiyon Lahmacun 221 kcal'dir (kalori). \n" +
            "\n" +
            "%59 Karbonhidrat\n" +
            "%18 Protein\n" +
            "%23 Yağ\n" +
            "\n" +
            "36 dakika yürümek\n" +
            "17 dakika koşmak\n" +
            "31 bisiklet sürmek\n" +
            "22 dakika yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 221 kaloriyi yakmış olacaksınız.\n","1 porsiyon fırın köfte 283 kcal ‘dir\n" +
            "%26 Karbonhidrat\n" +
            "%26 Protein\n" +
            "%48 Yağ\n" +
            "\n" +
            "47 dakika Yürümek\n" +
            "21 dakika Koşmak\n" +
            "40 dakika Bisiklet Sürmek\n" +
            "28 dakika Yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 238 kaloriyi yakmış olacaksınız.","1 porsiyon kıymalı pide (170g)356kcal’dır\n" +
            "%47 Karbonhidrat\n" +
            "%16 Protein\n" +
            "%37 Yağ\n" +
            "\n" +
            "59 dakika Yürümek\n" +
            "27 dakika Koşmak\n" +
            "50 dakika Bisiklet Sürmek\n" +
            "35dakikaYüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 356 kaloriyi yakmış olacaksınız.","1 porsiyon kaşarlı pide (215g)516kcal’dır\n" +
            "%46 Karbonhidrat\n" +
            "%13 Protein\n" +
            "%40 Yağ\n" +
            "\n" +
            "86 dakika Yürümek\n" +
            "39 dakika Koşmak\n" +
            "73 dakika Bisiklet Sürmek\n" +
            "51 dakika Yüzmek  \n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 516 kaloriyi yakmış olacaksınız.","1 porsiyon Kavurma (100g)345kcal’dır\n" +
            "\n" +
            "%0 Karbonhidrat\n" +
            "%24 Protein\n" +
            "%76 Yağ\n" +
            "\n" +
            "57 dakika Yürümek\n" +
            "26 dakika Koşmak\n" +
            "49 dakika Bisiklet Sürmek\n" +
            "34 dakika Yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 345 kaloriyi yakmış olacaksınız.","1 porsiyon Etli güveç türlü (320g)207kcal’dır\n" +
            "\n" +
            "%29 Karbonhidrat\n" +
            "%23 Protein\n" +
            "%48 Yağ\n" +
            "\n" +
            "34 dakika Yürümek\n" +
            "15 dakika Koşmak\n" +
            "29 dakika Bisiklet Sürmek\n" +
            "20 dakika Yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 207 kaloriyi yakmış olacaksınız.","1 porsiyon etli ekmek (131g)277kcal’dır\n" +
            "\n" +
            "%46 Karbonhidrat\n" +
            "%22 Protein\n" +
            "%32 Yağ\n" +
            "\n" +
            "47 dakika Yürümek\n" +
            "21 dakika Koşmak\n" +
            "40 dakika Bisiklet Sürmek\n" +
            "28 dakika Yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 277 kaloriyi yakmış olacaksınız.","1 porsiyon su böreği (330g)756kcal’dır\n" +
            "\n" +
            "%44 Karbonhidrat\n" +
            "%13 Protein\n" +
            "%43 Yağ\n" +
            "\n" +
            "126 dakika Yürümek\n" +
            "58 dakika Koşmak\n" +
            "108 dakika Bisiklet Sürmek\n" +
            "75 dakika Yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 756 kaloriyi yakmış olacaksınız.","1 porsiyon Menemen (250g)179kcal’dır\n" +
            "\n" +
            "%20 Karbonhidrat\n" +
            "%20 Protein\n" +
            "%61 Yağ\n" +
            "\n" +
            "29 dakika Yürümek\n" +
            "13 dakika Koşmak\n" +
            "25 dakika Bisiklet Sürmek\n" +
            "17 dakika Yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 179 kaloriyi yakmış olacaksınız.","1 porsiyon tantuni(226g)379kcal’dır\n" +
            "\n" +
            "%11 Karbonhidrat\n" +
            "%25 Protein\n" +
            "%64 Yağ\n" +
            "\n" +
            "63 dakika Yürümek\n" +
            "29 dakika Koşmak\n" +
            "54 dakika Bisiklet Sürmek\n" +
            "37dakikaYüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 379 kaloriyi yakmış olacaksınız.","1 porsiyon Kıymalı Enginar(225g)176kcal’dır\n" +
            "\n" +
            "%18 Karbonhidrat\n" +
            "%26 Protein\n" +
            "%56 Yağ\n" +
            "\n" +
            "29 dakika Yürümek\n" +
            "13 dakika Koşmak\n" +
            "25 dakika Bisiklet Sürmek\n" +
            "17 dakika Yüzmek\n" +
            "\n" +
            "Yukarıda gösterilen aktivitelerden 1 tanesini yaptıktan sonra 176 kaloriyi yakmış olacaksınız."};
    int []resimler={R.drawable.kebabs,R.drawable.pilavs,R.drawable.bulgurpilavi,R.drawable.iclikofte,R.drawable.adanakebab,R.drawable.tazefasulye,R.drawable.kurufasulye,R.drawable.ispanak,R.drawable.kellepaca,R.drawable.mercimek,R.drawable.yayla,R.drawable.iskembe,R.drawable.imambayildi,R.drawable.karniyarik,R.drawable.incik,R.drawable.dalyankofte,R.drawable.etdoner,
            R.drawable.tavukdoner,R.drawable.tavuksis,R.drawable.kuzupirzola,R.drawable.barbunya, R.drawable.manti,R.drawable.hamsi,R.drawable.lahmacun,R.drawable.firinkofte,R.drawable.kiymalipide,R.drawable.kasarlipide,R.drawable.kavurma,R.drawable.etliguvec,R.drawable.etliekmek,R.drawable.suborek,R.drawable.menemen,R.drawable.tantuni,R.drawable.kiymalienginar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        HwAds.init(this);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdId("teste9ih9j0rc3");
        interstitialAd.setAdListener(adListener);

        AdParam adParam = new AdParam.Builder().build();
        interstitialAd.loadAd(adParam);

        mListView = findViewById(R.id.listview);
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(MainActivity2.this, Yemekisimleri, YemekBilgileri,resimler);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity2.this, MainActivity3.class);
                mIntent.putExtra("Yemekisimleri", Yemekisimleri[i]);
                mIntent.putExtra("resimler", resimler[i]);
                mIntent.putExtra("Yemekbilgileri",YemekBilgileri[i]);
                startActivity(mIntent);
                showInterstitial();


            }
        });
    }
    public void loadBannerAd(){
        BannerView bannerView = new BannerView(this);
        bannerView.setAdId("testw6vs28auh3");
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_SMART);
        AdParam adParam = new AdParam.Builder().build();
        bannerView.loadAd(adParam);
    }
    private AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
        }

        @Override
        public void onAdFailed(int errorCode) {
            Toast.makeText(MainActivity2.this, "Ad load failed with error code: " + errorCode,
                    Toast.LENGTH_SHORT).show();
            Log.d("TAG", "Ad load failed with error code: " + errorCode);
        }

        @Override
        public void onAdClosed() {
            super.onAdClosed();
            Log.d("TAG", "onAdClosed");
        }

        @Override
        public void onAdClicked() {
            Log.d("TAG", "onAdClicked");
            super.onAdClicked();
        }

        @Override
        public void onAdOpened() {
            Log.d("TAG", "onAdOpened");
            super.onAdOpened();
        }
    };

    private void showInterstitial() {
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
        }
    }
}