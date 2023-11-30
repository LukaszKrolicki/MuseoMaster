package com.museomaster.museomaster.TypyUzytkownikow.PracownikUprawniony;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public Label lista_zadan_lbl;
    public Label przydziel_zadanie;
    public Label logout_lbl;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista_zadan_lbl.setOnMouseClicked(e->onMenuClick("x"));
        przydziel_zadanie.setOnMouseClicked(e->onMenuClick("assign"));
        logout_lbl.setOnMouseClicked(e->onLogout());
        report_btn.setOnMouseClicked(e->onMenuClick("report"));
    }

    private void onMenuClick(String setName){
        System.out.println("xdddd");
        Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set(setName);
    }

    private void onLogout(){
        Stage stage = (Stage) lista_zadan_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setClientLoginFlag(false);

    }
}
