package main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abhijeet Gulve
 */
public class ConfigMap {
    private static ConfigMap config;
    private Map<String, Map<String, String>> map = new HashMap<>();
    private String headerFiledToRead;

    public static ConfigMap getConfigMap() {
        if (config == null) {
            config = new ConfigMap();
            return config;
        }
        return config;
    }

    public String getHeaderFiledToRead() {
        return headerFiledToRead;
    }

    public void setHeaderFiledToRead(String headerFiledToRead) {
        this.headerFiledToRead = headerFiledToRead;
    }

    public void addConfig(String clientId, Map<String, String> clientConfig) {
        map.put(clientId, clientConfig);
    }

    public Map<String, String> getClientConfiguration(String clientId) {
        return map.get(clientId);
    }

}
