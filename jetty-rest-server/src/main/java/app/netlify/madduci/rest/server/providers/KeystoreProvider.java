package app.netlify.madduci.rest.server.providers;

import app.netlify.madduci.api.KeystoreApi;
import java.lang.reflect.InvocationTargetException;

public class KeystoreProvider {
  private final KeystoreApi keystoreApiImpl;

  public KeystoreProvider() {
    keystoreApiImpl = initModule();
  }

  private KeystoreApi initModule() {
    try {
      final var constructor =
          ClassLoader.getSystemClassLoader()
              .loadClass("app.netlify.madduci.api.implementation.KeystoreProvider")
              .getDeclaredConstructor();
      return (KeystoreApi) constructor.newInstance();
    } catch (NoSuchMethodException e) {
      throw new RuntimeException("No constructor found: " + e.getLocalizedMessage());
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("No class found: " + e.getLocalizedMessage());
    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
      throw new RuntimeException("Failed to create a new instance: " + e.getLocalizedMessage());
    }
  }

  public KeystoreApi getKeystoreApi() {
    return keystoreApiImpl;
  }
}
