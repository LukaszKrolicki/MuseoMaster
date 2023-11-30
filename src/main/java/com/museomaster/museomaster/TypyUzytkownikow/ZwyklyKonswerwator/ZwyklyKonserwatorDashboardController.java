package com.museomaster.museomaster.TypyUzytkownikow.ZwyklyKonswerwator;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ZwyklyKonserwatorDashboardController implements Initializable {
    public ListView active_task_list;
    public ListView tasks_done;
    public Label date_lb;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().addListener(
                ((observableValue, oldVal, newVal) ->{
                    switch(newVal){

                    }
                } )
        );
    }
}
