package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Model;
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
    public ChoiceBox current_place_combobox;
    public Button search_btn;
    public Text error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        search_btn.setOnAction(e-> {
            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "searchEx")) {
                Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("wyborZabytkow");
            }
            else if(Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "searchEx")){
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("wyborZabytkow");
            }
                }
        );
    }
}
