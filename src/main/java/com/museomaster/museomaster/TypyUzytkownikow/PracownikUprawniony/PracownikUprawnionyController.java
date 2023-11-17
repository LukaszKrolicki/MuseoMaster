package com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PracownikUprawnionyController implements Initializable {
    public BorderPane PracownikUprawnionyPanel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){
                        case "searchEx" -> PracownikUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionWorkerView("/Fxml/Utils/WyszukiwanieEksponatu.fxml", "searchEx"));
                        case "report"->PracownikUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionWorkerView("/Fxml/Problem/ProblemDashboard.fxml", "report"));
                        case "wyborZabytkow"->PracownikUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionWorkerView("/Fxml/Utils/WyborZabytkowDlaZadania.fxml", "wyborZabytkow"));
                        case "assign"-> PracownikUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionWorkerView("/Fxml/Utils/PracownikUprawnionyPrzydzielZadanie.fxml", "assign"));
                        case "giveTask"->{

                            PracownikUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionWorkerView("/Fxml/Utils/PracownikUtworzZadanieDashboard.fxml", "giveTask"));
                        }

                        case ""->{

                        }

                        default -> {
                            PracownikUprawnionyPanel.setCenter(Model.getInstance().getViewFactory().showPermissionWorkerView("/Fxml/Utils/PracownikUprawnionyDashboard.fxml", "x"));

                        }
                    }
                } )
        );
    }
}
