package map;

import incidence.IncidenceObject;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class MapControl
{
    private Pane map;

    public MapControl(Pane map)
    {
        this.map = map;
        map.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("X:" + mouseEvent.getX()+" Y:"+mouseEvent.getY() );
            }
        });
    }

    public void addPoints(ArrayList<IncidenceObject> incidenceObjects)
    {
        for(IncidenceObject o : incidenceObjects)
        {
            addPoint(o);
        }
    }

    public void addPoint(IncidenceObject incidenceObject)
    {
        Circle point = new Circle();
        Circle backgroudPoint = new Circle();

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

        point.setCenterX(points[0]);
        point.setCenterY(points[1]);

        point.setRadius(5);
        point.setFill(getColorOfTypeIncidence(typeOfIncident));

        backgroudPoint.setFill(getColorTransperentOfIncidence(typeOfIncident,0.3));
        backgroudPoint.setCenterX(points[0]);
        backgroudPoint.setCenterY(points[1]);
        backgroudPoint.setRadius(15);
        map.getChildren().add(point);
        map.getChildren().add(backgroudPoint);
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
