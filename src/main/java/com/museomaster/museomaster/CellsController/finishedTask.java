package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Zadanie;
import com.museomaster.museomaster.TypyUzytkownikow.Pracownik.PracownikDashboardThread;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class finishedTask implements Initializable {
    public Button zrobione_btn;
    public Label id_zadania;
    public Label user_name_lbl;
    public Label start_date_lbl;
    public Label end_date_lbl;
    private ListView<Zadanie> listView;
    private final Zadanie zadanie;

    public finishedTask(ListView<Zadanie> listView,Zadanie zadanie) {
        this.zadanie=zadanie;
        this.listView=listView;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_zadania.textProperty().bind(zadanie.idZadaniaProperty().asString());
        user_name_lbl.textProperty().bind(zadanie.nazwaUzytkownikaNadajacegoProperty());
        start_date_lbl.textProperty().bind(Bindings.concat("End:",zadanie.startDataProperty()));
        end_date_lbl.textProperty().bind(Bindings.concat("Start:",zadanie.endDataProperty()));
    }
}
