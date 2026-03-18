module com.example.vindtved_projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.net.http;
    requires com.google.gson;
    requires javafx.base;
    requires java.naming;
    requires transitive com.microsoft.sqlserver.jdbc;
    requires java.sql;
    requires eu.hansolo.medusa;


    opens com.example.vindtved_projekt to javafx.fxml;
    exports com.example.vindtved_projekt;
}