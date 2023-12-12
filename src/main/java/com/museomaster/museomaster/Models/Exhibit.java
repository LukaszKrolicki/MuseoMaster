package com.museomaster.museomaster.Models;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.MediaPlayer;

public class Exhibit {
    private final IntegerProperty idZabytku;
    private final StringProperty nazwa_zabytku_tf;
    private final StringProperty okres_powstawnia_tf;
    private final StringProperty tematyka_tf;
    private final StringProperty tworca_tf;
    private final StringProperty akt_miej_przech_tf;
    private final StringProperty docelowe_miej_przech;
    private final StringProperty opis_ta;
    private final IntegerProperty WystawaidWystawy;
    private final IntegerProperty ZadanieidZadania;
    private final IntegerProperty SalaidSali;
    private final IntegerProperty ZadaniePracownikidPracownika;

    private String NormalExListIcon="STOP";
    private String NormalExListColor="#ff0062";

    private MediaPlayer NormalExListMedia=null;
    private Thread NormalExListThread=null;
    public Exhibit(Integer idZabytku, String nazwa_zabytku_tf, String okres_powstawnia_tf, String tematyka_tf, String tworca_tf, String akt_miej_przech_tf, String opis_ta, Integer WystawaidWystawy, Integer ZadanieidZadania, Integer SalaidSali, Integer ZadaniePracownikidPracownika
    ,String docelowe_miej_przech) {
        this.idZabytku = new SimpleIntegerProperty(this, "idEksponatu", idZabytku);
        this.nazwa_zabytku_tf =  new SimpleStringProperty(this, "nazwaEksponatu", nazwa_zabytku_tf);
        this.okres_powstawnia_tf = new SimpleStringProperty(this,"okresPowstania",okres_powstawnia_tf);
        this.tematyka_tf = new SimpleStringProperty(this,"tematyka", tematyka_tf);
        this.tworca_tf = new SimpleStringProperty(this, "twórca", tworca_tf);
        this.akt_miej_przech_tf = new SimpleStringProperty(this, "aktualMiejscePrzech", akt_miej_przech_tf);
        this.opis_ta = new SimpleStringProperty(this, "opis", opis_ta);
        this.WystawaidWystawy = new SimpleIntegerProperty(this, "WystawaidWystawy", WystawaidWystawy);
        this.ZadanieidZadania = new SimpleIntegerProperty(this, "ZadanieidZadania", ZadanieidZadania);
        this.SalaidSali = new SimpleIntegerProperty(this, "SalaidSali", SalaidSali);
        this.ZadaniePracownikidPracownika = new SimpleIntegerProperty(this, "ZadaniePracownikidPracownika", ZadaniePracownikidPracownika);
        this.docelowe_miej_przech = new SimpleStringProperty(this, "docelowe_miej_przech", docelowe_miej_przech);
    }

    Integer idZad;
    Integer idZadEx;

    public Exhibit(Integer idZabytku, String nazwa_zabytku_tf, String akt_miej_przech_tf, String docelowe_miej_przech, Integer idZad, Integer idZadEx) {
        this.idZabytku = new SimpleIntegerProperty(this, "idEksponatu", idZabytku);
        this.nazwa_zabytku_tf =  new SimpleStringProperty(this, "nazwaEksponatu", nazwa_zabytku_tf);
        this.akt_miej_przech_tf = new SimpleStringProperty(this, "aktualMiejscePrzech", akt_miej_przech_tf);
        this.docelowe_miej_przech = new SimpleStringProperty(this, "docelowe_miej_przech", docelowe_miej_przech);
        this.idZad=idZad;
        this.idZadEx=idZadEx;

        this.okres_powstawnia_tf = new SimpleStringProperty(this,"okresPowstania","");
        this.tematyka_tf = new SimpleStringProperty(this,"tematyka", "");
        this.tworca_tf = new SimpleStringProperty(this, "twórca", "");
        this.opis_ta = new SimpleStringProperty(this, "opis", "");
        this.WystawaidWystawy = new SimpleIntegerProperty(this, "WystawaidWystawy", -1);
        this.ZadanieidZadania = new SimpleIntegerProperty(this, "ZadanieidZadania", -1);
        this.SalaidSali = new SimpleIntegerProperty(this, "SalaidSali", -1);
        this.ZadaniePracownikidPracownika = new SimpleIntegerProperty(this, "ZadaniePracownikidPracownika", -1);
    }

    public Integer getIdZad() {
        return idZad;
    }

    public Integer getIdZadEx() {
        return idZadEx;
    }

    public String getDocelowe_miej_przech() {
        return docelowe_miej_przech.get();
    }

    public StringProperty docelowe_miej_przechProperty() {
        return docelowe_miej_przech;
    }

    public void setDocelowe_miej_przech(String docelowe_miej_przech) {
        this.docelowe_miej_przech.set(docelowe_miej_przech);
    }

    public MediaPlayer getNormalExListMedia() {
        return NormalExListMedia;
    }

    public void setNormalExListMedia(MediaPlayer normalExListMedia) {
        NormalExListMedia = normalExListMedia;
    }

    public Thread getNormalExListThread() {
        return NormalExListThread;
    }

    public void setNormalExListThread(Thread normalExListThread) {
        NormalExListThread = normalExListThread;
    }

    public String getNormalExListColor() {
        return NormalExListColor;
    }

    public void setNormalExListColor(String normalExListColor) {
        NormalExListColor = normalExListColor;
    }

    public String getNormalExListIcon() {
        return NormalExListIcon;
    }

    public void setNormalExListIcon(String normalExListIcon) {
        NormalExListIcon = normalExListIcon;
    }

    public StringProperty nazwa_zabytku_tfProperty() {
        return nazwa_zabytku_tf;
    }
    public StringProperty okres_powstawnia_tfProperty() {
        return okres_powstawnia_tf;
    }
    public StringProperty tematyka_tfProperty() {
        return tematyka_tf;
    }
    public StringProperty tworca_tfProperty() {
        return tworca_tf;
    }
    public StringProperty akt_miej_przech_tfProperty() {
        return akt_miej_przech_tf;
    }
    public StringProperty opis_taProperty() {
        return opis_ta;
    }
    public IntegerProperty idZabytkuProperty() {
        return idZabytku;
    }
    public IntegerProperty wystawaidWystawyProperty() {
        return WystawaidWystawy;
    }
    public IntegerProperty zadanieidZadaniaProperty() {
        return ZadanieidZadania;
    }
    public IntegerProperty salaidSaliProperty() {
        return SalaidSali;
    }
    public IntegerProperty zadaniePracownikidPracownikaProperty() {
        return ZadaniePracownikidPracownika;
    }
}
