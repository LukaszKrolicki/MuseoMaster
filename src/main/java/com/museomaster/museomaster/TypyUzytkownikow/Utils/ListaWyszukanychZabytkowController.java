package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.CellsController.ExhibitCellFactory;
import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaWyszukanychZabytkowController implements Initializable {
    public ListView<Exhibit> exhibits_list;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exhibits_list.setItems(Model.getInstance().getSearchedExhibits());
        exhibits_list.setCellFactory(e -> new ExhibitCellFactory());
    }

}
