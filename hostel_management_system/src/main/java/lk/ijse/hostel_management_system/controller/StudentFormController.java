package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable{
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
    private JFXButton search_btn;
    @FXML
    private JFXButton back_btn;

    @FXML
    private Button add_btn;

    @FXML
    private Button update_btn;

    @FXML
    private Button delete_btn;

    @FXML
    private TableColumn<?, ?> id_col;

    @FXML
    private TableColumn<?, ?> name_col;

    @FXML
    private TableColumn<?, ?> gender_cl;

    @FXML
    private TableColumn<?, ?> address_col;

    @FXML
    private TableColumn<?, ?> dob_col;

    @FXML
    private TableColumn<?, ?> contact_col;
    @FXML
    private TableView<StudentTM> student_tbl;

    StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.STUDENT);

    @FXML
    void add_btnOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/add_student_form.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Student");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void delete_btnOnAction(ActionEvent event) {
        try{
            String id=id_txt.getText();
            String name = name_txt.getText();
            String address = address_txt.getText();
            String contact = contact_txt.getText();
            String dob = dob_txt.getText();
            String gender = gender_cmb.getValue();
            studentBO.isDeleteStudent(new StudentDTO(id,name,address,contact,dob,gender));
            new Alert(Alert.AlertType.WARNING, "Do you want to Delete this Student").show();
            clearAllTxt();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void gender_cmbOnAction(ActionEvent event) {

    }

    @FXML
    void search_btnOnAction(ActionEvent event) {
        try{
            String id=id_txt.getText();
            StudentDTO studentdto =studentBO.searchStudent(id);
            if (studentdto!= null) {
                String name = studentdto.getName();
                String address = studentdto.getAddress();
                String contact = studentdto.getContact_no();
                String dob = studentdto.getDate_of_birth();
                String gender = studentdto.getGender();
                name_txt.setText(name);
                address_txt.setText(address);
                contact_txt.setText(contact);
                dob_txt.setText(dob);
                gender_cmb.setValue(gender);
            }else {
                new Alert(Alert.AlertType.ERROR,"No Student found!!!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void search_txtOnAction(ActionEvent event) {
        search_btnOnAction(event);
    }

    @FXML
    void update_btnOnAction(ActionEvent event) {
        try{
            String id=id_txt.getText();
            String name = name_txt.getText();
            String address = address_txt.getText();
            String contact = contact_txt.getText();
            String dob = dob_txt.getText();
            String gender = gender_cmb.getValue();
            studentBO.isUpdateStudent(new StudentDTO(id,name,address,contact,dob,gender));
            new Alert(Alert.AlertType.CONFIRMATION,"Student Update Successfully!!!").show();
            setCellValueFactory();
            getAll();
            clearAllTxt();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void back_btnOnAction(ActionEvent event) throws IOException {
        Scene stage=new Scene(FXMLLoader.load(getClass().getResource("/view/dashbord_form.fxml")));
        Stage window=(Stage) back_btn.getScene().getWindow();
        window.setScene(stage);
        window.centerOnScreen();
    }
    private void loadGenders(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("Male");
        obList.add("Female");
        obList.add("Other");
        gender_cmb.setItems(obList);
    }
    void setCellValueFactory() {
        id_col.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        address_col.setCellValueFactory(new PropertyValueFactory<>("address"));
        contact_col.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        dob_col.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        gender_cl.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }
    private void getAll() {
        try {
            ObservableList<StudentTM> obList = FXCollections.observableArrayList();
            List<StudentDTO> stList = studentBO.getAllStudents();

            for(StudentDTO studentDTO : stList) {
                obList.add(new StudentTM(
                        studentDTO.getStudent_id(),
                        studentDTO.getName(),
                        studentDTO.getAddress(),
                        studentDTO.getContact_no(),
                        studentDTO.getDate_of_birth(),
                        studentDTO.getGender()
                ));
            }
            student_tbl.setItems(obList);
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Query error!").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGenders();
        setCellValueFactory();
        getAll();
    }
    void clearAllTxt(){
       id_txt.clear();
       name_txt.clear();
       address_txt.clear();
       contact_txt.clear();
       gender_cmb.setValue("Choose");
       dob_txt.clear();
    }
}
