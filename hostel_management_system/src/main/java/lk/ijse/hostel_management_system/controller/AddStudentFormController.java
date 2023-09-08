package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dto.StudentDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddStudentFormController implements Initializable {
    @FXML
    private JFXComboBox<String> gender_cmb;

    @FXML
    private JFXTextField id_txt;

    @FXML
    private JFXTextField name_txt;

    @FXML
    private JFXTextField address_txt;

    @FXML
    private JFXTextField contact_txt;

    @FXML
    private JFXTextField dob_txt;

    @FXML
    private Button save_btn;

    @FXML
    private Button cancel_btn;
    StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.STUDENT);
    String id,name,address,contact,dob,gender;

    @FXML
    void cancel_btnOnAction(ActionEvent event) {
        Stage stage = (Stage) cancel_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void gender_cmbOnAction(ActionEvent event) {

    }

    @FXML
    void save_btnOnAction(ActionEvent event) {
        try{
            id = id_txt.getText();
            name = name_txt.getText();
            address = address_txt.getText();
            contact = contact_txt.getText();
            dob = dob_txt.getText();
            gender = gender_cmb.getValue();
            studentBO.isSaveStudent(new StudentDTO(id,name,address,contact,dob,gender));
            new Alert(Alert.AlertType.CONFIRMATION,"Student Add Successfully !!!").show();
            clearAllTxt();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadGenders(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("Male");
        obList.add("Female");
        obList.add("Other");
        gender_cmb.setItems(obList);
    }
    void clearAllTxt(){
        id_txt.clear();
        name_txt.clear();
        address_txt.clear();
        contact_txt.clear();
        gender_cmb.setValue("Choose");
        dob_txt.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGenders();
    }
}
