package sample;


import incidence.IncidenceObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import myjson.ArrayIncidensJSON;
import myjson.JSONFile;
import freader.FileReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.json.simple.JSONArray;


import java.util.ArrayList;

public class Controller
{
    private Stage stage;
    private FileReader fileReader;//This is my custom class for getting FileReader
    private JSONFile jsonFile;//This is my custom class for getting JSON object

    @FXML
    public Button btnTest;

    @FXML
    public Canvas map;


    public void initialize ()
    {
       fileReader = new FileReader(stage);
       jsonFile = new JSONFile();

       Image img = new Image("file:map.png");

        btnTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                java.io.FileReader file = fileReader.getFileReader();
                JSONArray jsonArray = jsonFile.getJSONArray(file);

                ArrayIncidensJSON arrayIncidensJSON = new ArrayIncidensJSON();
                ArrayList<IncidenceObject> inc  = arrayIncidensJSON.getArrayListIncidence(jsonArray);

                for(IncidenceObject ic : inc) System.out.println(ic.get_id());

                Circle circle = new Circle();
                circle.setCenterX(10);
                circle.setCenterY(10);
                circle.setRadius(20);
                //map.getGraphicsContext2D().drawImage(img,200,200);
                map.getGraphicsContext2D().fillText("LOL",20,40);

            }
        });//for test
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
}
