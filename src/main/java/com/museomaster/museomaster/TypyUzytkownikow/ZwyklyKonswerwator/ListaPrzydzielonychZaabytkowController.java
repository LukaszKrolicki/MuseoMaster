package com.museomaster.museomaster.TypyUzytkownikow.ZwyklyKonswerwator;

import com.museomaster.museomaster.CellsController.TechnicznyPrydzieloneFactory;
import com.museomaster.museomaster.CellsController.UserCellFactory;
import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import com.museomaster.museomaster.Models.Zadanie;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListaPrzydzielonychZaabytkowController implements Initializable {
    public ListView<Exhibit> lista_przydziel_zab;
    public Button zatwierdz_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            InitData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        lista_przydziel_zab.setItems(Model.getInstance().getExhibitsAssigned());
        lista_przydziel_zab.setCellFactory(e->new TechnicznyPrydzieloneFactory());

        zatwierdz_btn.setOnAction(e->{
            for(Exhibit ex : Model.getInstance().getExChecked()){
                System.out.println(ex);
                Model.getInstance().getDataBaseDriver().UpdateExPlaceAndStatu("", ex.getDocelowe_miej_przech(), ex.idZabytkuProperty().get());
                Model.getInstance().getDataBaseDriver().deleteEx_Task(ex.getIdZadEx());
                ex.setChecked(false);
            }
            try {
                InitData();
            } catch (SQLException x) {
                throw new RuntimeException(x);
            }

        });

    }

    public void InitData() throws SQLException {
        Model.getInstance().clearExAssigned();
        Model.getInstance().clearCheckedEx();
        Model.getInstance().clearExIds();
        Model.getInstance().setExIds();
        Model.getInstance().setExModel();
    }
}
