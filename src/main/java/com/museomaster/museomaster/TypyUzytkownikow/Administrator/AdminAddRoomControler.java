package com.museomaster.museomaster.TypyUzytkownikow.Administrator;

import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddRoomControler implements Initializable {
    public TextField room_name_input;
    public TextField room_size_input;
    public ChoiceBox<String> room_type_checkbox;
    public Button create_room_button;
    public Label error_lbl;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_room_button.setOnAction(e->createRoom());
        ObservableList<String> rolaList = FXCollections.observableArrayList(
                "P.wystawowe", "P.magazynujące"
        );
        room_type_checkbox.setItems(rolaList);
    }

    private void createRoom(){
        try {
            Integer fsize = Integer.parseInt(room_size_input.getText());
            String fname = room_name_input.getText();
            String type = room_type_checkbox.getValue();
            Model.getInstance().getDataBaseDriver().createRoom(fsize, fname, type);
            empty();
            error_lbl.setText("Stworzono pomieszczenie!");
            error_lbl.setTextFill(Color.GREEN);
        } catch (NumberFormatException ex) {
            error_lbl.setText("Źle wypełniony formularz..");
            error_lbl.setTextFill(Color.RED);
        }
    }


    private void empty(){
        room_name_input.setText("");
        room_size_input.setText("");
        room_type_checkbox.setValue(null);
    }
}
