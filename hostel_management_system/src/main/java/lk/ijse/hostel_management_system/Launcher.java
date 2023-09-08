package lk.ijse.hostel_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.hostel_management_system.dao.FactoryConfiguration;
import lk.ijse.hostel_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.getIcons().add(new Image("/img/hostel_img.jpg"));
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Hostel Management System");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}