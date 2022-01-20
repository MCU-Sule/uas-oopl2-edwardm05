package com.example.uas_1872003.Controller;

import com.example.uas_1872003.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//1872003 - Edward Michael S
public class LoginController implements Initializable {

    public Label labelID;
    public Label labelPassword;
    public TextField tfID;
    public PasswordField tfPassword;
    public Button btnLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("main-view.fxml"));
        loader.setResources(ResourceBundle.getBundle("bundle"));
        Parent root = loader.load();
        MainController mc = loader.getController();
        Stage mainStage = new Stage();
        mainStage.setTitle("Main Form");
        mainStage.setScene(new Scene(root));
        mainStage.initModality(Modality.APPLICATION_MODAL);
        mainStage.show();
    }
}