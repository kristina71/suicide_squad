package day1.helpers;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    public static String getProperties(String property) {
        Properties properties = new Properties();
        try {
            properties.load(PropertyLoader.class.getResourceAsStream("/day1.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}
