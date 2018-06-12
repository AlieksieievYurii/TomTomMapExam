package listviewcontroler;

import incidence.IncidenceObject;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import map.MapControl;

public class ChangeListener implements javafx.beans.value.ChangeListener {

    private TextArea textAreaInformation;
    private MapControl mapControl;

    public ChangeListener(TextArea textAreaInformation, MapControl mapControl)
    {
        this.textAreaInformation = textAreaInformation;
        this.mapControl = mapControl;
    }
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        printIncidenceInformation((IncidenceObject)newValue,textAreaInformation);
        mapControl.clickOnPoint((IncidenceObject)newValue);

    }

    public void printIncidenceInformation(IncidenceObject incidenceObject, TextArea textAreaInformation)
    {
        if(incidenceObject == null) return;//I dont know why I did it, but without it I get NuulPointException! But program works ofter error

        textAreaInformation.setText(String.format("Id: %s\nType:%s\nFrom:%s\nTo:%s\nMagnitude:%s\nDelay:%s",
                incidenceObject.get_id(),
                getType(incidenceObject.get_type()),
                incidenceObject.get_from(),
                incidenceObject.get_to(),
                getMagnitude(incidenceObject.get_magnitude()),
                incidenceObject.get_delay())
        );
    }

    public static String getType(int type)
    {
        switch (type)
        {
            case 1:return "Jam";
            case 2:return "Dangerous conditions";
            case 3:return "Lane closed";
            default: return null;
        }
    }

    public static String getMagnitude(int magnitude)
    {
        switch (magnitude)
        {
            case 0: return "Unknown";
            case 1: return "Minor";
            case 2: return "Moderate";
            case 3: return "Major";
            default: return null;
        }
    }
}
