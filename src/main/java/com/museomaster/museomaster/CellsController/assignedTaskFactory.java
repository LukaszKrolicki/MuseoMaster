package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Report;
import com.museomaster.museomaster.Models.Zadanie;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class assignedTaskFactory extends ListCell<Zadanie> {
    @Override
    protected void updateItem(Zadanie zadanie, boolean empty) {
        super.updateItem(zadanie, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Pracownik/Cells/ZadanieCell.fxml"));
            assignedTask controler = new assignedTask(getListView(),zadanie);
            loader.setController(controler);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}