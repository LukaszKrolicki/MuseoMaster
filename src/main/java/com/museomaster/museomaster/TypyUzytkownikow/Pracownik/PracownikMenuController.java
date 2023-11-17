package com.museomaster.museomaster.TypyUzytkownikow.Pracownik;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PracownikMenuController implements Initializable {
    public Label task_list_lbl;
    public Label logout_lbl;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task_list_lbl.setOnMouseClicked(e->Model.getInstance().getViewFactory().getWorkerSelectedMenuItem().set("X"));
        report_btn.setOnAction(e->Model.getInstance().getViewFactory().getWorkerSelectedMenuItem().set("report"));
        logout_lbl.setOnMouseClicked(e->onLogout());
    }

    private void onLogout(){
        Stage stage = (Stage) task_list_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();

    }
}
