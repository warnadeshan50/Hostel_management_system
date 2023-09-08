package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.UserBO;
import lk.ijse.hostel_management_system.dto.UserDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXTextField user_name_txt;

    @FXML
    private JFXTextField password_txt;

    @FXML
    private JFXButton login_btn;

    @FXML
    private PasswordField password_hide_txt;

    @FXML
    private JFXCheckBox show_checkbox;
    static String username;
    static String password;
    UserBO userBO = (UserBO)BOFactory.getBOFactory().getBO(BOFactory.BOType.USER);
    public void user_name_txtOnAction(ActionEvent actionEvent) {
        username=user_name_txt.getText();
    }

    public void password_txtOnAction(ActionEvent actionEvent) {
        password=password_txt.getText();
    }

    public void login_btnOnAction(ActionEvent actionEvent) throws IOException {
        checkPassword();
    }
    public void checkPassword(){
        try{
            username=user_name_txt.getText();
            String checkpass=password_hide_txt.getText();
            UserDTO userDTO =userBO.searchUser(username);
            if (userDTO!=null){
                password = userDTO.getPassword();
                username = userDTO.getUsername();
                System.out.println(password);
                System.out.println(username);
                System.out.println(checkpass);
                if(checkpass==password){
                    new Alert(Alert.AlertType.WARNING,"Password is Wrong").show();
                }else{
                    Scene stage=new Scene(FXMLLoader.load(getClass().getResource("/view/dashbord_form.fxml")));
                    Stage window=(Stage) login_btn.getScene().getWindow();
                    window.setScene(stage);
                    window.centerOnScreen();
                }
            }else{
                new Alert(Alert.AlertType.ERROR,"No User Founded !!!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong!!! ").show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void password_hide_txtOnAction(ActionEvent actionEvent) {
        password= password_hide_txt.getText();
        password_txt.setText(password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        password_hide_txt.setVisible(true);
        password_txt.setVisible(false);
    }

    public void password_hide_txtOnKeyReleased(KeyEvent keyEvent) {
        password = password_hide_txt.getText();
        password_txt.setText(password);
    }

    public void password_txtOnKeyReleased(KeyEvent keyEvent) {
        password = password_txt.getText();
        password_hide_txt.setText(password);
    }

    public void show_checkbocOnAction(ActionEvent actionEvent) {
        if (show_checkbox.isSelected()){
            password_txt.setVisible(true);
            password_hide_txt.setVisible(false);
        }else{
            password_hide_txt.setVisible(true);
            password_txt.setVisible(false);
        }
    }
}
