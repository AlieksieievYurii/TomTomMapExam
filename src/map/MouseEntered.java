package map;

import incidence.IncidenceObject;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import listviewcontroler.ChangeListener;
import listviewcontroler.ListViewControler;

import java.util.ArrayList;

public class MouseEntered implements EventHandler<MouseEvent>
{
    private ListViewControler listViewControler;
    private Stage stage;
    private Tooltip tooltip;

    public MouseEntered(ListViewControler listViewControler)
    {
        this.listViewControler = listViewControler;
        tooltip = new Tooltip();
    }

    @Override
    public void handle(MouseEvent event)
    {
        Node node = (Node)event.getSource();
        String id = ((CirculePoint)event.getSource()).getId();

        IncidenceObject i = getIncidenceObjectById(id,listViewControler.getArrayList());
        tooltip.setText(getTextForTooltip(i));

        double x = event.getX();
        double y = event.getY();

        if(x > 600)//This I made for good showing of Tooltip
        {
            x -= 450;
        }

        tooltip.show(node,stage.getX() + x + 30,stage.getY() + y);
    }

    private String getTextForTooltip(IncidenceObject i)
    {
        StringBuilder text = new StringBuilder();

        text.append(i.get_id()).append("\n\n");
        text.append("Type: ").append(ChangeListener.getType(i.get_type())).append("\n");
        text.append("Details: ").append(i.get_details()).append("\n");
        text.append("From: ").append(i.get_from()).append("\n");
        text.append("To: ").append(i.get_to()).append("\n");
        text.append("Magnitude: ").append(ChangeListener.getMagnitude(i.get_magnitude())).append("\n");
        text.append("Delay: ").append(i.get_delay());

        return text.toString();
    }

    private IncidenceObject getIncidenceObjectById(String id, ArrayList<IncidenceObject> arrayList)
    {
        for(IncidenceObject i : arrayList)
        {
            if(i.get_id().equals(id)) return i;
        }
        return null;
    }

    public MouseExited getMouseExtited()
    {
        return new MouseExited();
    }

    public class MouseExited implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent event)
        {
            tooltip.hide();
        }
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
}
