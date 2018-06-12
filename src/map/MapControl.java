package map;

import incidence.IncidenceObject;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import listviewcontroler.ListViewControler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MapControl
{
    private Pane map;
    private ClickerOnPoint clickerOnPoint;
    private MouseEntered mouseEntered;

    public MapControl(Pane map, ListViewControler listViewControler)
    {
        this.map = map;
        mouseEntered = new MouseEntered(listViewControler);
        clickerOnPoint = new ClickerOnPoint(listViewControler,map);

        map.setFocusTraversable(true);
    }

    public void addPoints(ArrayList<IncidenceObject> incidenceObjects)
    {
        map.getChildren().clear();//Just clear map for new adding points

        for(IncidenceObject o : incidenceObjects)
            addPoint(o);
    }

    private void addPoint(IncidenceObject incidenceObject)
    {
        double[] cord = incidenceObject.get_points();
        int incidence = incidenceObject.get_type();

        cord = convertGoordsMapToSimple(cord);

        CirculePoint circulePoint = new CirculePoint(cord,incidence,incidenceObject.get_id());

        circulePoint.setOnMouseClicked(clickerOnPoint);
        circulePoint.setOnMouseEntered(mouseEntered);
        circulePoint.setOnMouseExited(mouseEntered.getMouseExtited());

        map.getChildren().add(circulePoint);
    }

    public void clickOnPoint(IncidenceObject incidenceObject)
    {
        if(incidenceObject == null) return;

        String id = incidenceObject.get_id();

        int sizeParent = map.getChildren().size();

        clickerOnPoint.resetMap();

        for(int i = 0; i < sizeParent; i++)
        {
            CirculePoint circulePoint = (CirculePoint) map.getChildren().get(i);
            if(id.equals(circulePoint.getId()))
            {
                circulePoint.setSelected();
                return;
            }
        }
    }

    //----------------------------------- I MUST IMPLEMENTS THIS FUNCTION-------------------------------------
    private double[] convertGoordsMapToSimple(double[] points)//This function converts coordinates from Map to simple coordinates for Pane
    {
        double x = (points[0] - 12.943025);
        double y = (52.646326 - points[1]);

        points[0] = x * 950;
        points[1] = y * 2110;

        return points;
    }

    public void setStage(Stage stage)
    {
        mouseEntered.setStage(stage);
    }
}