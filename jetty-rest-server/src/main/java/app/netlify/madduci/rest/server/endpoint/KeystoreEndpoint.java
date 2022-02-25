package app.netlify.madduci.rest.server.endpoint;

import app.netlify.madduci.api.KeystoreApi;
import app.netlify.madduci.api.KeystoreData;
import app.netlify.madduci.api.KeystoreSpecs;
import app.netlify.madduci.rest.server.providers.KeystoreProvider;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/keystore")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KeystoreEndpoint implements KeystoreApi {

  private KeystoreApi keystoreApi;

  public KeystoreEndpoint() {
    init();
  }

  private void init() {
    keystoreApi = new KeystoreProvider().getKeystoreApi();
  }

  @POST
  @Path("/create")
  @Override
  public KeystoreData createKeystore(KeystoreSpecs keystoreSpecs) {
    return keystoreApi.createKeystore(keystoreSpecs);
  }
}
