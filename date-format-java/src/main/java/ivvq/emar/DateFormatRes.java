package ivvq.emar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.SimpleTimeZone;

@Path("/")
public class DateFormatRes {

    @GET
    @Path("now")
    @Produces(MediaType.TEXT_PLAIN)
    public String formatNow(@DefaultValue("UTC") @QueryParam("tz") String idTZ) {
        // String timeZone = SimpleTimeZone.getTimeZone(idTZ).getDisplayName(Locale.FRENCH);
        // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss (OOOO) : zzzz");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("eeee dd MMMM uuuu, HH:mm:ss (OOOO) : zzzz");
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
