package myjson;

import incidence.IncidenceObject;
import org.json.simple.JSONObject;

/*
* This class parses json object to Incidence object*/

public class IncidenceObjectJSON
{
    public IncidenceObject getIncidenceObject(JSONObject jsonObject)
    {
        IncidenceObject incidenceObject;

        String _id;
        int _type;
        double[] _points;
        String _from;
        String _to;
        String _details;
        int _delay;
        int _magnitude;

        try
        {
            _id = jsonObject.get("id").toString();
            _type = Integer.parseInt(jsonObject.get("type").toString());//Here I parse Long type of numbers(From jsonObject) to Integer
            _points = getPoint((JSONObject)jsonObject.get("point"));
            _from = jsonObject.get("from").toString();
            _to = jsonObject.get("to").toString();
            _details = jsonObject.get("details").toString();
            _delay = Integer.parseInt(jsonObject.get("delay").toString());
            _magnitude = Integer.parseInt(jsonObject.get("magnitude").toString());

        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        incidenceObject = new IncidenceObject(
                _id,
                _type,
                _points,
                _from,
                _to,
                _details,
                _delay,
                _magnitude);

        return incidenceObject;
    }

    private double[] getPoint(JSONObject point)//Function which casts JSON object to array double X & Y point
    {
        double[] points = null;

        try
        {
            double x = Double.parseDouble(point.get("x").toString());//Parsing text(double) from JSON object
            double y = Double.parseDouble(point.get("y").toString());

            points = new double[]{x,y};

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return points;
    }
}
