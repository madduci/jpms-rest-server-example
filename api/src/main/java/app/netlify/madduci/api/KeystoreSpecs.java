package app.netlify.madduci.api;

import java.io.Serializable;
import java.util.Objects;

public class KeystoreSpecs implements Serializable {

  private String type = "PKCS12";
  private String algorithm;
  private String alias;
  private Integer keyLength;
  private String keyPassword;
  private String password;

  public KeystoreSpecs type(String type) {
    this.type = type;
    return this;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public KeystoreSpecs algorithm(String algorithm) {
    this.algorithm = algorithm;
    return this;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public KeystoreSpecs alias(String alias) {
    this.alias = alias;
    return this;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public KeystoreSpecs keyLength(Integer keyLength) {
    this.keyLength = keyLength;
    return this;
  }

  public Integer getKeyLength() {
    return keyLength;
  }

  public void setKeyLength(Integer keyLength) {
    this.keyLength = keyLength;
  }

  public KeystoreSpecs keyPassword(String keyPassword) {
    this.keyPassword = keyPassword;
    return this;
  }

  public String getKeyPassword() {
    return keyPassword;
  }

  public void setKeyPassword(String keyPassword) {
    this.keyPassword = keyPassword;
  }

  public KeystoreSpecs password(String password) {
    this.password = password;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeystoreSpecs keystoreSpecs = (KeystoreSpecs) o;
    return Objects.equals(this.type, keystoreSpecs.type)
        && Objects.equals(this.algorithm, keystoreSpecs.algorithm)
        && Objects.equals(this.keyLength, keystoreSpecs.keyLength)
        && Objects.equals(this.keyPassword, keystoreSpecs.keyPassword)
        && Objects.equals(this.password, keystoreSpecs.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, algorithm, keyLength, keyPassword, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KestoreRequest {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
    sb.append("    keyLength: ").append(toIndentedString(keyLength)).append("\n");
    sb.append("    keyPassword: ").append(toIndentedString(keyPassword)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
