package com.museomaster.museomaster.TypyUzytkownikow.MuseumClient;

import com.museomaster.museomaster.CellsController.ExhibitCellFactory;
import com.museomaster.museomaster.CellsController.NormalUserExhibitCellFactory;
import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ExList implements Initializable {
    public ListView<Exhibit> ex_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        ex_list.setItems(Model.getInstance().getExhibits());
        ex_list.setCellFactory(e -> new NormalUserExhibitCellFactory());
    }

    private void initData(){
        if(Model.getInstance().getExhibits().isEmpty()){
            Model.getInstance().setExhibits();
        }
    }
}
