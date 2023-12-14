package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.CellsController.ExhibitCellFactory;
import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaZabytkowController implements Initializable {
    public ListView<Exhibit> ex_list;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        ex_list.setItems(Model.getInstance().getExhibits());
        ex_list.setCellFactory(e -> new ExhibitCellFactory());
    }
    private void initData(){
        Model.getInstance().clearExhibits();
        Model.getInstance().setExhibits();
    }
    public ListView<Exhibit> getEx_list() {
        return ex_list;
    }
}
