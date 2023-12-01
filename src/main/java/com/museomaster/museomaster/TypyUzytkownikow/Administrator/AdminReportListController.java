package com.museomaster.museomaster.TypyUzytkownikow.Administrator;

import com.museomaster.museomaster.CellsController.reportCellFactory;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Models.Report;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminReportListController implements Initializable {
    public ListView<Report> report_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        report_list.setItems(Model.getInstance().getReports());
        report_list.setCellFactory(e->new reportCellFactory());
    }

    private void initData(){
        if(Model.getInstance().getReports().isEmpty()){
            Model.getInstance().setReports();
        }
    }
}
