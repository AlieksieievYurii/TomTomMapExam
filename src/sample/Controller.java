package sample;


import freader.TextFromJson;
import img.ImageDangerous;
import incidence.IncidenceObject;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import listviewcontroler.ListViewControler;
import map.MapControl;
import myjson.ArrayIncidensJSON;
import myjson.JSONFile;
import freader.FileReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import url.GetFileFromURL;
import url.GetURL;
import java.util.ArrayList;

public class Controller
{

    private static final int TIME_OF_QUERY_URL = 1;//Im minutes

    private Stage stage;
    private FileReader fileReader;//This is my custom class for getting FileReader
    private JSONFile jsonFile;//This is my custom class for getting JSON object
    private ArrayIncidensJSON arrayIncidensJSON;//This class is for build ArrayList of object IncidenceObject from JSONarray
    private MapControl mapControl;//This class is for control map image. Add points
    private ListViewControler listViewControler;//This class is for add to ListView elemetns and control them
    private Timeline timeline = null;
    private ImageDangerous imageDangerous;
    private JSONArray jsonArray;
    private ArrayList<IncidenceObject> inc;

    @FXML
    public Button btnJson;

    @FXML
    public Button btnUrlJson;

    @FXML
    public Pane map;//This is pane, I use it as Map

    @FXML
    public ListView<IncidenceObject> list_incidence;//List view for incidence

    @FXML
    public TextArea textAreaInformation;//For information from list view about incidence

    @FXML
    public ImageView image_error;


    public void initialize ()
    {
        fileReader = new FileReader(stage);
        jsonFile = new JSONFile();
        arrayIncidensJSON = new ArrayIncidensJSON();
        listViewControler = new ListViewControler(list_incidence,textAreaInformation);
        mapControl = new MapControl(map,listViewControler);//I pass argument as map, I mean I pass my map to mapControl

        listViewControler.setMapController(mapControl);//Here I pass mapController as argument
        imageDangerous = new ImageDangerous(image_error);


        btnJson.setOnAction(event ->
        {
            java.io.FileReader file = fileReader.getFileReader();//Here I get FileReader

            if(file == null) return;

            if(timeline != null)timeline.stop();//Here I stop procces of query when click button read from file

            imageDangerous.stopError();//I did it for stoping error when I change mode of read json file. For example:
            //First I chose URL read Mode and write wrong url, so start error(Bling of image dangerous).
            //If I choose mode ReadFileJson ofter ReadURLJson, I stop imageDangerous

            runProcces(TextFromJson.getTextFromFileReader(file));

        });

        btnUrlJson.setOnAction(event ->
        {
            if(timeline != null)timeline.stop();

            String url = GetURL.getURL();

            if(url == null) return;

            GetFileFromURL getFileFromURL = new GetFileFromURL(url);

            runProcces(getJSONfile(getFileFromURL));

            timeline = new Timeline(new KeyFrame((Duration.seconds(TIME_OF_QUERY_URL*60)), ev ->
                    runProcces(getJSONfile(getFileFromURL))));

            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();

        });

        setStyleForPane();
    }

    private String getJSONfile(GetFileFromURL getFileFromURL)//I get text json file, but if it's null I start blinking of DangeroudImage
    {
        String textJson = getFileFromURL.getJsonText();

        if(textJson == null)
        {
            imageDangerous.startError();
        }
        else imageDangerous.stopError();

        return textJson;
    }

    private void runProcces(String textJson)
    {
        if(textJson == null) return;//If it null I just stop work

        jsonArray = jsonFile.getJSONArray(textJson);//Here I get JSON array from FileReader
        inc  = arrayIncidensJSON.getArrayListIncidence(jsonArray);//Here I get ArrayList from jsonArray
        listViewControler.setListView(inc);//Setting listview and textArea for information
        mapControl.addPoints(inc);//Here I get all points on map(image)
    }

    private void setStyleForPane()
    {
        map.setId("panel");
        map.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    }


    public void setStage(Stage stage)
    {
        this.stage = stage;
        mapControl.setStage(stage);
    }
}
