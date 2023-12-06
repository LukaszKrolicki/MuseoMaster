package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class WyborZabytkowController implements Initializable {
    public ListView lista_wybranych_zab;
    public ChoiceBox typ_zadania;
    public ChoiceBox sala_choice;
    public Button add_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_button.setOnAction(e-> {
            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "wyborZabytkow")){
                Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("x") ;
            }
            else if (Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "wyborZabytkow")){
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("task_list");
            }
            else if (Objects.equals(Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().get(), "wyborZabytkow")){
                Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().set("x");
            }
        }
        );
    }
}
