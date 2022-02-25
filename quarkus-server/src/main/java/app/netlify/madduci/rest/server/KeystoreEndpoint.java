package app.netlify.madduci.rest.server;

import app.netlify.madduci.api.KeystoreApi;
import app.netlify.madduci.api.KeystoreData;
import app.netlify.madduci.api.KeystoreSpecs;
import app.netlify.madduci.rest.server.providers.KeystoreProvider;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
