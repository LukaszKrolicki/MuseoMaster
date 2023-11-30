package com.museomaster.museomaster.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    private final IntegerProperty idPracownika;
    private final StringProperty imiePracownika;

    private final StringProperty nazwiskoPracownika;

    private final StringProperty emailPracownika;

    private final IntegerProperty wiekPracownika;

    private final IntegerProperty czyUprawniony;

    private final StringProperty rola;
    private final IntegerProperty nrTelefonu;
    private final StringProperty nazwaUzytkownika;

    public Client(Integer idPracownika, String imiePracownika, String nazwiskoPracownika, String emailPracownika, Integer wiekPracownika, Integer czyUprawniony, String rola, Integer nrTelefonu, String nazwaUzytkownika) {
        this.idPracownika = new SimpleIntegerProperty(this, "idPracownika",idPracownika);
        this.imiePracownika = new SimpleStringProperty(this, "imiePracownika",imiePracownika);
        this.nazwiskoPracownika = new SimpleStringProperty(this, "nazwiskoPracownika",nazwiskoPracownika);
        this.nrTelefonu = new SimpleIntegerProperty(this, "nrTelefonu",nrTelefonu);
        this.nazwaUzytkownika = new SimpleStringProperty(this,"nazwaUzytkownika",nazwaUzytkownika);
        this.emailPracownika = new SimpleStringProperty(this,"emailPracownika",emailPracownika);
        this.wiekPracownika = new SimpleIntegerProperty(this,"wiekPracownika",wiekPracownika);
        this.czyUprawniony = new SimpleIntegerProperty(this,"czyUprawniony",czyUprawniony);
        this.rola = new SimpleStringProperty(this,"rola",rola);
    }


    public IntegerProperty getNrTelefonu() {
        return nrTelefonu;
    }

    public IntegerProperty nrTelefonuProperty() {
        return nrTelefonu;
    }

    public IntegerProperty idPracownikaProperty() {
        return idPracownika;
    }

    public StringProperty imiePracownikaProperty() {
        return imiePracownika;
    }
    public StringProperty nazwiskoPracownikaProperty() {
        return nazwiskoPracownika;
    }

    public StringProperty emailPracownikaProperty() {
        return emailPracownika;
    }

    public IntegerProperty wiekPracownikaProperty() {
        return wiekPracownika;
    }

    public IntegerProperty czyUprawnionyProperty() {
        return czyUprawniony;
    }

    public StringProperty rolaProperty() {
        return rola;
    }


    public StringProperty nazwaUzytkownikaProperty() {
        return nazwaUzytkownika;
    }
}
