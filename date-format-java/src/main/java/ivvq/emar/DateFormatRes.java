package ivvq.emar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

@Path("/")
public class DateFormatRes {

    @GET
    @Path("now")
    @Produces(MediaType.APPLICATION_JSON)
    public DateTime formatNow(@DefaultValue("UTC") @QueryParam("tz") String idTZ) {
        String timeZone = SimpleTimeZone.getTimeZone(idTZ).getDisplayName(Locale.FRENCH);
        // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss (OOOO) : zzzz");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("eeee dd MMMM uuuu, HH:mm:ss (OOOO)");
        String dateTime = ZonedDateTime.now(ZoneId.of(idTZ)).format(dateTimeFormatter.withLocale(Locale.FRENCH));
        return new DateTime(dateTime, timeZone);
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getListTZ() {
        return Arrays.asList(SimpleTimeZone.getAvailableIDs());
    }
}
