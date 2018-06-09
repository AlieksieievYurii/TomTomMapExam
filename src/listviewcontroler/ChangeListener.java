package listviewcontroler;

import incidence.IncidenceObject;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;

public class ChangeListener implements javafx.beans.value.ChangeListener {

    private TextArea textAreaInformation;

    public ChangeListener(TextArea textAreaInformation)
    {
        this.textAreaInformation = textAreaInformation;
    }
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        printIncidenceInformation((IncidenceObject)newValue,textAreaInformation);
    }

    public void printIncidenceInformation(IncidenceObject incidenceObject,TextArea textAreaInformation)
    {
        textAreaInformation.setText(String.format("Id: %s\nType:%s\nFrom:%s\nTo:%s\nMagnitude:%s\nDelay:%s",
                incidenceObject.get_id(),
                getType(incidenceObject.get_type()),
                incidenceObject.get_from(),
                incidenceObject.get_to(),
                getMagnitude(incidenceObject.get_magnitude()),
                incidenceObject.get_delay())
        );
    }

    private String getType(int type)
    {
        switch (type)
        {
            case 0:return "Jam";
            case 1:return "Dangerous conditions";
            case 2:return "Lane closed";
            default: return null;
        }
    }

    private String getMagnitude(int magnitude)
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
