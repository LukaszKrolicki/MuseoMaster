module com.museomaster.museomaster {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.museomaster.museomaster to javafx.fxml;
    exports com.museomaster.museomaster;
}