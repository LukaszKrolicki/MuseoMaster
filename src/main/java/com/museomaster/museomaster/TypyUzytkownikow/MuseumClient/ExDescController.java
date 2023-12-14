package com.museomaster.museomaster.TypyUzytkownikow.MuseumClient;

import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ExDescController implements Initializable {
    public Label ExId_lbl;
    public Label ex_name_lbl;
    public Label ex_year_lbl;
    public Label ex_subject_lbl;
    public Label ex_author_lbl;
    public TextArea ex_desc_textArea;
    public Button close_btn;

    public Label current_place;
    public Label tarted_place;

    private Exhibit exhibit;
    public ExDescController(Exhibit exhibit) {
        this.exhibit = exhibit;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ex_name_lbl.setText("Nazwa eksponatu: "+exhibit.nazwa_zabytku_tfProperty().get());
        ex_author_lbl.setText("Autor: "+exhibit.tworca_tfProperty().get());
        ex_desc_textArea.setText(exhibit.opis_taProperty().get());
        ex_subject_lbl.setText("Temat: "+ exhibit.tematyka_tfProperty().get());
        ExId_lbl.setText("ID: "+ exhibit.idZabytkuProperty().get());
        ex_year_lbl.setText("Okres powstania: "+ exhibit.okres_powstawnia_tfProperty().get());
        close_btn.setOnAction(e-> Model.getInstance().getViewFactory().closeStage((Stage)close_btn.getScene().getWindow()));
        current_place.setText("Aktualne miejsce przechowywania: "+ exhibit.akt_miej_przech_tfProperty().get());
        tarted_place.setText("Docelowe miejsce przechowywania: "+ exhibit.docelowe_miej_przechProperty().get());
    }
}
