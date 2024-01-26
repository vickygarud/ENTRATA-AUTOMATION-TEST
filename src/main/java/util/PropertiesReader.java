package util;

import java.io.*;
import java.util.Properties;

/**
 * class contains method to read content from the config property
 */
public class PropertiesReader {

    public static Properties prop;
    public static InputStream inputStream;

    public static String getproperty(String filename, String key) {
        Object value = null;
        try {
            prop = new Properties();
            File file = new File("src/main/resources/config/" + filename + ".properties");
            inputStream = new FileInputStream(file);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + file.getName() + "' not found in the classpath");
            }
            value = prop.get(key);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return value.toString();
    }

    /**
     * method to fetch values from the custom config file
     *
     * @param key
     * @return
     */
    public static String getCustomConfigValue(String key) {
        return getproperty("userConfig", key);
    }


}
