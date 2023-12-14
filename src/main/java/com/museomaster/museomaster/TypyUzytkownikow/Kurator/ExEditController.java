package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

public class ExEditController implements Initializable {
    public Label ex_name_lbl;
    public TextField ex_name_tf;
    public Label ex_year_lbl;
    public TextField ed_okres_pow_tf;
    public Label ex_subject_lbl;
    public TextField tematyka_tf;
    public Label ex_author_lbl;
    public TextField tworca_tf;
    public Label current_place;
    public ChoiceBox<String> aktual_cb;
    public Label tarted_place;
    public ChoiceBox<String> docel_cb;
    public TextArea ex_desc_textArea;
    public Button edit_btn;
    public Label error_lbl;
    private Exhibit exhibit;

    public ExEditController(Exhibit exhibit){
        this.exhibit = exhibit;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        ex_name_tf.setText(this.exhibit.nazwa_zabytku_tfProperty().get());
        ed_okres_pow_tf.setText(this.exhibit.okres_powstawnia_tfProperty().get());
        tematyka_tf.setText(this.exhibit.tematyka_tfProperty().get());
        tworca_tf.setText(this.exhibit.tworca_tfProperty().get());
        aktual_cb.setItems(Model.getInstance().getAllRooms());
        aktual_cb.setValue(this.exhibit.akt_miej_przech_tfProperty().get());
        docel_cb.setItems(Model.getInstance().getAllRooms());
        docel_cb.setValue(this.exhibit.docelowe_miej_przechProperty().get());
        ex_desc_textArea.setText(exhibit.opis_taProperty().get());
        edit_btn.setOnAction(e -> {
            editExhibit();
        });
    }
    public void initData(){
        Model.getInstance().clearAllRooms();
        Model.getInstance().setAllRooms();
    }

    public void editExhibit(){
        try {
            Model.getInstance().getDataBaseDriver().editExhibit(
                    this.exhibit.idZabytkuProperty().get(),
                    ex_name_tf.getText(),
                    Integer.parseInt(ed_okres_pow_tf.getText()),
                    tematyka_tf.getText(),
                    tworca_tf.getText(),
                    aktual_cb.getValue(),
                    docel_cb.getValue(),
                    ex_desc_textArea.getText()
            );
            error_lbl.setText("Zabytek zaktualizowany!");    // poinformowanie użytkownika o pomyślnym utworzeniu zbaytku
            error_lbl.setTextFill(Color.GREEN);
        } catch(Exception e){
            error_lbl.setText("Źle wypełniony formularz..");    // poinformowanie użytkownika o pomyślnym utworzeniu zbaytku
            error_lbl.setTextFill(Color.RED);
        }
    }

}
