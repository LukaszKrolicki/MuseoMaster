package com.museomaster.museomaster.TypyUzytkownikow.Kurator;

import com.museomaster.museomaster.Models.Model;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Ta klasa jest odpowiedzialna za zarządzanie funkcją dodawania zabytków
 */
public class DodajZabytekController implements Initializable {
    // Pola zawarte w widoku użytkownika
    public TextField nazwa_zabytku_tf;
    public TextField okres_powstawnia_tf;
    public TextField tematyka_tf;
    public TextField tworca_tf;
    public TextArea opis_ta;
    public Button dodaj_zabytek_btn;
    public Label error_lbl;
    public Label filePath;
    public Button mp3Button;
    public ChoiceBox<String> aktMiejscPrzech_cb;
    public ChoiceBox<String> docMiejscePrzech_cb;
    File selectedFile = null;

    /**
     * Funckja initialize jest odpowiedizlana za inicjalizację wyświetlanie danych
     * oraz za obsługiwanie zdarzeń związanych z przyciskami itp.
     * @param url -> Lokalizacja używana do rozwiązywania ścieżek względnych dla obiektu root lub null, jeśli lokalizacja nie jest znana.
     * @param resourceBundle -> Zasoby użyte do zlokalizowania obiektu głównego lub null, jeśli obiekt główny nie został zlokalizowany.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dodaj_zabytek_btn.setOnAction(e -> {
            createExhibit();
            saveMusicFile();
        });
        mp3Button.setOnAction(e -> openMusicFile()); // po naciśnięciu otwiera się okno do wyboru pliku muzycznego
        initData();
        aktMiejscPrzech_cb.setItems(Model.getInstance().getAllRooms()); // wypełniamy listę aktualnych miejsc miejscami z bazy danych
        docMiejscePrzech_cb.setItems(Model.getInstance().getAllRooms()); // wypełniamy listę docelowych miejsc miejscami z bazy danych
    }

    /**
     * Funckja odpowiedzialna za tworzenie zabyytku
     */
    private void createExhibit(){
        try{
            String nazwa = nazwa_zabytku_tf.getText();
            Integer okres_pow = Integer.parseInt(okres_powstawnia_tf.getText());
            String tematyka = tematyka_tf.getText();
            String tworca = tworca_tf.getText();
            String akt_miejsce = aktMiejscPrzech_cb.getValue();
            String doc_miejsc_przech = docMiejscePrzech_cb.getValue();
            String opis = opis_ta.getText();

            Model.getInstance().getDataBaseDriver().createExhibit(nazwa, okres_pow, tematyka,  tworca, akt_miejsce, doc_miejsc_przech, opis); //tworzenie zabytku
            emptyFields(); //czyszczenie pól
            error_lbl.setText("Zabytek stworzony!");    // poinformowanie użytkownika o pomyślnym utworzeniu zbaytku
            error_lbl.setTextFill(Color.GREEN);
            Model.getInstance().getExhibits().clear();  // czyszczenie listy zabytków aby wymusić aktualizację listy
        } catch (Exception e){
            error_lbl.setText("Źle wypełniony formularz.."); // poinformowanie użytkownika o błędzie przy utworzeniu zbaytku
            error_lbl.setTextFill(Color.RED);
        }
    }

    /**
     * Funkcja odpowiedzialna za czyszczenie miejsc po utworzeniu zabytku
     */
    private void emptyFields(){
        nazwa_zabytku_tf.setText("");
        okres_powstawnia_tf.setText("");
        tematyka_tf.setText("");
        tworca_tf.setText("");
        aktMiejscPrzech_cb.setValue(null);
        docMiejscePrzech_cb.setValue(null);
        opis_ta.setText("");
    }

    /**
     * Funckja odpoweidzialna za wybór pliku muzycznego z komputera
     */
    private void openMusicFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Music Files", "*.mp3", "*.wav", "*.flac"));

        // Set initial directory (optional)
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        Stage stage = new Stage();
        selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            filePath.setText("Selected Music File: " + selectedFile.getAbsolutePath());
        }
    }

    /**
     * Ta funckja jest odpowiedzialna za zapis pliku muzycznego do bazy danych
     */
    private void saveMusicFile() {
        if (selectedFile != null) {
            Model.getInstance().getDataBaseDriver().createMusicFile(selectedFile);
        }
    }

    /**
     * Funkcja służąca do aktualizacji listy wszystkich pomieszczeń
     */
    private void initData(){
        Model.getInstance().clearAllRooms(); // czyścimy listę wszystkich pomieszczeń na wypadek gdyby jakieś dodano
        Model.getInstance().setAllRooms();  //wybieramy wszytskie dostępne pomieszczenia z bazy
    }
}
