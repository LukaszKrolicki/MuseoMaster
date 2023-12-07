package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class NormalUserExCell implements Initializable {
    private final Exhibit exhibit;

    public Label id_lbl;
    public Label author_lbl;
    public Button desc_btn;
    public Button play_btn;


    private ListView<Exhibit> listView;

    public NormalUserExCell(Exhibit exhibit, ListView<Exhibit> listView) {
        this.exhibit = exhibit;
        this.listView = listView;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_lbl.textProperty().bind(exhibit.nazwa_zabytku_tfProperty());
        author_lbl.textProperty().bind(exhibit.tworca_tfProperty());
        desc_btn.setOnAction(e->Model.getInstance().getViewFactory().showExDescWindow(exhibit));
    }

}