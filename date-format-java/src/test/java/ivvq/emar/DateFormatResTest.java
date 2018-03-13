package ivvq.emar;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertTrue;

public class DateFormatResTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testNowAtParis() {
        String responseMsg = target.path("now").queryParam("tz", "Europe/Paris").request().get(String.class);
        assertTrue(responseMsg != null && responseMsg.length() > 0);

    }

    @Test
    public void getListOfTimeZones() {
        String responseMsg = target.path("list").request().get(String.class);
        assertTrue(responseMsg != null && responseMsg.length() > 0);
    }
}
