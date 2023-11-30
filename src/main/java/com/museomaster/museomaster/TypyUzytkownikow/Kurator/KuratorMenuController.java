package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * KOntroler Menu  Kuratora, reguje na naciśnięcie przycisku
 */
public class KuratorMenuController implements Initializable {
    //Opcje jakie ma dostępne kurator w menu z lewej sttorny, nazwa labelu jest jednocześnie jego id
    public Label task_list_lbl;
    public Label task_add_lbl;
    public Label add_ex_lbl;
    public Label ex_list_lbl;
    public Label ad_ex_lbl;
    public Label search_ex_lbl;
    public Label logout_lbl;
    public Label lista_zabytkow;

    /**
     * Podobnie jak w KuratorDashboard, metoda definiuje co ma się stać po naciśnięciu odpowiedniego Label'a
     * @param url -> Lokalizacja używana do rozwiązywania ścieżek względnych dla obiektu root lub null, jeśli lokalizacja nie jest znana.
     * @param resourceBundle -> Zasoby użyte do zlokalizowania obiektu głównego lub null, jeśli obiekt główny nie został zlokalizowany.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Gdy naciśnięty jest jeden z labeli
        task_list_lbl.setOnMouseClicked(e -> onMenuClick("task_list"));
        task_add_lbl.setOnMouseClicked(e -> onMenuClick("task_add"));
        add_ex_lbl.setOnMouseClicked(e -> onMenuClick("add_ex"));
        ex_list_lbl.setOnMouseClicked(e -> onMenuClick("ex_list"));
        ad_ex_lbl.setOnMouseClicked(e -> onMenuClick("ad_ex"));
        lista_zabytkow.setOnMouseClicked(e -> onMenuClick("lista_zabytkow"));
        search_ex_lbl.setOnMouseClicked(e -> onMenuClick("search_ex"));
        //Wylogowanie
        logout_lbl.setOnMouseClicked(e->onLogout());
    }

    /**
     * Metoda wywoływanan gdy naciśniemy na odpowiendi Label
     * @param setName -> Nazwa jednej z opcji, od której w switchu uzależniamy wyświetlany kontent
     */
    private void onMenuClick(String setName){
        Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set(setName);

    }

    /**
     * Definiujemy co ma się stać gdy nacieśniemy przycisk wylogowania
     */
    private void onLogout(){
        Stage stage = (Stage) add_ex_lbl.getScene().getWindow();
        //Zamykamy obecnie wyświetlane okno
        Model.getInstance().getViewFactory().closeStage(stage);
        //Podazujemy ekran logowania
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setClientLoginFlag(false);

    }
}
