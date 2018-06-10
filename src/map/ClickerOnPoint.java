package map;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import listviewcontroler.ListViewControler;

public class ClickerOnPoint implements EventHandler<MouseEvent>
{
    private ListViewControler listViewControler;
    private Pane map;

     ClickerOnPoint(ListViewControler listViewControler, Pane map)
    {
        this.listViewControler = listViewControler;
        this.map = map;
    }

    @Override
    public void handle(MouseEvent event)
    {
        listViewControler.selectItemByIdIncidence(((CirculePoint)event.getSource()).getId());
        resetMap();
        ((CirculePoint)event.getSource()).setSelected();
    }

    public void resetMap()
    {
        for(int i = 0; i < map.getChildren().size(); i++)
        {
            CirculePoint circulePoint = (CirculePoint) map.getChildren().get(i);
            circulePoint.setDeselected();
        }
    }
}
