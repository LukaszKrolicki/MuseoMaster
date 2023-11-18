package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class KuratorDashboardController implements Initializable {
    public BorderPane kurator_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){
                        case "task_list" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/PracownikUprawnionyDashboard.fxml", "task_list"));
                        case "task_add" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/PracownikUtworzZadanieDashboard.fxml", "task_add"));
                        case "add_ex" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/KuratorDodajWystawe.fxml", "add_ex"));
                        case "ex_list" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/ListaWystaw.fxml", "ex_list"));
                        case "ad_ex" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/DodajZabytek.fxml", "ad_ex"));
                        case "search_ex" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/WyszukiwanieEksponatu.fxml", "search_ex"));
                        default -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Administrator/KuratowDodajWystawe.fxml", "x"));
                    }
                } )
        );
    }
}
