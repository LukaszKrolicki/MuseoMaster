package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Zadanie;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class failedTask implements Initializable {
    public Label task_id;
    public Label user_name_lbl;
    public Label start_date_lbl;
    public Label end_date_lbl;

    private ListView<Zadanie> listView;
    private final Zadanie zadanie;

    public failedTask(ListView<Zadanie> listView,Zadanie zadanie) {
        this.zadanie=zadanie;
        this.listView=listView;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task_id.textProperty().bind(Bindings.concat("ID:", zadanie.idZadaniaProperty().asString()));
        task_id.textProperty().bind(zadanie.idZadaniaProperty().asString());
        user_name_lbl.textProperty().bind(zadanie.nazwaUzytkownikaNadajacegoProperty());
        start_date_lbl.textProperty().bind(Bindings.concat("End:",zadanie.startDataProperty()));
        end_date_lbl.textProperty().bind(Bindings.concat("Start:",zadanie.endDataProperty()));
    }
}
