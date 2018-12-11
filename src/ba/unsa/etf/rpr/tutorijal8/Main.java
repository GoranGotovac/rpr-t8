package ba.unsa.etf.rpr.tutorijal8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pretraga datoteka");
        primaryStage.setScene(new Scene(root, 800, 400));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
