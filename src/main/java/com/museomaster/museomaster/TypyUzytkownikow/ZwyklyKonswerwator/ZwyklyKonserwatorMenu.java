package com.museomaster.museomaster.TypyUzytkownikow.ZwyklyKonswerwator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ZwyklyKonserwatorMenu implements Initializable {
    public Label lista_zadan_lbl;
    public Label logout_lbl;
    public Button report_btn;
    public Label lista_eksponatow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista_eksponatow.setOnMouseClicked(e->onMenuClick("taskList"));
        report_btn.setOnMouseClicked(e->onMenuClick("report"));
        lista_zadan_lbl.setOnMouseClicked(e->onMenuClick("x"));
        logout_lbl.setOnMouseClicked(e->onLogout());
    }

    private void onMenuClick(String setName){
        Model.getInstance().getViewFactory().getTechnicalWorkerSelectedMenuItem().set(setName);

    }

    private void onLogout(){
        Stage stage = (Stage) lista_zadan_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();

    }
}

