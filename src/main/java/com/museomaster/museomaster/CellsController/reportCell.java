package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Models.Report;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class reportCell implements Initializable {
    public Button delete_btn;
    public Button report_details_btn;
    public Label id_lbl;
    public Label username_lbl;
    private final Report report;

    private ListView<Report> listView;

    public reportCell(ListView<Report> listView,Report report) {

        this.report = report;
        this.listView=listView;

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_lbl.textProperty().bind(report.idPracownikaProperty().asString());
        username_lbl.textProperty().bind(report.nazwaUzytkownikaProperty());
        delete_btn.setOnAction(e->onDelete());
    }

    private void onDelete(){
        //Model.getInstance().getDataBaseDriver().deleteClient(Integer.parseInt(id_lbl.getText()));
        //listView.getItems().remove(client);
        listView.refresh();


    }
}


