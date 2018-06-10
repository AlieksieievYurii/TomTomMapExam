package map;

import incidence.IncidenceObject;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import listviewcontroler.ChangeListener;
import listviewcontroler.ListViewControler;

import java.util.ArrayList;

public class MapControl
{
    private static final int RADIUS_POINT = 7;
    private static final int RADIUS_BACKGROUND_POINT = 15;

    private Pane map;
    private ClickerOnPoint clickerOnPoint;

    public MapControl(Pane map, ListViewControler listViewControler)
    {
        this.map = map;

        clickerOnPoint = new ClickerOnPoint(listViewControler);


        map.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {//This is for test
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("X:" + mouseEvent.getX()+" Y:"+mouseEvent.getY() );
            }
        });
    }

    public void addPoints(ArrayList<IncidenceObject> incidenceObjects)
    {
        map.getChildren().clear();//Just clear map for new adding points

        for(IncidenceObject o : incidenceObjects)
            addPoint(o);
    }

    public void addPoint(IncidenceObject incidenceObject)
    {

        int typeOfIncident = incidenceObject.get_type();//Type of Incident

        double[] points = incidenceObject.get_points();

       /* String x = String.valueOf(points[0]);
        x = x.substring(x.indexOf(".")).substring(1);

        String y = String.valueOf(points[1]);
        y = y.substring(y.indexOf(".")).substring(1);

        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);

        System.out.print(X+" ");
        System.out.println(Y);*/

       points = convertGoordsMapToSimple(points);//Convert coordinates from Map to simple coordinates

       Circle point = getPointByCoorditanes(points,typeOfIncident,incidenceObject.get_id());//Here I just get circule object. I pass coords type of incidence and id

       Circle backgroudPoint = getBackgroundPointByCoorditanes(points,typeOfIncident,0.3);

       point.setOnMouseClicked(clickerOnPoint);


        map.getChildren().add(backgroudPoint);
        map.getChildren().add(point);
    }

    private Circle getPointByCoorditanes(final double[] coords,final int incidence,final String id)
    {
        Circle point = new Circle();
        point.setId(id);
        point.setCenterX(coords[0]);//Set coordiantes of point on map
        point.setCenterY(coords[1]);
        point.setRadius(RADIUS_POINT);
        point.setFill(getColorOfTypeIncidence(incidence));//fill color, but color depends type of incidence
        return point;
    }

    private Circle getBackgroundPointByCoorditanes(final double[] coords,final int incidence,double opacity)
    {
        Circle point = new Circle();
        point.setCenterX(coords[0]);//Set coordiantes of point on map
        point.setCenterY(coords[1]);
        point.setRadius(RADIUS_BACKGROUND_POINT);
        point.setFill(getColorTransperentOfIncidence(incidence,opacity));//fill color, but color depends type of incidence
        return point;
    }

    //----------------------------------- I MUST IMPLEMENTS THIS FUNCTION-------------------------------------
    private double[] convertGoordsMapToSimple(double[] coords)
    {
        return coords;
    }

    private Color getColorOfTypeIncidence(int type)
    {
        switch (type)
        {
            case 1: return Color.ORANGE;
            case 2: return Color.NAVY;
            case 3: return Color.RED;
            default: return null;
        }
    }

    private Color getColorTransperentOfIncidence(int type, double opacity)
    {
        switch (type)
        {
            case 1: return Color.rgb(250,140,0,opacity);
            case 2: return Color.rgb(0,0,128,opacity);
            case 3: return Color.rgb(255,0,0,opacity);
            default: return null;
        }
    }
}
