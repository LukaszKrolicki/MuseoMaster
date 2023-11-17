package com.museomaster.museomaster.TypyUzytkownikow.Pracownik;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PracownikController implements Initializable {

    public BorderPane PracownikPanel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getWorkerSelectedMenuItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){
                        case "report"->PracownikPanel.setCenter(Model.getInstance().getViewFactory().showReportView());
                        default -> PracownikPanel.setCenter(Model.getInstance().getViewFactory().showWorkerDashboardView());
                    }
                } )
        );
    }
}
