package com.museomaster.museomaster.TypyUzytkownikow.MuseumClient;

import com.museomaster.museomaster.Models.Model;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
public class AddNormalUser implements Initializable {
    public TextField username_txtfld;
    public TextField email_txtfld;
    public PasswordField password;
    public Button create_user_btn;
    public Label error_lbl;
    public Label wait_lbl;

    public Label pass_lbl;

    public ProgressBar pass_progress;

    public boolean passwordFlag=false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().set_normal_user_err_label(error_lbl);

        pass_lbl.setText("Czy silne hasło: SŁABE NIE SPEŁNIA WYMAGAŃ");
        pass_lbl.setTextFill(Color.RED);
        pass_progress.setProgress(0.1);
        pass_progress.setStyle("-fx-accent: red;");


        password.textProperty().addListener((observable, oldValue, newValue) ->
                {
                    try {
                        checkPasswordSecurity();
                    } catch (StringIndexOutOfBoundsException ignored) {}
                }

        );

        create_user_btn.setOnAction(e -> {
            try {
            if(email_txtfld.getText().isBlank() || password.getText().isBlank() || username_txtfld.getText().isBlank()){
                error_lbl.setText("Nie udało się utworzyć użytkownika");
            }
            else if(!passwordFlag){
                error_lbl.setText("Za słabe hasło");
            }
            else {
                error_lbl.setText("");
                wait_lbl.setVisible(true);
                //Model.getInstance().getDataBaseDriver().createNormalClient(email_txtfld.getText(), password.getText(), username_txtfld.getText());
                Model.getInstance().setValidationCode();
                String code = Model.getInstance().getValidationCode();
                Properties properties = new Properties();
                FileInputStream configFile = null;
                try {
                    configFile = new FileInputStream("src/main/config/config.properties");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    properties.load(configFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Halooo");

                if(Model.getInstance().getDataBaseDriver().checkEmailExists(email_txtfld.textProperty().get()) || Model.getInstance().getDataBaseDriver().checkUsernameExists(username_txtfld.getText())) {
                    wait_lbl.setVisible(false);
                    error_lbl.setText("email lub nazwa użytkownika już zajęte");
                    System.out.println("HALOO2");
                }
                else{
                    Thread emailThread = new Thread(() -> {
                        boolean isSend = sendEmail(properties, code, email_txtfld.textProperty().get(), username_txtfld.getText());

                        // Update UI on the JavaFX Application Thread
                        Platform.runLater(() -> {
                            if (error_lbl.getText().isBlank() && isSend) {
                                Model.getInstance().setNormalUserVars(username_txtfld.getText(),email_txtfld.getText(),password.getText());
                                Model.getInstance().getViewFactory().showEmailValidation();
                                Model.getInstance().getViewFactory().closeStage((Stage) error_lbl.getScene().getWindow());
                                wait_lbl.setVisible(false);
                            } else {
                                error_lbl.setText("Zły email");
                                wait_lbl.setVisible(false);
                            }
                        });
                    });

                    emailThread.start();
                }

            }
            }
            catch (Exception x) {
                    wait_lbl.setVisible(false);
                    error_lbl.setText("Nie udało się utworzyć użytkownika");
                }
        });

    }

    private static JavaMailSender getJavaMailSender(Properties properties) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(properties.getProperty("mail.host"));
        mailSender.setPort(Integer.parseInt(properties.getProperty("mail.port")));

        mailSender.setUsername(properties.getProperty("mail.name")); // Replace with your Gmail address
        mailSender.setPassword(properties.getProperty("mail.password")); // Replace with your Gmail password

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    private static boolean sendEmail(Properties properties, String code,String emailTo, String username) {
        try {
            JavaMailSender sender = getJavaMailSender(properties);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(properties.getProperty("mail.name"));
            message.setTo(emailTo);
            message.setSubject("MuseoMaster - weryfikacja email");
            message.setText("Witaj "+username+" ! Aby potwierdzić rejestrację konta wpisz kod w programie: "+code);
            System.out.println("xd");
            sender.send(message);
            System.out.println("Wysłano");
            return true;
        } catch (Exception e) {
            System.out.println("Nie wysłano");
            return false;
        }
    }

    private void checkPasswordSecurity() {
        String password1 = password.getText();
        boolean hasMinLength = password1.length() >= 8;
        boolean hasOverMinLength = password1.length() > 10;
        boolean hasNumber = password1.matches(".*\\d.*");
        boolean hasSpecialChar = password1.matches(".*[^a-zA-Z0-9].*");

        if (hasOverMinLength && hasNumber && hasSpecialChar) {
            pass_lbl.setText("Czy silne hasło: JESZCZE LEPIEJ");
            pass_lbl.setTextFill(Color.GREEN);
            pass_progress.setProgress(1.0);
            pass_progress.setStyle("-fx-accent: green;");
            passwordFlag = true;
        } else if (hasMinLength && hasNumber && hasSpecialChar) {
            pass_lbl.setText("Czy silne hasło: TAK");
            pass_lbl.setTextFill(Color.ORANGE);
            pass_progress.setStyle("-fx-accent: orange;");
            pass_progress.setProgress(0.5);
            passwordFlag = true;
        } else {
            pass_lbl.setText("Czy silne hasło: SŁABE NIE SPEŁNIA WYMAGAŃ");
            pass_lbl.setTextFill(Color.RED);
            pass_progress.setStyle("-fx-accent: red;");
            pass_progress.setProgress(0.1);
            passwordFlag = false;
        }
    }


}

