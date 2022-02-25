package app.netlify.madduci.api.implementation;

import app.netlify.madduci.api.KeystoreApi;
import app.netlify.madduci.api.KeystoreData;
import app.netlify.madduci.api.KeystoreSpecs;
import app.netlify.madduci.encryption.KeystoreGenerator;
import java.io.IOException;

/** Implements the Keystore API */
public class KeystoreProvider implements KeystoreApi {
  /**
   * Creates a Keystore from the given parameters.
   *
   * @param keystoreRequest - holds the specs for the new keystore
   */
  @Override
  public KeystoreData createKeystore(KeystoreSpecs keystoreSpecs) {
    try {
      return KeystoreGenerator.generateKeystore(keystoreSpecs);
    } catch (IOException | InstantiationException e) {
      return new KeystoreData().message(e.getMessage());
    }
  }
}
