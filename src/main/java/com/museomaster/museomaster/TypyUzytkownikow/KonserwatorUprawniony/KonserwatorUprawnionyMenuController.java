package com.museomaster.museomaster.TypyUzytkownikow.KonserwatorUprawniony;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class KonserwatorUprawnionyMenuController implements Initializable {
    public Label task_lbl;
    public Label give_task_lbl;
    public Label lista_eksponatow;
    public Label logout_lbl;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task_lbl.setOnMouseClicked(e -> onMenuClick("x"));
        give_task_lbl.setOnMouseClicked(e -> onMenuClick("assign"));
        lista_eksponatow.setOnMouseClicked(e -> onMenuClick("lista_eksponatow"));
        logout_lbl.setOnMouseClicked(e->onLogout());
        report_btn.setOnMouseClicked(e->onMenuClick("report"));
    }

    private void onMenuClick(String setName){
        Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().set(setName);

    }

    private void onLogout(){
        Stage stage = (Stage) task_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setClientLoginFlag(false);
    }
}
