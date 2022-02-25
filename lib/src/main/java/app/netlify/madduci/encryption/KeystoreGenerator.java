package app.netlify.madduci.encryption;

import app.netlify.madduci.api.KeystoreData;
import app.netlify.madduci.api.KeystoreSpecs;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import org.bouncycastle.util.encoders.Base64;

public class KeystoreGenerator {
  private KeystoreGenerator() {}

  public static KeystoreData generateKeystore(final KeystoreSpecs keystoreSpec)
      throws InstantiationException, IOException {
    try {
      final KeyStore keystore = KeyStore.getInstance(keystoreSpec.getType());
      final var keystorePassword = keystoreSpec.getPassword().toCharArray();
      keystore.load(null, keystorePassword);

      final KeystoreData response = new KeystoreData();
      try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        keystore.store(baos, keystorePassword);
        response.setData(Base64.toBase64String(baos.toByteArray()));
        response.setMessage("Success");
      } catch (CertificateException e) {
        e.printStackTrace();
      }

      return response;

    } catch (KeyStoreException e) {
      throw new InstantiationException(
          "Failed to create a new keystore of type " + keystoreSpec.getType());
    } catch (IOException e) {
      throw new IOException("Failed to store information in the keystore");
    } catch (NoSuchAlgorithmException e) {
      throw new InstantiationException(
          "Invalid Algorithm selected: " + keystoreSpec.getAlgorithm());
    } catch (CertificateException e) {
      throw new InstantiationException("Failed to create a certificate: " + e.getMessage());
    }
  }
}
