package com.museomaster.museomaster.TypyUzytkownikow.MuseumClient;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailVerification implements Initializable {
    public Label error_lbl;
    public Button execute_btn;
    public TextField i1;
    public TextField i2;
    public TextField i3;
    public TextField i4;
    public TextField i5;
    public TextField i6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        // Add event listeners to the text fields
        i1.setOnKeyTyped(event -> handleTextFieldInput(event, i1, i2));
        i2.setOnKeyTyped(event -> handleTextFieldInput(event, i2, i3));
        i3.setOnKeyTyped(event -> handleTextFieldInput(event, i3, i4));
        i4.setOnKeyTyped(event -> handleTextFieldInput(event, i4, i5));
        i5.setOnKeyTyped(event -> handleTextFieldInput(event, i5, i6));
        i6.setOnKeyTyped(event -> handleTextFieldInput(event, i6, null));

        execute_btn.setOnAction(e->{
            String concatenatedCode = i1.getText() + i2.getText() + i3.getText() + i4.getText() + i5.getText() + i6.getText();

            if(concatenatedCode.equals(Model.getInstance().getValidationCode())){
                String hashedPassword = BCrypt.hashpw(Model.getInstance().getPass(), BCrypt.gensalt());
                Model.getInstance().getDataBaseDriver().createNormalClient(Model.getInstance().getEmail(), hashedPassword, Model.getInstance().getUsername());
                Model.getInstance().getViewFactory().showRegisterSuccesWindow();
                Model.getInstance().getViewFactory().closeStage((Stage) error_lbl.getScene().getWindow());
            }
            else{
                error_lbl.setText("Zły kod. Proszę spróbować jeszcze raz");
            }

        });

    }

    private void handleTextFieldInput(KeyEvent event, TextField currentTextField, TextField nextTextField) {
        // Get the typed character
        String input = event.getCharacter();

        // Allow only one character
        if (!input.isEmpty()) {
            currentTextField.setText(input);

            // Move focus to the next text field if available
            if (nextTextField != null) {
                nextTextField.requestFocus();
            }
        }

        // Consume the event to prevent further processing
        event.consume();
    }

    private void checkCode(){

    }
}

