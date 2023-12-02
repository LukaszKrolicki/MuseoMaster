package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibition;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class ExhibitionCellFactory extends ListCell<Exhibition> {
    @Override
    protected void updateItem(Exhibition exhibition, boolean empty) {
        super.updateItem(exhibition, empty);
        if(empty) {
            setText(null);
            setGraphic(null);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Kurator/Cells/WystawaCell.fxml"));
            ExhibitionCell controller = new ExhibitionCell(exhibition, getListView());
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
