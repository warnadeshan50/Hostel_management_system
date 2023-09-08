package lk.ijse.hostel_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.RoomBO;
import lk.ijse.hostel_management_system.dto.RoomDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RoomsFormController implements Initializable {

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXComboBox<String> type_cmb;

    @FXML
    private JFXTextField id_txt;

    @FXML
    private JFXTextField rkm_txt;

    @FXML
    private JFXTextField qty_txt;

    @FXML
    private JFXButton search_btn;

    @FXML
    private Button add_btn;

    @FXML
    private Button update_btn;

    @FXML
    private Button delete_btn;

    @FXML
    private TableView<?> student_tbl;

    @FXML
    private TableColumn<?, ?> id_col;

    @FXML
    private TableColumn<?, ?> type_col;

    @FXML
    private TableColumn<?, ?> rkm_col;

    @FXML
    private TableColumn<?, ?> qty_col;

    String id,type;
    double rkm;
    int qty;

    RoomBO roomBO = (RoomBO)BOFactory.getBOFactory().getBO(BOFactory.BOType.ROOM);

    @FXML
    void add_btnOnAction(ActionEvent event) {
        try{
            id = id_txt.getText();
            type = type_cmb.getValue();
            rkm = Double.parseDouble(rkm_txt.getText());
            roomBO.isSaveRoom(new RoomDTO(id,type,rkm,qty));
            new Alert(Alert.AlertType.CONFIRMATION,"Student Add Successfully !!!").show();
            clearAllTxt();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void back_btnOnAction(ActionEvent event) {

    }

    @FXML
    void delete_btnOnAction(ActionEvent event) {

    }

    @FXML
    void search_btnOnAction(ActionEvent event) {

    }

    @FXML
    void search_txtOnAction(ActionEvent event) {

    }

    @FXML
    void update_btnOnAction(ActionEvent event) {

    }
    private void loadRoomType(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("None AC");
        obList.add("None AC with Food");
        obList.add("AC");
        obList.add("AC with Food");
        type_cmb.setItems(obList);
    }
    void clearAllTxt(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadRoomType();
    }
}
