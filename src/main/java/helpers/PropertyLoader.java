package helpers;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
  public static String getProperties(String property) {
    Properties properties = new Properties();
    try {
      properties.load(PropertyLoader.class.getResourceAsStream("/day.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties.getProperty(property);
  }
}
