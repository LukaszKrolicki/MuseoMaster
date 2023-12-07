package com.museomaster.museomaster.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pomieszczenie {
    private final IntegerProperty idSali;
    private final IntegerProperty wielkosc;
    private final StringProperty nazwa;
    private final StringProperty typ;

    public Pomieszczenie(Integer idSali, Integer wielkosc, String nazwa, String typ) {
        this.idSali = new SimpleIntegerProperty(this, "idSali", idSali);
        this.wielkosc = new SimpleIntegerProperty(this, "wielkość", wielkosc);
        this.nazwa = new SimpleStringProperty(this, "nazwa", nazwa);
        this.typ = new SimpleStringProperty(this, "typ", typ);
    }
    public IntegerProperty idSaliProperty() {
        return idSali;
    }
    public IntegerProperty wielkoscProperty() {
        return wielkosc;
    }
    public StringProperty nazwaProperty() {
        return nazwa;
    }
    public StringProperty typProperty() {
        return typ;
    }
}
