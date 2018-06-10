package map;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import listviewcontroler.ListViewControler;

public class ClickerOnPoint implements EventHandler<MouseEvent>
{
    private ListViewControler listViewControler;

    public ClickerOnPoint(ListViewControler listViewControler)
    {
        this.listViewControler = listViewControler;
    }

    @Override
    public void handle(MouseEvent event)
    {
        System.out.println(((Circle)event.getSource()).getId());
        listViewControler.selectItemByIdIncidence(((Circle)event.getSource()).getId());
    }
}
