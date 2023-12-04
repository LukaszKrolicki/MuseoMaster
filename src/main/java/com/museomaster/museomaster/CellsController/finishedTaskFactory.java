package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Zadanie;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class finishedTaskFactory extends ListCell<Zadanie> {
    @Override
    protected void updateItem(Zadanie zadanie, boolean empty) {
        super.updateItem(zadanie, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader;
            zadanie.getStatus();
            if(zadanie.getStatus().equals("Zakonczone")){
                loader = new FXMLLoader(getClass().getResource("/Fxml/Pracownik/Cells/ZadanieZakonczoneSukcesem.fxml"));
                finishedTask controler = new finishedTask(getListView(),zadanie);
                loader.setController(controler);
            }else if(zadanie.getStatus().equals("Problem")){
                loader = new FXMLLoader(getClass().getResource("/Fxml/Pracownik/Cells/ZadanieZakończoneProblemem.fxml"));
                ProblemTask controler = new ProblemTask(getListView(),zadanie);
                loader.setController(controler);
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/Fxml/Pracownik/Cells/ZadanieNieZakończone.fxml"));
                failedTask controler = new failedTask(getListView(),zadanie);
                loader.setController(controler);
            }

            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}