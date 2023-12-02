package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibition;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ExhibitionCell implements Initializable {
    private final Exhibition exhibition;
    public Label id_lbl;
    public Label ex_name_lbl;
    public Label author_lbl;
    public Label subject_lbl;
    public Label email_lbl;
    public Label start_date_lbl;
    public Label end_date_lbl;
    public Button delete_btn;
    public ListView<Exhibition> listView;

    public ExhibitionCell(Exhibition exhibition, ListView<Exhibition> listView) {
        this.exhibition = exhibition;
        this.listView = listView;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
