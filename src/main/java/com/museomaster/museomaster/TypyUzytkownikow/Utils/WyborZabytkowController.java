package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.CellsController.WyborZabytkuCellFactory;
import com.museomaster.museomaster.CellsController.reportCellFactory;
import com.museomaster.museomaster.Models.Client;
import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class WyborZabytkowController implements Initializable {
    public ListView<Exhibit> lista_wybranych_zab;
    public ChoiceBox typ_zadania;
    public ChoiceBox sala_choice;
    public Button add_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        add_button.setOnAction(e-> {
            String nazwa;
            for(Client client : Model.getInstance().getWorkersAssigned()){
                nazwa=Model.getInstance().getClient().getNazwaUzytkownika();
                Model.getInstance().createTask(client.getIdPracownika(),client.getNazwaUzytkownika(),nazwa);
                for(Exhibit ex : Model.getInstance().getExAssigned()){
                    Integer ex_id=ex.idZabytkuProperty().getValue();
                    Integer worker_id=client.getIdPracownika();
                    Model.getInstance().getDataBaseDriver().createEksponatZadanie(worker_id,ex_id);
                }
            }

            for(Exhibit ex : Model.getInstance().getExAssigned()){
                Model.getInstance().getDataBaseDriver().UpdateEx(typ_zadania.getValue().toString(),sala_choice.getValue().toString(),ex.idZabytkuProperty().getValue());
            }


            if(Objects.equals(Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().get(), "wyborZabytkow")){
                Model.getInstance().getViewFactory().getPermissionWorkerSelectedMenuItem().set("x") ;
            }
            else if (Objects.equals(Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().get(), "wyborZabytkow")){
                Model.getInstance().getViewFactory().getKuratorSelectedMenuItem().set("task_list");
            }
            else if (Objects.equals(Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().get(), "wyborZabytkow")){
                Model.getInstance().getViewFactory().getPermTechnicalWorkerItem().set("x");
            }
        }

        );

        System.out.println(Model.getInstance().getExhibits());
        lista_wybranych_zab.setItems(Model.getInstance().getSearchedExhibits());
        lista_wybranych_zab.setCellFactory(e->new WyborZabytkuCellFactory());

        ObservableList<String> rolaList = FXCollections.observableArrayList(
                "Przenieś"
        );

        typ_zadania.setValue("Przenieś");
        sala_choice.setItems(Model.getInstance().getAllRooms());
    }

    private void initData(){
        Model.getInstance().clearEx();
        Model.getInstance().clearAllRooms();
        Model.getInstance().setAllRooms();
    }
}
