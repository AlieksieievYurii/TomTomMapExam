package sample;


import incidence.IncidenceObject;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import listviewcontroler.ListViewControler;
import map.MapControl;
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
    private ArrayIncidensJSON arrayIncidensJSON;//This class is for build ArrayList of object IncidenceObject from JSONarray
    private MapControl mapControl;//This class is for control map image. Add points
    private ListViewControler listViewControler;//This class is for add to ListView elemetns and control them

    @FXML
    public Button btnTest;//For Test

    @FXML
    public Pane map;//This is pane, I use it as Map

    @FXML
    public ListView<IncidenceObject> list_incidence;//List view for incidence

    @FXML
    public TextArea textAreaInformation;//For information from list view about incidence


    public void initialize ()
    {
       fileReader = new FileReader(stage);
       jsonFile = new JSONFile();
       arrayIncidensJSON = new ArrayIncidensJSON();
       mapControl = new MapControl(map);//I pass argument as map, I mean I pass my map to mapControl
       listViewControler = new ListViewControler(list_incidence,textAreaInformation);


        btnTest.setOnAction(event ->
        {
            java.io.FileReader file = fileReader.getFileReader();//Here I get FileReader
            JSONArray jsonArray = jsonFile.getJSONArray(file);//Here I get JSON array from FileReader
            ArrayList<IncidenceObject> inc  = arrayIncidensJSON.getArrayListIncidence(jsonArray);//Here I get ArrayList from jsonArray
            listViewControler.setListView(inc);//Setting listview and textArea for information
            map.getChildren().clear();
            mapControl.addPoints(inc);//Here I get all points on map(image)

        });//for test

        setStyleForPane();
    }

    private void setStyleForPane()
    {
        map.setId("panel");
        map.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    }


    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
}
