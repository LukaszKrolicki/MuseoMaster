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
        Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){
                        case "task_list" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/PracownikUprawnionyDashboard.fxml", "task_list"));
                        case "task_add" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/PracownikUprawnionyPrzydzielZadanie.fxml", "task_add"));
                        case "add_ex" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/KuratorDodajWystawe.fxml", "add_ex"));
                        case "ex_list" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/ListaWystaw.fxml", "ex_list"));
                        case "ad_ex" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/DodajZabytek.fxml", "ad_ex"));
                        case "search_ex" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/WyszukiwanieEksponatu.fxml", "search_ex"));
                        case "wyborZabytkow"->kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/WyborZabytkowDlaZadania.fxml", "wyborZabytkow"));
                        case "searchEx" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/WyszukiwanieEksponatu.fxml", "searchEx"));
                        case "lista_zabytkow" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/ListaZabytków.fxml", "lista_zabytkow"));
                        case "przydzielZadanie"-> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/PracownikUtworzZadanieDashboard.fxml", "przydzielZadanie"));
                        default -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/KuratorDodajWystawe.fxml", "x"));
                    }
                } )
        );
    }
}
