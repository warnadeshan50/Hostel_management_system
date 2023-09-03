package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {
    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXTextField user_name_txt;

    @FXML
    private JFXTextField password_txt;

    @FXML
    private JFXButton login_btn;
    String username;
    String password;
    public void user_name_txtOnAction(ActionEvent actionEvent) {
        username=user_name_txt.getText();
    }

    public void password_txtOnAction(ActionEvent actionEvent) {
        password=password_txt.getText();
    }

    public void login_btnOnAction(ActionEvent actionEvent) {
        username=user_name_txt.getText();
        password=password_txt.getText();
        checkPassword(username,password);
    }
    public void checkPassword(String username,String password){

    }
}
