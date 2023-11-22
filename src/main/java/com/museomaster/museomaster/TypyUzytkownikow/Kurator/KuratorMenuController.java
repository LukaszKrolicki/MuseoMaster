package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class KuratorMenuController implements Initializable {
    public Label task_list_lbl;
    public Label task_add_lbl;
    public Label add_ex_lbl;
    public Label ex_list_lbl;
    public Label ad_ex_lbl;
    public Label search_ex_lbl;
    public Label logout_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task_list_lbl.setOnMouseClicked(e -> onMenuClick("task_list"));
        task_add_lbl.setOnMouseClicked(e -> onMenuClick("task_add"));
        add_ex_lbl.setOnMouseClicked(e -> onMenuClick("add_ex"));
        ex_list_lbl.setOnMouseClicked(e -> onMenuClick("ex_list"));
        ad_ex_lbl.setOnMouseClicked(e -> onMenuClick("ad_ex"));
        search_ex_lbl.setOnMouseClicked(e -> onMenuClick("search_ex"));
        logout_lbl.setOnMouseClicked(e->onLogout());
    }
    private void onMenuClick(String setName){
        Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set(setName);

    }

    private void onLogout(){
        Stage stage = (Stage) add_ex_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();

    }
}
