package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DodajZabytekController implements Initializable {
    public TextField nazwa_zabytku_tf;
    public TextField okres_powstawnia_tf;
    public TextField tematyka_tf;
    public TextField tworca_tf;
    public TextArea opis_ta;
    public Button dodaj_zabytek_btn;
    public Label error_lbl;
    public ChoiceBox<String> aktMiejscPrzech_cb;
    public ChoiceBox<String> docMiejscePrzech_cb;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dodaj_zabytek_btn.setOnAction(e -> createExhibit());
        initData();
        aktMiejscPrzech_cb.setItems(Model.getInstance().getAllRooms());
        docMiejscePrzech_cb.setItems(Model.getInstance().getAllRooms());
    }

    private void createExhibit(){
        try{
            String nazwa = nazwa_zabytku_tf.getText();
            Integer okres_pow = Integer.parseInt(okres_powstawnia_tf.getText());
            String tematyka = tematyka_tf.getText();
            String tworca = tworca_tf.getText();
            String akt_miejsce = aktMiejscPrzech_cb.getValue();
            String doc_miejsc_przech = docMiejscePrzech_cb.getValue();
            String opis = opis_ta.getText();

            Model.getInstance().getDataBaseDriver().createExhibit(nazwa, okres_pow, tematyka,  tworca, akt_miejsce, doc_miejsc_przech, opis);
            emptyFields();
            error_lbl.setText("Zabytek stworzony!");
            error_lbl.setTextFill(Color.GREEN);
            Model.getInstance().getExhibits().clear();
        } catch (Exception e){
            error_lbl.setText("Źle wypełniony formularz..");
            error_lbl.setTextFill(Color.RED);
        }
    }

    private void emptyFields(){
        nazwa_zabytku_tf.setText("");
        okres_powstawnia_tf.setText("");
        tematyka_tf.setText("");
        tworca_tf.setText("");
        aktMiejscPrzech_cb.setValue(null);
        docMiejscePrzech_cb.setValue(null);
        opis_ta.setText("");
    }
    private void initData(){
        Model.getInstance().clearAllRooms();
        Model.getInstance().setAllRooms();
    }
}
