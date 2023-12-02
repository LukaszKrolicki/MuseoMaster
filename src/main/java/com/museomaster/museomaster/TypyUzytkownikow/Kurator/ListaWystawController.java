package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.CellsController.ExhibitCellFactory;
import com.museomaster.museomaster.CellsController.ExhibitionCellFactory;
import com.museomaster.museomaster.Models.Exhibition;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaWystawController implements Initializable {
    public ListView<Exhibition> exhibition_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        exhibition_list.setItems(Model.getInstance().getExhibitions());
        exhibition_list.setCellFactory(e -> new ExhibitionCellFactory());
    }
    private void initData(){
        if(Model.getInstance().getExhibitions().isEmpty()){
            Model.getInstance().setExhibitions();
        }
    }
}
