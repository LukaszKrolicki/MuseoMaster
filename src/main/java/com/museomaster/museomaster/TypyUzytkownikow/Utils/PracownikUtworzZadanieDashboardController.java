package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PracownikUtworzZadanieDashboardController implements Initializable{
    public VBox przydziel_zadanie_btn;
    public TextField subject_lbl;
    public TextArea desc_textfield;
    public DatePicker stard_date_datePicker;
    public DatePicker end_date_datePicker;
    public Button ego_to_ex_btn;
    public Button give_task_btn;
    public Text Error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ego_to_ex_btn.setOnAction(e-> Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("searchEx"));
        give_task_btn.setOnAction(e-> Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("x"));
    }
}
