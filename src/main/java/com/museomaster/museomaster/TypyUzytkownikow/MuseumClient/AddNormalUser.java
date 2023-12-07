package com.museomaster.museomaster.TypyUzytkownikow.MuseumClient;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNormalUser implements Initializable {
    public TextField username_txtfld;
    public TextField email_txtfld;
    public PasswordField password;
    public Button create_user_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().set_normal_user_err_label(error_lbl);

        create_user_btn.setOnAction(e -> {
            try {
            if(email_txtfld.getText().isBlank() || password.getText().isBlank() || username_txtfld.getText().isBlank()){
                error_lbl.setText("Nie udało się utworzyć użytkownika");
            }
            else {
                Model.getInstance().getDataBaseDriver().createNormalClient(email_txtfld.getText(), password.getText(), username_txtfld.getText());
                if(error_lbl.getText().isBlank()){
                    Model.getInstance().getViewFactory().closeStage((Stage)error_lbl.getScene().getWindow());
                }
            }
            }
            catch (Exception x) {
                    error_lbl.setText("Nie udało się utworzyć użytkownika");
                }
        });

    }


}

