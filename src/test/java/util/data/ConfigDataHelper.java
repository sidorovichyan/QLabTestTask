package util.data;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ConfigDataHelper {
    private static final Logger logger = Logger.getLogger(ConfigDataHelper.class);

    private static final String PATH_TO_DATA = "config.json";

    private static HashMap<String, String> configData;

    private static ConfigDataHelper instance;

    private ConfigDataHelper() {
        this.init();
    }

    public static ConfigDataHelper getInstance() {
        if (instance == null) {
            instance = new ConfigDataHelper();
            instance.init();
        }
        return instance;
    }

    private void init() {
        loadTestData();
    }

    private void loadTestData() {
        ObjectMapper mapper = new ObjectMapper();
        URL res = getClass().getClassLoader().getResource(PATH_TO_DATA);
        byte[] jsonData = new byte[0];
        try {
            assert res != null;
            jsonData = Files.readAllBytes(Paths.get(res.toURI()));
            configData = mapper.readValue(jsonData, HashMap.class);
        } catch (IOException | URISyntaxException e) {
            logger.info("Error while read/open file: " + PATH_TO_DATA + e);
            throw new Error("Error while read/open file: " + PATH_TO_DATA + e);
        }
    }

    public String getValue(String key) {
        return configData.get(key);
    }
}