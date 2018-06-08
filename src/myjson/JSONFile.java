package myjson;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONFile
{
    public JSONArray getJSONArray(FileReader fileReader)//This function returns JSON array from FileReader
    {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;

        try
        {
            Object object = jsonParser.parse(fileReader);
            jsonArray = (JSONArray) object;

        }catch (Exception e) {e.printStackTrace();}

        return jsonArray;
    }
}
