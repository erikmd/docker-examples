package ivvq.emar;

import org.glassfish.grizzly.utils.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GrizzlyServerExceptionLogger implements ExceptionMapper<Exception> {
    private static final Logger _log = LoggerFactory.getLogger(GrizzlyServerExceptionLogger.class);

    @Override
    public Response toResponse(Exception ex) {
        _log.error("Une erreur est survenue lors de l'exécution d'une requête", ex);
        return Response.status(500).entity(Exceptions.getStackTraceAsString(ex)).type("text/plain")
                .build();
    }
}
