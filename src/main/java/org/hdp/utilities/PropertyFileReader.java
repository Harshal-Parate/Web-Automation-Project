package org.hdp.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

    static FileInputStream fs;
    static Properties p;

    public static String readPropertyFileData(String key) {

        try {
            fs = new FileInputStream("/Users/harshalparate/Downloads/SDET Master/Projects/WebAutomation/src/test/resources/Creds/Config.properties");
            p = new Properties();
            p.load(fs);
            fs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return p.getProperty(key);
    }
}