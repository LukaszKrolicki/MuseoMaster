package com.museomaster.museomaster.TypyUzytkownikow.MuseumClient;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MuseumClientMenu implements Initializable {
    public Label ex_list;
    public Label logout_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logout_lbl.setOnMouseClicked(e->onLogout());
    }


    private void onLogout(){
        Stage stage = (Stage) logout_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setNormalClientLoginSuccess(false);
    }
}
