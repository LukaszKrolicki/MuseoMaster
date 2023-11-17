package com.museomaster.museomaster.TypyUzytkownikow.ZwyklyKonswerwator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ZwyklyKonserwator implements Initializable {
    public BorderPane PracownikTechnicznyPanel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getTechnicalWorkerSelectedMenuItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){
                        case "report"->PracownikTechnicznyPanel.setCenter(Model.getInstance().getViewFactory().showTechnicalWorkerView("/Fxml/Problem/ProblemDashboard.fxml", "report"));
                        case "taskList" ->PracownikTechnicznyPanel.setCenter(Model.getInstance().getViewFactory().showTechnicalWorkerView("/Fxml/Problem/ProblemDashboard.fxml", "taskList"));
                        default -> PracownikTechnicznyPanel.setCenter(Model.getInstance().getViewFactory().showTechnicalWorkerView("/Fxml/ZwyklyKonserwator/ZwyklyKonserwatorDashboard.fxml", "x"));
                    }
                } )
        );
    }
}
