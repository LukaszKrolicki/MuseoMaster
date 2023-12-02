package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class WyszukiwanieZabytkowController implements Initializable {
    public TextField ex_name_lbl;
    public TextField author_lbl;
    public ComboBox subject_combobox;
    public ComboBox time_made_combobox;
    public TextField firs_year_input;
    public TextField second_year_input;
    public ChoiceBox<String> current_place_combobox;
    public Button search_btn;
    public Text error_lbl;
    public TextField tematyka_tf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> salaList = FXCollections.observableArrayList(
                "Sala1", "Sala2", "Sala3", "Sala4"
        );
        current_place_combobox.setItems(salaList);
        search_btn.setOnAction(e-> {
            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "searchEx")) {
                Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("wyborZabytkow");
            }
            else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "searchEx")){
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("wyborZabytkow");
            }
            else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "search_ex")){
                Model.getInstance().getSearchedExhibits().clear();
                if(Objects.equals(firs_year_input.getText(), "")){
                    firs_year_input.setText("10000");
                }
                if(Objects.equals(second_year_input.getText(), "")){
                    second_year_input.setText("10000");
                }
                Model.getInstance().setExhibitsSearched(ex_name_lbl.getText(), author_lbl.getText(), tematyka_tf.getText(), Integer.parseInt(firs_year_input.getText()), Integer.parseInt(second_year_input.getText()), current_place_combobox.getValue());
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("listaWyszukanychZab");
            }
        }
        );
    }
}
