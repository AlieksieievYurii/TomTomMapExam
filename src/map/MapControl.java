package map;

import incidence.IncidenceObject;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import listviewcontroler.ListViewControler;

import java.util.ArrayList;

public class MapControl
{
    private Pane map;
    private ClickerOnPoint clickerOnPoint;

    public MapControl(Pane map, ListViewControler listViewControler)
    {
        this.map = map;
        clickerOnPoint = new ClickerOnPoint(listViewControler,map);

        map.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("X:" + event.getX()+" Y:"+event.getY());
            }
        });

        map.setFocusTraversable(true);
    }

    public void addPoints(ArrayList<IncidenceObject> incidenceObjects)
    {
        map.getChildren().clear();//Just clear map for new adding points

        for(IncidenceObject o : incidenceObjects)
            addPoint(o);
    }

    /*public void addPointTEst(IncidenceObject incidenceObject)
    {

        int typeOfIncident = incidenceObject.get_type();//Type of Incident

        double[] points = incidenceObject.get_points();

       *//* String x = String.valueOf(points[0]);
        x = x.substring(x.indexOf(".")).substring(1);

        String y = String.valueOf(points[1]);
        y = y.substring(y.indexOf(".")).substring(1);

        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);

        System.out.print(X+" ");
        System.out.println(Y);*//*

    }*/

    private void addPoint(IncidenceObject incidenceObject)
    {
        double[] cord = incidenceObject.get_points();
        int incidence = incidenceObject.get_type();

        cord = convertGoordsMapToSimple(cord);

        CirculePoint circulePoint = new CirculePoint(cord,incidence,incidenceObject.get_id());

        circulePoint.setOnMouseClicked(clickerOnPoint);

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
    private double[] convertGoordsMapToSimple(double[] points)
    {
        System.out.println("1:"+points[0]);
        System.out.println("2:"+points[1]);

        double x = (points[0] - 12.943025);
        double y = (52.646326 - points[1]);

        points[0] = x * 950;
        points[1] = y * 2110;

        return points;
    }

}