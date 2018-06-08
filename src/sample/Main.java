package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));//set FXMLLoader from xml file

        Parent root = fxmlLoader.load();
        root.setId("pane");
        Controller controller = fxmlLoader.getController();
        controller.setStage(primaryStage);

        primaryStage.setTitle("Map");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, 1000,700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
