package listviewcontroler;

import incidence.IncidenceObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import map.MapControl;

import java.util.ArrayList;

/*
* This class is for controll ListView
* Such as:
*   * loading items from object
*   * converting ArrayList to ObservableList
*   * adding change listener
*
*   Constructor gets two params. First is ListView. It's for settings items.
*   Second param is for setting text(information) when we select item. So all information from selected Ited wiil print in textAreaInformation*/


public class ListViewControler
{
    private ListView listView;
    private TextArea textAreaInformation;
    private MapControl mapControl;
    private ArrayList<IncidenceObject> arrayList;

    public ListViewControler(ListView listView, TextArea textAreaInformation)
    {
        this.listView = listView;
        this.textAreaInformation = textAreaInformation;
    }

    public void setMapController(MapControl mapControl)
    {
        this.mapControl = mapControl;
    }


    public void setListView(ArrayList arrayList)
    {

        textAreaInformation.setText(null);//Clear the text area for new information

        arrayList = sortByDelay("ASC",arrayList);

        this.arrayList = arrayList;

        ObservableList observableList = convertArrayListToObservableList(arrayList);//Create ObservableList because I need it for ListView else can not:( maybe...

        listView.setItems(observableList);

        listView.setCellFactory(param -> new ListCell<IncidenceObject>()//This method is for set name of list item as Id of incidence and Details
        {
            @Override
            protected void updateItem(IncidenceObject item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.get_id() == null) {
                    setText(null);
                } else {
                    setText(item.get_details()+"\n"+item.get_id());
                }
            }
        });

        setSelectItemListener(listView,textAreaInformation);
    }

    public ArrayList<IncidenceObject> getArrayList()
    {
        return arrayList;
    }

    private ArrayList<IncidenceObject> sortByDelay(String orderBy, ArrayList<IncidenceObject> arrayList)//This method sort has two mode of sort ASC & DESC
    {//I use Bubble Sort for fun:)))))

        for(int i = 0; i < arrayList.size(); i++)
        {
            for(int k = 0; k < arrayList.size()-1; k++)
            {
                IncidenceObject ob1 = arrayList.get(k);
                IncidenceObject ob2 = arrayList.get(k+1);
                int ob1Delay = ob1.get_delay();
                int ob2Delay = ob2.get_delay();

                switch (orderBy)
                {
                    case "DESC":
                        if(ob1Delay > ob2Delay)
                        {
                            arrayList.set(k,ob2);
                            arrayList.set(k+1,ob1);
                        }
                        break;

                    case "ASC":
                        if(ob1Delay < ob2Delay)
                        {
                            arrayList.set(k,ob2);
                            arrayList.set(k+1,ob1);
                        }
                        break;
                     default: return null;
                }
            }
        }
        return arrayList;
    }

    private ObservableList convertArrayListToObservableList(ArrayList arrayList)//This method convert array list to observable list
    {
        ObservableList observableList = FXCollections.observableArrayList();

        observableList.addAll(arrayList);

        return observableList;
    }

    private void setSelectItemListener(ListView listView, TextArea textAreaInformation)
    {
        listView.getSelectionModel().selectedItemProperty().addListener(new listviewcontroler.ChangeListener(textAreaInformation,mapControl));//Here we pass param as TextArea for printing inf
    }

    public void selectItemByIdIncidence(String id)
    {
        for(int i = 0; i < arrayList.size(); i++)
        {
            IncidenceObject incidenceObject = arrayList.get(i);
            if(incidenceObject.get_id().equals(id))
            {
                listView.getSelectionModel().select(i);
            }

        }
    }
}
