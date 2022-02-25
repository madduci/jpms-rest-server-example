package app.netlify.madduci.rest.server;

import app.netlify.madduci.api.KeystoreData;
import app.netlify.madduci.api.KeystoreSpecs;
import app.netlify.madduci.rest.server.endpoint.KeystoreEndpoint;
import jakarta.ws.rs.core.Application;
import java.util.Set;

public class ApplicationServer extends Application {
  public ApplicationServer() {}

  @Override
  public Set<Object> getSingletons() {
    return Set.of(new KeystoreEndpoint());
  }

  @Override
  public Set<Class<?>> getClasses() {
    return Set.of(KeystoreSpecs.class, KeystoreData.class);
  }
}
