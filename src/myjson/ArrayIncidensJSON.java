package myjson;

import incidence.IncidenceObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

/*This class create ArrayList with IncidenceObject from jsonArray */

public class ArrayIncidensJSON
{
    private IncidenceObjectJSON incidenceObjectJSON = new IncidenceObjectJSON();

    public ArrayList<IncidenceObject> getArrayListIncidence(JSONArray jsonArray)
    {

        ArrayList<IncidenceObject> arrayList = new ArrayList<>();

        for (Object aJsonArray : jsonArray) {
            JSONObject jsonObject = (JSONObject) aJsonArray;//Array of json object
            IncidenceObject incidenceObject = incidenceObjectJSON.getIncidenceObject(jsonObject);// here I get Incidence object from JSON object
            arrayList.add(incidenceObject);
        }
        return arrayList;
    }
}