package incidence;

/*This class is object of incidence on map*/

public class IncidenceObject
{
    private String _id;
    private int _type;
    private double[] _points;
    private String _from;
    private String _to;
    private String _details;
    private int _delay;
    private int _magnitude;

    public IncidenceObject(
            String _id,
            int _type,
            double[] _points,
            String _from,
            String _to,
            String _details,
            int _delay,
            int _magnitude)
    {
        this._id = _id;
        this._type = _type;
        this._points = _points;
        this._from = _from;
        this._to = _to;
        this._details = _details;
        this._delay = _delay;
        this._magnitude = _magnitude;
    }

    public String get_id() {
        return _id;
    }

    public int get_type() {
        return _type;
    }

    public double[] get_points() {
        return _points;
    }

    public String get_from() {
        return _from;
    }

    public String get_to() {
        return _to;
    }

    public String get_details() {
        return _details;
    }

    public int get_delay() {
        return _delay;
    }

    public int get_magnitude() {
        return _magnitude;
    }
}
