package map;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirculePoint extends Group
{

    private static final int RADIUS_POINT = 7;
    private static final int RADIUS_BACKGROUND_POINT = 15;
    private static final double OPACITY = 0.3;


    private double[] coordinates;
    private int incidence;
    private Circle point;
    private Circle pointBackground;

    public CirculePoint(double[] coordinates, int incidence,String id)
    {
       this.coordinates = coordinates;
       this.incidence = incidence;
       this.setId(id);

       setObjects();
    }

    private void setObjects()
    {
        point = new Circle(coordinates[0],coordinates[1],RADIUS_POINT);
        point.setFill(getColorOfTypeIncidence(incidence));

        pointBackground = new Circle(coordinates[0],coordinates[1],RADIUS_BACKGROUND_POINT);
        pointBackground.setFill(getColorTransperentOfIncidence(incidence,OPACITY));

        this.getChildren().addAll(pointBackground,point);
    }


    public void setSelected()
    {
        pointBackground.setFill(Color.GREEN);
    }

    public void setDeselected()
    {
        pointBackground.setFill(getColorTransperentOfIncidence(incidence,0.3));
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
