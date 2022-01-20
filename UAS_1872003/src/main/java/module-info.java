module com.example.uas_1872003 {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.sql;


    opens com.example.uas_1872003 to javafx.fxml;
    exports com.example.uas_1872003;
    exports com.example.uas_1872003.Controller;
    opens com.example.uas_1872003.Controller to javafx.fxml;
}