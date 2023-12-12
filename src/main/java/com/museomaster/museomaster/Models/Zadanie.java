package com.museomaster.museomaster.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Zadanie {
    private final IntegerProperty idZadania;
    private final StringProperty temat;
    private final StringProperty opis;
    private final StringProperty startData;
    private final StringProperty endData;
    private final StringProperty status;

    private final IntegerProperty idPracownika;

    private final StringProperty nazwaUzytkownikaNadajacego;

    private final StringProperty nazwaUzytkownika;

    public Zadanie(Integer idZadania, String temat, String opis, String startData, String endData, String status, Integer idPracownika,String nazwaUzytkownikaNadajacego, String nazwaUzytkownika) {
        this.idPracownika = new SimpleIntegerProperty(this, "idPracownika",idPracownika);
        this.idZadania= new SimpleIntegerProperty(this, "idZadania",idZadania);
        this.temat = new SimpleStringProperty(this, "temat",temat);
        this.opis=new SimpleStringProperty(this, "opis",opis);
        this.startData= new SimpleStringProperty(this, "startData",startData);
        this.endData=new SimpleStringProperty(this, "endData",endData);
        this.status= new SimpleStringProperty(this, "status",status);
        this.nazwaUzytkownikaNadajacego=new SimpleStringProperty(this, "nazwaUzytkownikaNadajacego",nazwaUzytkownikaNadajacego);
        this.nazwaUzytkownika=new SimpleStringProperty(this, "nazwaUzytkownikA",nazwaUzytkownika);
    }

    public String getNazwaUzytkownika() {
        return nazwaUzytkownika.get();
    }

    public StringProperty nazwaUzytkownikaProperty() {
        return nazwaUzytkownika;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getNazwaUzytkownikaNadajacego() {
        return nazwaUzytkownikaNadajacego.get();
    }

    public StringProperty nazwaUzytkownikaNadajacegoProperty() {
        return nazwaUzytkownikaNadajacego;
    }

    public int getIdZadania() {
        return idZadania.get();
    }

    public IntegerProperty idZadaniaProperty() {
        return idZadania;
    }

    public String getTemat() {
        return temat.get();
    }

    public StringProperty tematProperty() {
        return temat;
    }

    public String getOpis() {
        return opis.get();
    }



    public StringProperty opisProperty() {
        return opis;
    }

    public String getStartData() {
        return startData.get();
    }

    public StringProperty startDataProperty() {
        return startData;
    }

    public String getEndData() {
        return endData.get();
    }

    public StringProperty endDataProperty() {
        return endData;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public int getIdPracownika() {
        return idPracownika.get();
    }

    public IntegerProperty idPracownikaProperty() {
        return idPracownika;
    }
}
