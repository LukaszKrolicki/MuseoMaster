package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Models.Zadanie;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class inProgressTask implements Initializable {
    public Label id_zadania;
    public Label user_name_lbl;
    public Label start_date_lbl;
    public Label end_date_lbl;
    private ListView<Zadanie> listView;
    private final Zadanie zadanie;

    public inProgressTask(ListView<Zadanie> listView,Zadanie zadanie) {
        this.zadanie=zadanie;
        this.listView=listView;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_zadania.textProperty().bind(Bindings.concat("ID:",zadanie.idZadaniaProperty()));
        user_name_lbl.textProperty().bind(zadanie.nazwaUzytkownikaProperty());
        start_date_lbl.textProperty().bind(Bindings.concat("End:",zadanie.startDataProperty()));
        end_date_lbl.textProperty().bind(Bindings.concat("Start:",zadanie.endDataProperty()));
    }
}
