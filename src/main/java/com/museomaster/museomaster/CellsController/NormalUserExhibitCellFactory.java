package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibit;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class NormalUserExhibitCellFactory extends ListCell<Exhibit> {
    @Override
    protected void updateItem(Exhibit exhibit, boolean empty) {
        super.updateItem(exhibit, empty);
        if(empty) {
            setText(null);
            setGraphic(null);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/MuseumClient/Cells/ZabytekCell.fxml"));
            NormalUserExCell controller = new NormalUserExCell(exhibit, getListView());
            loader.setController(controller);
            setText(null);
            try{
                setGraphic(loader.load());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

