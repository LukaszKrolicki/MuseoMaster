package com.museomaster.museomaster.TypyUzytkownikow.Administrator;

import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ResourceBundle;
import org.mindrot.jbcrypt.BCrypt;

public class AdminAddUser implements Initializable {
    public TextField name_input;
    public TextField second_name_input;
    public TextField email_input;
    public TextField phone_input;
    public TextField age_input;
    public ComboBox<String> role_comboBox;
    public TextField unique_name_input;
    public CheckBox permission_checkbox;
    public Button create_user_button;
    public Text error_lbl;
    public TextField haslo_input;
    public Label password_status_lbl;
    public ProgressBar password_progressBar;

    public boolean passwordFlag=false;
    private boolean permissionFlag;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        password_status_lbl.setText("Czy silne hasło: SŁABE NIE SPEŁNIA WYMAGAŃ");
        password_status_lbl.setTextFill(Color.RED);
        password_progressBar.setProgress(0.1);
        password_progressBar.setStyle("-fx-accent: red;");
        create_user_button.setOnAction(e->createUser());
        permission_checkbox.selectedProperty().addListener((observableValue, oldVal, newVal) -> permissionFlag=newVal
        );
        ObservableList<String> rolaList = FXCollections.observableArrayList(
                "Admin", "Pracownik", "Pracownik Techniczny", "Kurator"
        );
        role_comboBox.setItems(rolaList);
        name_input.textProperty().addListener((observable, oldValue, newValue) ->
                {
                    try {
                        createClientAddress();
                    } catch (StringIndexOutOfBoundsException ignored) {}
                }

        );
        second_name_input.textProperty().addListener((observable, oldValue, newValue) ->
                {
                    try {
                        createClientAddress();
                    } catch (StringIndexOutOfBoundsException ignored) {}
                }

        );

        haslo_input.textProperty().addListener((observable, oldValue, newValue) ->
                {
                    try {
                        checkPasswordSecurity();
                    } catch (StringIndexOutOfBoundsException ignored) {}
                }

        );
    }

    private void checkPasswordSecurity() {
        String password = haslo_input.getText();
        boolean hasMinLength = password.length() >= 8;
        boolean hasOverMinLength = password.length() > 10;
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");

        if (hasOverMinLength && hasNumber && hasSpecialChar) {
            password_status_lbl.setText("Czy silne hasło: JESZCZE LEPIEJ");
            password_status_lbl.setTextFill(Color.GREEN);
            password_progressBar.setProgress(1.0);
            password_progressBar.setStyle("-fx-accent: green;");
            passwordFlag = true;
        } else if (hasMinLength && hasNumber && hasSpecialChar) {
            password_status_lbl.setText("Czy silne hasło: TAK");
            password_status_lbl.setTextFill(Color.ORANGE);
            password_progressBar.setStyle("-fx-accent: orange;");
            password_progressBar.setProgress(0.5);
            passwordFlag = true;
        } else {
            password_status_lbl.setText("Czy silne hasło: SŁABE NIE SPEŁNIA WYMAGAŃ");
            password_status_lbl.setTextFill(Color.RED);
            password_progressBar.setStyle("-fx-accent: red;");
            password_progressBar.setProgress(0.1);
            passwordFlag = false;
        }
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
            if(passwordFlag) {

                String fname = name_input.getText();
                String fsecondName = second_name_input.getText();
                String femail = email_input.getText();
                Integer fphone = Integer.parseInt(phone_input.getText());
                Integer fage = Integer.parseInt(age_input.getText());
                String rola = role_comboBox.getValue();
                String fusername = unique_name_input.getText();
                Integer permission = 0;
                String fpassword = haslo_input.getText();

                if (permissionFlag) {
                    permission = 1;
                    if (rola.equals("Pracownik") || rola.equals("Pracownik Techniczny")) {
                        rola = rola.concat("+");
                    }

                }
                String hashedPassword = BCrypt.hashpw(fpassword, BCrypt.gensalt());

                Model.getInstance().getDataBaseDriver().createClient(fname, fsecondName, femail, fage, permission, rola, fphone, fusername, hashedPassword);
                emptyFields();
                error_lbl.setText("Użytkownik stworzony!");
                error_lbl.setFill(Color.GREEN);
            }
            else{
                error_lbl.setText("Za słabe hasło..");
            }
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
        role_comboBox.setValue(null);
        permission_checkbox.setSelected(false);
        permissionFlag=false;
        passwordFlag=false;
    }

}
