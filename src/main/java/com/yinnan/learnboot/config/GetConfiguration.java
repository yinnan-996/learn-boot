package com.yinnan.learnboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * Description:读取resource下的.properties文件，将文件中的内容封装到map中，注入到bean中方便依赖注入
 * User: yinnan
 * Date: 2018/9/30
 * Time: 11:16
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Configuration
public class GetConfiguration {

    @Bean(name="commonMap")
    public Map<String, String> commonMap(){
        Map<String, String> result = getConfig("webConfig");
        return result;
    }

    public static Map<String,String> getConfig(String name) {
        Map<String,String> result = new HashMap<>(1);
        try {
            Properties properties = new Properties();
            InputStream in = GetConfiguration.class.getClassLoader().getResourceAsStream(name + ".properties");
            properties.load(in);
            log.info("加载{}.properties参数",name);
            for (String keyName : properties.stringPropertyNames()) {
                String value = properties.getProperty(keyName);
                result.put(keyName, value);
                log.info("{}.properties---------key:{},value:{}",name, keyName, value);
            }
            log.info("{}.properties参数加载完毕",name);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
