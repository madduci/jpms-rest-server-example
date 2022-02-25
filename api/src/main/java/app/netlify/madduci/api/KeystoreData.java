package app.netlify.madduci.api;

import java.io.Serializable;
import java.util.Objects;

public class KeystoreData implements Serializable {

  private String data;
  private String message;

  public KeystoreData data(String data) {
    this.data = data;
    return this;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public KeystoreData message(String message) {
    this.message = message;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeystoreData keystoreData = (KeystoreData) o;
    return Objects.equals(this.data, keystoreData.data)
        && Objects.equals(this.message, keystoreData.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeystoreResponse {\n");

    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
