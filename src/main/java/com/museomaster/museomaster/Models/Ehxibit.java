package com.museomaster.museomaster.Models;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ehxibit {
    private final StringProperty nazwa_zabytku_tf;
    private final StringProperty okres_powstawnia_tf;
    private final StringProperty tematyka_tf;
    private final StringProperty tworca_tf;
    private final StringProperty akt_miej_przech_tf;
    private final StringProperty opis_ta;

    public Ehxibit(String nazwa_zabytku_tf, String okres_powstawnia_tf, String tematyka_tf, String tworca_tf, String akt_miej_przech_tf, String opis_ta) {
        this.nazwa_zabytku_tf =  new SimpleStringProperty(this, "nazwaEksponatu", nazwa_zabytku_tf);
        this.okres_powstawnia_tf = new SimpleStringProperty(this,"okresPowstania",okres_powstawnia_tf);
        this.tematyka_tf = new SimpleStringProperty(this,"tematyka", tematyka_tf);
        this.tworca_tf = new SimpleStringProperty(this, "twórca", tworca_tf);
        this.akt_miej_przech_tf = new SimpleStringProperty(this, "aktualMiejscePrzech", akt_miej_przech_tf);
        this.opis_ta = new SimpleStringProperty(this, "opis", opis_ta);
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
}
