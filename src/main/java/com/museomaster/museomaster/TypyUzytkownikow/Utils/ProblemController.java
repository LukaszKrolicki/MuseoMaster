package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ProblemController implements Initializable {
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        report_btn.setOnAction(e-> Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("x"));
    }
}
