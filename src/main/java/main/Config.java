package main;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abhijeet Gulve
 */
@Configuration
public class Config {

    @Bean
    public ConfigMap constructUrlApiConfig() {
        ConfigMap configMap = ConfigMap.getConfigMap();
        Map<String, String> userConfig = new HashMap<>();
        userConfig.put("testApi", "1.2");
        configMap.setHeaderFiledToRead("key");
        configMap.addConfig("test", userConfig);
        return configMap;
    }
}
