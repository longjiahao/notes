package org.longjiahao.notes.utils;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NacosConfigUtils {


//    @NacosProperty("nacos-config-example")
    private ConfigService configService;
    {
        try {
            configService = ConfigFactory.createConfigService("127.0.0.1:8848");
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }


    public String getUserName() throws NacosException {
        System.out.println(configService.getServerStatus());
        return configService.getConfig("nacos-config-example", "DEFAULT_GROUP", 30);
    }

}
