package ivvq.emar;

/**
 * Created by emartin on 13/03/18.
 */
public class DateTime {
    private String dateTime;
    private String timeZone;
    public DateTime(){ super(); };
    public DateTime(String dateTime, String timeZone) {
        super();
        this.dateTime = dateTime;
        this.timeZone = timeZone;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
