package com.museomaster.museomaster.TypyUzytkownikow;

import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        login_button.setOnAction(e->onLogin());
        ObservableList<String> rolaList = FXCollections.observableArrayList(
                "Admin", "Pracownik", "Pracownik+", "Pracownik Techniczny", "Kurator"
        );
        rola_choiceBox.setItems(rolaList);
    }

    private void onLogin(){
        Stage stage = (Stage)error_lbl.getScene().getWindow();


        if(rola_choiceBox.getValue()=="Admin"){
            Model.getInstance().evaluateClient(login_input.getText(),password_input.getText(),rola_choiceBox.getValue().toString());
            if(Model.getInstance().getClientLoginFlag()){
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }
            else{
                error_lbl.setText("Złe dane");
            }

        }
        else if(rola_choiceBox.getValue()=="Pracownik"){
            Model.getInstance().getViewFactory().showWorkerWindow();
        }
        else if(rola_choiceBox.getValue()=="Pracownik+"){
            Model.getInstance().getViewFactory().showPermissionWorkerWindow();
        }
        else if(rola_choiceBox.getValue()=="Pracownik Techniczny"){
            Model.getInstance().getViewFactory().showTechnicalWorkerWindow();
        }
        else if(rola_choiceBox.getValue()=="Kurator"){
            Model.getInstance().getViewFactory().showKuratorWindow();
        }


    }
}
