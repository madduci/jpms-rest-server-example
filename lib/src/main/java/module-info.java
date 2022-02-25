import app.netlify.madduci.api.KeystoreApi;
import app.netlify.madduci.api.implementation.KeystoreProvider;

module app.netlify.madduci.library {
  requires app.netlify.madduci.api;
  requires org.bouncycastle.provider;

  exports app.netlify.madduci.api.implementation;

  provides KeystoreApi with
      KeystoreProvider;
}
