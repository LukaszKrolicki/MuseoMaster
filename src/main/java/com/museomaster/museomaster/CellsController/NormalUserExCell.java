package com.museomaster.museomaster.CellsController;

import com.museomaster.museomaster.Models.Exhibit;
import com.museomaster.museomaster.Models.Model;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class NormalUserExCell implements Initializable {
    private final Exhibit exhibit;

    public Label id_lbl;
    public Label author_lbl;
    public Button desc_btn;
    public Button play_btn;

    @FXML
    public FontAwesomeIconView playFont2;
    private ListView<Exhibit> listView;

    private String currentIconName;
    private String currentColor;
    private MediaPlayer mediaPlayer = null;

    private Thread thread=null;



    public NormalUserExCell(Exhibit exhibit, ListView<Exhibit> listView) {
        this.exhibit = exhibit;
        this.listView = listView;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_lbl.textProperty().bind(exhibit.nazwa_zabytku_tfProperty());
        author_lbl.textProperty().bind(exhibit.tworca_tfProperty());

        desc_btn.setOnAction(e->Model.getInstance().getViewFactory().showExDescWindow(exhibit));
        currentIconName = exhibit.getNormalExListIcon();
        playFont2.setGlyphName(currentIconName);
        currentColor=exhibit.getNormalExListColor();
        play_btn.setStyle("-fx-background-color: "+currentColor);
        mediaPlayer=exhibit.getNormalExListMedia();
        thread=exhibit.getNormalExListThread();

        play_btn.setOnAction(e->{
            String iconName = playFont2.getGlyphName();
            if (currentIconName.equals("STOP") && Model.getInstance().getPlayAudioFlag()==0){

                    Model.getInstance().setPlayAudioFlag(1);

            }

            if (currentIconName.equals("STOP") && Model.getInstance().getPlayAudioFlag()==1){
                    System.out.println(thread);
                        thread = new Thread(() -> {

                                try {
                                    exhibit.setNormalExListThread(thread);
                                    DownloadState();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                            while (!thread.isInterrupted()) {
                                if(Model.getInstance().getPlayAudioFlag()==1){
                                    try {
                                        NormalState();
                                    }
                                    catch (Exception ignored){

                                    }
                                }
                            }


                        });
                        thread.start();

            }
            else if(currentIconName.equals("PLAY_CIRCLE")){
                NormalState();
            }

        });
    }
    public void DownloadState() throws SQLException, IOException {
        playFont2.setGlyphName("HOURGLASS");
        currentIconName = "HOURGLASS";
        exhibit.setNormalExListIcon(currentIconName);
        play_btn.setStyle("-fx-background-color: #FF9734FF;");
        exhibit.setNormalExListColor("#FF9734FF");
        System.out.println(exhibit.idZabytkuProperty().get());
        if(Model.getInstance().getDataBaseDriver().getMusicFile(exhibit.idZabytkuProperty().get())){
            PlayState();
        }
        else{
            ErrorState();
        };
    }

    public void PlayState(){
        Model.getInstance().setPlayAudioFlag(0);
        playFont2.setGlyphName("PLAY_CIRCLE");
        currentIconName = "PLAY_CIRCLE";
        exhibit.setNormalExListIcon(currentIconName);
        play_btn.setStyle("-fx-background-color: #13FF00FF;");
        exhibit.setNormalExListColor("#13FF00FF");

        // Get the path to the MP3 music file
        String musicFilePath = "src/main/resources/pobrane/pobrane.mp3";

            // Create a Media object with the music file path
            Media media = new Media(new File(musicFilePath).toURI().toString());

            // Create a MediaPlayer object with the Media object
            mediaPlayer = new MediaPlayer(media);
            exhibit.setNormalExListMedia(mediaPlayer);
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.dispose();
                Model.getInstance().setPlayAudioFlag(1);
                System.out.println("Zagrane i zastopowane");
                exhibit.setNormalExListThread(thread);
                thread.interrupt();

            });

            try {
                Platform.runLater(() -> {
                    mediaPlayer.play();
                    System.out.println(thread);;
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        ;

    }

    public void ErrorState(){
        playFont2.setGlyphName("THUMBS_DOWN");
        exhibit.setNormalExListIcon("THUMBS_DOWN");
        play_btn.setStyle("-fx-background-color: #FF2D00;");
        exhibit.setNormalExListColor("#FF2D00");
    }

    public void NormalState(){
        mediaPlayer.stop();
        Model.getInstance().setPlayAudioFlag(1);
        thread.interrupt();
        playFont2.setGlyphName("STOP");
        exhibit.setNormalExListIcon("STOP");
        currentIconName = "STOP";
        play_btn.setStyle("-fx-background-color: #ff0062;");
        exhibit.setNormalExListColor("#ff0062");
    }

}