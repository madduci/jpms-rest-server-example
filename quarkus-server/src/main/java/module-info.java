import app.netlify.madduci.api.KeystoreApi;

module quarkus.rest.server {
  requires app.netlify.madduci.api;
  requires java.ws.rs;
  requires microprofile.health.api;

  uses KeystoreApi;
}
