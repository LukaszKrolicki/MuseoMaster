package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Klasa obsługuje widok kuratora, reaguje na odpowiednie zdarzenia przekazane do Listenera,
 * który nasłuchuje na zmianę t.j. kliknięcie odpowiedniego przycisku itp.
 */
public class KuratorDashboardController implements Initializable {
    public BorderPane kurator_parent;

    /**
     * Metoda Initialize jest wymagana gdy implementujemy interfejs Initializable
     * @param url -> Lokalizacja używana do rozwiązywania ścieżek względnych dla obiektu root lub null, jeśli lokalizacja nie jest znana.
     * @param resourceBundle -> Zasoby użyte do zlokalizowania obiektu głównego lub null, jeśli obiekt główny nie został zlokalizowany.
     * Dodajemy Listener do getKuratorSelectedMenuItem, gdy zmieni wartość odnotujemy to i ospowiednio zareagujemy w switchu
     */
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
                        case "listaWyszukanychZab" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Utils/ListaWyszukanychEksponatow.fxml", "listaWyszukanychZab"));
                        case "report" -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Problem/ProblemDashboard.fxml", "report"));
                        default -> kurator_parent.setCenter(Model.getInstance().getViewFactory().showKuratorView("/Fxml/Kurator/KuratorDodajWystawe.fxml", "x"));
                    }
                } )
        );
    }
}
