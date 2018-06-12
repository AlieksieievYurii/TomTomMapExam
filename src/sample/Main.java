package sample;

import com.sun.javafx.runtime.VersionInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));//set FXMLLoader from xml file
        Parent root = fxmlLoader.load();

        Controller controller = fxmlLoader.getController();
        controller.setStage(primaryStage);


        primaryStage.setTitle("Map");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
        primaryStage.setResizable(false);

        Scene scene = new Scene(root, 1250,700);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
