package ir.asran.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
    private static final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ReadConfig.class);

    public void app() {

        try {
            InputStream inputStream = new FileInputStream("app.conf");
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public String full_path() {
        app();
        return properties.getProperty("myAppConfig.path");
    }

    public String threadNum() {
        app();
        return properties.getProperty("myAppConfig.nThreads");
    }

    public String queueSize() {
        app();
        return properties.getProperty("myAppConfig.queueSize");
    }

    public String host() {
        app();
        return properties.getProperty("myAppConfig.mongodb.host");
    }

    public String port() {
        app();
        return properties.getProperty("myAppConfig.mongodb.port");
    }

    public String database() {
        app();
        return properties.getProperty("myAppConfig.mongodb.database");
    }

    public String collection() {
        app();
        return properties.getProperty("myAppConfig.mongodb.collection");
    }

    public String username() {
        app();
        return properties.getProperty("myAppConfig.mongodb.username");
    }

    public String password() {
        app();
        return properties.getProperty("myAppConfig.mongodb.password");
    }

}
