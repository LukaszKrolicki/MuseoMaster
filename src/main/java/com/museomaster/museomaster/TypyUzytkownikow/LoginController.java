package com.museomaster.museomaster.TypyUzytkownikow;

import com.museomaster.museomaster.Enums.AccountType;
import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<String> rola_choiceBox;
    public TextField login_input;
    public TextField password_input;
    public Button login_button;
    public Label error_lbl;
    public Label addNormalUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_button.setOnAction(e->onLogin());
        Model.getInstance().getViewFactory().set_login_err_label(error_lbl);
        ObservableList<String> rolaList = FXCollections.observableArrayList(
                "Admin", "Pracownik", "Pracownik+", "Pracownik Techniczny", "Pracownik Techniczny+", "Kurator"
        );
        rola_choiceBox.setItems(rolaList);
        addNormalUser.setOnMouseClicked(e->Model.getInstance().getViewFactory().showCreateNormalUserWindow());
    }

    private void onLogin(){

        if(Objects.equals(rola_choiceBox.getValue(), "Admin")){
            if(checkCred("Admin")){
                Model.getInstance().getViewFactory().showAdminWindow();
            }
        }
        else if(Objects.equals(rola_choiceBox.getValue(), "Pracownik")){
            if(checkCred("Pracownik")){
                Model.getInstance().getViewFactory().showWorkerWindow();
            }
        }
        else if(Objects.equals(rola_choiceBox.getValue(), "Pracownik+")){
            if(checkCred("Pracownik+")){
                Model.getInstance().getViewFactory().showPermissionWorkerWindow();
            }
        }
        else if(Objects.equals(rola_choiceBox.getValue(), "Pracownik Techniczny")){
            if(checkCred("Pracownik Techniczny")){
                Model.getInstance().getViewFactory().showTechnicalWorkerWindow();
            }
        }
        else if(Objects.equals(rola_choiceBox.getValue(), "Pracownik Techniczny+")){
            if(checkCred("Pracownik Techniczny+")){
                Model.getInstance().getViewFactory().showPermissionTechnicalWorkerWindow();
            }
        }
        else if(Objects.equals(rola_choiceBox.getValue(), "Kurator")){
            if(checkCred("Kurator")){
                Model.getInstance().getViewFactory().showKuratorWindow();
            }
        }
        else{
            if(normalUser()){
                Model.getInstance().getViewFactory().showKuratorWindow();
            }
        }

    }

    private boolean checkCred(String rola){

        Model.getInstance().evaluateClient(login_input.getText(),password_input.getText(), rola_choiceBox.getValue());
        if(Model.getInstance().getClientLoginFlag()){
            Model.getInstance().getViewFactory().closeStage((Stage)error_lbl.getScene().getWindow());
            return true;
        }
        else{
            login_input.setText("");
            password_input.setText("");
            error_lbl.setTextFill(Color.RED);
            error_lbl.setText("Złe dane");
            return false;
        }

    }

    private boolean normalUser(){
        Model.getInstance().evaluateNormalUser(login_input.getText(),password_input.getText());
        if(Model.getInstance().getNornalClientLoginSuccess()){
            Model.getInstance().getViewFactory().closeStage((Stage)error_lbl.getScene().getWindow());
            return true;
        }
        else{
            login_input.setText("");
            password_input.setText("");
            error_lbl.setTextFill(Color.RED);
            error_lbl.setText("Złe dane");
            return false;
        }
    }
}
