package com.museomaster.museomaster.TypyUzytkownikow;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox rola_choiceBox;
    public TextField login_input;
    public TextField password_input;
    public Button login_button;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_button.setOnAction(e->Model.getInstance().getViewFactory().showAdminWindow());
    }
}
