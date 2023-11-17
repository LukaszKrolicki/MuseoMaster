package com.museomaster.museomaster.TypyUzytkownikow.Administrator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Label create_user_lbl;
    public Label add_place_lbl;
    public Label user_list_lbl;
    public Label error_raports_lbl;
    public Label logout_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_user_lbl.setOnMouseClicked(e->onMenuClick("create_user"));
        add_place_lbl.setOnMouseClicked(e->onMenuClick("add_place"));
        user_list_lbl.setOnMouseClicked(e->onMenuClick("user_list"));
        error_raports_lbl.setOnMouseClicked(e->onMenuClick("error_raports"));
        logout_lbl.setOnMouseClicked(e->onLogout());
    }

    private void onMenuClick(String setName){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(setName);

    }

    private void onLogout(){
        Stage stage = (Stage) create_user_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();

    }
}
