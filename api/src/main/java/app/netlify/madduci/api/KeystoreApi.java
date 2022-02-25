package app.netlify.madduci.api;

/** Defines the Keystore Api */
public interface KeystoreApi {
  /**
   * Creates a Keystore from the given parameters.
   *
   * @param keystoreRequest - holds the specs for the new keystore
   */
  KeystoreData createKeystore(KeystoreSpecs keystoreSpecs);
}
