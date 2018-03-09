package ivvq.emar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

@Path("/")
public class DateFormatRes {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("now")
    @Produces(MediaType.TEXT_PLAIN)
    public String formatNow(@DefaultValue("UTC") @QueryParam("tz") String idTZ) {
        // TimeZone tz = SimpleTimeZone.getTimeZone(idTZ);
        String pattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(
                FormatStyle.FULL, FormatStyle.FULL, IsoChronology.INSTANCE, Locale.FRENCH);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return ZonedDateTime.now(ZoneId.of(idTZ)).format(dateTimeFormatter.withLocale(Locale.FRENCH));


    }

    @GET
    @Path("list")
    @Produces(MediaType.TEXT_PLAIN)
    public String getListTZ() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String tz : SimpleTimeZone.getAvailableIDs()) {
            stringBuilder.append(tz);
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
