package com.museomaster.museomaster.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Exhibition {
    private final IntegerProperty idWystawy;
    private final StringProperty nazwaWystawy;
    private final StringProperty sala;
    private final StringProperty miejsceWykonania;
    private final StringProperty tematyka;
    private final StringProperty tworca;
    private final ObjectProperty<LocalDate> dataRozpoczecia;
    private final ObjectProperty<LocalDate> dataZakonczenia;

    public Exhibition(Integer idWystawy, String nazwaWystawy, String sala, String miejsceWykonania,
                      String tematyka, String tworca, LocalDate dataRozpoczecia, LocalDate dataZakonczenia) {
        this.idWystawy = new SimpleIntegerProperty(this, "idWystawy", idWystawy);
        this.nazwaWystawy = new SimpleStringProperty(this, "nazwaWystawy", nazwaWystawy);
        this.sala = new SimpleStringProperty(this, "sala", sala);
        this.miejsceWykonania = new SimpleStringProperty(this, "miejsceWykonania", miejsceWykonania);
        this.tematyka = new SimpleStringProperty(this, "tematyka", tematyka);
        this.tworca = new SimpleStringProperty(this, "tworca", tworca);
        this.dataRozpoczecia = new SimpleObjectProperty<>(this, "dataRozpoczecia", dataRozpoczecia);
        this.dataZakonczenia = new SimpleObjectProperty<>(this, "dataZakonczenia", dataZakonczenia);
    }
    public IntegerProperty idWystawyProperty() {
        return idWystawy;
    }
    public StringProperty nazwaWystawyProperty() {
        return nazwaWystawy;
    }
    public StringProperty salaProperty() {
        return sala;
    }
    public StringProperty miejsceWykonaniaProperty() {
        return miejsceWykonania;
    }
    public StringProperty tematykaProperty() {
        return tematyka;
    }
    public StringProperty tworcaProperty() {
        return tworca;
    }
    public ObjectProperty<LocalDate> dataRozpoczeciaProperty() {
        return dataRozpoczecia;
    }
    public ObjectProperty<LocalDate> dataZakonczeniaProperty() {
        return dataZakonczenia;
    }
}
