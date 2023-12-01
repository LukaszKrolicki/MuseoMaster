package com.museomaster.museomaster.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Report {
    private final IntegerProperty idPracownika;

    private final IntegerProperty idReportu;
    private final StringProperty nazwaUzytkownika;
    private final StringProperty opis;

    public Report(Integer idPracownika, Integer idReportu, String nazwaUzytkownika, String opis) {
        this.idPracownika = new SimpleIntegerProperty(this, "idPracownika",idPracownika);
        this.idReportu = new SimpleIntegerProperty(this, "idReportu",idReportu);
        this.nazwaUzytkownika = new SimpleStringProperty(this, "NazwaUzytkownika",nazwaUzytkownika);
        this.opis = new SimpleStringProperty(this, "opis",opis);
    }

    public int getIdReportu() {
        return idReportu.get();
    }

    public IntegerProperty idReportuProperty() {
        return idReportu;
    }

    public String getNazwaUzytkownika() {
        return nazwaUzytkownika.get();
    }

    public StringProperty nazwaUzytkownikaProperty() {
        return nazwaUzytkownika;
    }

    public int getIdPracownika() {
        return idPracownika.get();
    }

    public IntegerProperty idPracownikaProperty() {
        return idPracownika;
    }

    public String getOpis() {
        return opis.get();
    }

    public StringProperty opisProperty() {
        return opis;
    }
}
