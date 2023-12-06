package com.museomaster.museomaster.TypyUzytkownikow.KonserwatorUprawniony;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class KonserwatorUprawniony implements Initializable {

    public BorderPane KonserwatorUprawnionyPanel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){
                        case "report"->KonserwatorUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionTechnicalWorkerView("/Fxml/Problem/ProblemDashboard.fxml", "report"));
                        case "lista_eksponatow" -> KonserwatorUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionTechnicalWorkerView("/Fxml/ZwyklyKonserwator/ListaPrzydzielonychZabytkow.fxml", "lista_eksponatow"));
                        case "searchEx" -> KonserwatorUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionTechnicalWorkerView("/Fxml/Utils/WyszukiwanieEksponatu.fxml", "searchEx"));
                        case "wyborZabytkow"->KonserwatorUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionTechnicalWorkerView("/Fxml/Utils/WyborZabytkowDlaZadania.fxml", "wyborZabytkow"));
                        case "assign"-> KonserwatorUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionTechnicalWorkerView("/Fxml/Utils/PracownikUprawnionyPrzydzielZadanie.fxml", "assign"));
                        case "giveTask"->{
                            KonserwatorUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionTechnicalWorkerView("/Fxml/Utils/PracownikUtworzZadanieDashboard.fxml", "giveTask"));
                        }
                        default -> {
                            KonserwatorUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionTechnicalWorkerView("/Fxml/Utils/PracownikUprawnionyDashboard.fxml", "x"));

                        }
                    }
                } )
        );
    }
}
