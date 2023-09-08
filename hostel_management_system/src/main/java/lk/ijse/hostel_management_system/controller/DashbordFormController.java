package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashbordFormController {
    @FXML
    private AnchorPane root1;

    @FXML
    private JFXButton student_btn;

    @FXML
    private JFXButton rooms_btn;

    @FXML
    private JFXButton keymoney_btn;

    @FXML
    private JFXButton reset_btn;

    @FXML
    private JFXButton logout_btn;

    @FXML
    void keymoney_btnOnAction(ActionEvent event) {

    }

    @FXML
    void logout_btnOnAction(ActionEvent event) throws IOException {
        Scene stage=new Scene(FXMLLoader.load(getClass().getResource("/view/login_form.fxml")));
        Stage window=(Stage) logout_btn.getScene().getWindow();
        window.setScene(stage);
        window.centerOnScreen();
    }

    @FXML
    void reset_btnOnAction(ActionEvent event) {

    }

    @FXML
    void rooms_btnOnAction(ActionEvent event) throws IOException {
        Scene stage=new Scene(FXMLLoader.load(getClass().getResource("/view/rooms_form.fxml")));
        Stage window=(Stage) logout_btn.getScene().getWindow();
        window.setScene(stage);
        window.centerOnScreen();
    }

    @FXML
    void student_btnOnAction(ActionEvent event) throws IOException {
        Scene stage=new Scene(FXMLLoader.load(getClass().getResource("/view/student_form.fxml")));
        Stage window=(Stage) logout_btn.getScene().getWindow();
        window.setScene(stage);
        window.centerOnScreen();
    }

}
