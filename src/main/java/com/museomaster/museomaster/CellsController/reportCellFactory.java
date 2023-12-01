package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Report;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class reportCellFactory extends ListCell<Report> {
    @Override
    protected void updateItem(Report report, boolean empty) {
        super.updateItem(report, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Administrator/AdminCells/ReportCell.fxml"));
            reportCell controler = new reportCell(getListView(),report);
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