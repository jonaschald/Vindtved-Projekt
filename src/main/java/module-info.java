module com.example.vindtved_projekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vindtved_projekt to javafx.fxml;
    exports com.example.vindtved_projekt;
}