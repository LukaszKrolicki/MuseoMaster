package com.museomaster.museomaster.TypyUzytkownikow.Administrator;

import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddUser implements Initializable {
    public TextField name_input;
    public TextField second_name_input;
    public TextField email_input;
    public TextField phone_input;
    public TextField age_input;
    public ComboBox role_comboBox;
    public TextField unique_name_input;
    public CheckBox permission_checkbox;
    public Button create_user_button;
    public Text error_lbl;
    public TextField haslo_input;


    private boolean permissionFlag;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_user_button.setOnAction(e->createUser());
        permission_checkbox.selectedProperty().addListener((observableValue, oldVal, newVal) -> {
                    permissionFlag=newVal;
                }
        );
        ObservableList<String> rolaList = FXCollections.observableArrayList(
                "Admin", "Pracownik", "Pracownik Techniczny", "Kurator"
        );

        name_input.textProperty().addListener((observable, oldValue, newValue) -> {
            createClientAddress();
        });

        second_name_input.textProperty().addListener((observable, oldValue, newValue) -> {
            createClientAddress();
        });
        role_comboBox.setItems(rolaList);
    }

    private void createClientAddress(){
        char fchar = Character.toLowerCase(name_input.getText().charAt(0));
        int min = 1; // Minimum value of range
        int max = 200; // Maximum value of range
        int x = (int)Math.floor(Math.random() * (max - min + 1) + min);
        unique_name_input.setText("@"+fchar+second_name_input.getText()+x);
    }

    private void createUser(){
        try {
            String fname = name_input.getText();
            String fsecondName = second_name_input.getText();
            String femail = email_input.getText();
            Integer fphone = Integer.parseInt(phone_input.getText());
            Integer fage = Integer.parseInt(age_input.getText());
            String rola = role_comboBox.getValue().toString();
            String fusername = unique_name_input.getText();
            Integer permission = 0;
            String fpassword = haslo_input.getText();

            if(permissionFlag){
                permission = 1;
                if(rola.equals("Pracownik") ||rola.equals("Pracownik Techniczny")){
                    rola=rola.concat("+");
                }

            }

            Model.getInstance().getDataBaseDriver().createClient(fname,fsecondName,femail,fage,permission,rola,fphone,fusername,fpassword);
            emptyFields();
            error_lbl.setText("Użytkownik stworzony!");
            error_lbl.setFill(Color.GREEN);
        }catch (Exception e){
            error_lbl.setText("Źle wypełniony formularz..");
            error_lbl.setFill(Color.RED);
        }


    }
    private void emptyFields(){
        name_input.setText("");
        second_name_input.setText("");
        email_input.setText("");
        phone_input.setText("");
        age_input.setText("");
        unique_name_input.setText("");
        haslo_input.setText("");
    }

}
