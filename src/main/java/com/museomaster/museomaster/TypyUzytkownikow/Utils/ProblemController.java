package com.museomaster.museomaster.TypyUzytkownikow.Utils;

import com.museomaster.museomaster.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ProblemController implements Initializable {
    public Button report_btn;
    public TextArea report_text;
    public Label rr_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        report_btn.setOnAction(e->onReportCreate());
    }

    private void onReportCreate(){
        try {
            String opis = report_text.getText();
            if(!opis.isBlank()){
                Model.getInstance().getDataBaseDriver().createReport(opis,Model.getInstance().getClient().getIdPracownika(), Model.getInstance().getClient().getNazwaUzytkownika());
                report_text.setText("");
                rr_lbl.setText("Dziękujemy za powiadomienie o problemie!");
                rr_lbl.setTextFill(Color.GREEN);
            }
            else{
                rr_lbl.setText("Źle wypełniony formularz..");
            }

        } catch (NumberFormatException ex) {
            rr_lbl.setText("Źle wypełniony formularz..");
            rr_lbl.setTextFill(Color.RED);
        }
    }
}
