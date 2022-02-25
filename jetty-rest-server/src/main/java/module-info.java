import app.netlify.madduci.api.KeystoreApi;

module jetty.rest.server {
  requires app.netlify.madduci.api;
  requires java.ws.rs;
  requires org.eclipse.jetty.servlet;
  requires org.bouncycastle.provider;
  requires resteasy.core;

  uses KeystoreApi;
}
