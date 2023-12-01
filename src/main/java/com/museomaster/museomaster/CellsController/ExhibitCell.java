package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibit;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ExhibitCell implements Initializable {
    private final Exhibit exhibit;
    public Label id_zab;
    public Label nazwa_zab;
    public Label tematyka_zab;
    public Button usun_btn;


    public ExhibitCell(Exhibit exhibit) {
        this.exhibit = exhibit;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_zab.textProperty().bind(exhibit.idZabytkuProperty().asString());
        nazwa_zab.textProperty().bind(exhibit.nazwa_zabytku_tfProperty());
        tematyka_zab.textProperty().bind(exhibit.tematyka_tfProperty());
    }
}
