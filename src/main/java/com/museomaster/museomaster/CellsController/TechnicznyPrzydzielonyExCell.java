package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TechnicznyPrzydzielonyExCell implements Initializable {


    public CheckBox check_przzeniesione;
    public Label id_zad;
    public Label nazwa_zabytku;
    public Label skad_przeniesc_zabytek;
    public Label dokad_przeniesc_zabytek;

    private final Exhibit exhibit;

    private ListView<Exhibit> listView;

    boolean permissionFlag=false;


    public TechnicznyPrzydzielonyExCell(Exhibit exhibit, ListView<Exhibit> listView) {
        this.exhibit = exhibit;
        this.listView = listView;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_zad.textProperty().bind(exhibit.idZabytkuProperty().asString());
        nazwa_zabytku.textProperty().bind(exhibit.nazwa_zabytku_tfProperty());
        skad_przeniesc_zabytek.textProperty().bind(exhibit.akt_miej_przech_tfProperty());
        dokad_przeniesc_zabytek.textProperty().bind(exhibit.docelowe_miej_przechProperty());

        check_przzeniesione.selectedProperty().addListener((observableValue, oldVal, newVal) -> {
                    permissionFlag=newVal;
                    if(permissionFlag){
                        Model.getInstance().checkExhibit(exhibit);
                    }
                    else{
                        Model.getInstance().uncheckWorker(exhibit);
                    }
                }
        );
    }
}
