package lk.ijse.hostel_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.getIcons().add(new Image("/img/hostel_img.jpg"));
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Hostel Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
