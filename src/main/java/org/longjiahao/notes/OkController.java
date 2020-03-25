package org.longjiahao.notes;


import com.alibaba.nacos.api.exception.NacosException;
import org.apache.kafka.common.protocol.types.Field;
import org.longjiahao.notes.utils.NacosConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

//@RefreshScope
@RestController
public class OkController {


//    @Value("${user.name}")
//    String userName;
//
//    @Value("${user.age}")
//    String age;
//
////    @Autowired
////    private NacosConfigUtils configUtils;
//
//    @GetMapping("/name/get")
//    public String getUserName() throws NacosException {
//
//
//        char[] strings = userName.toCharArray();
//
//                return userName;
//    }

//    @GetMapping("/age/get")
//    public String getUserAge() {
//
//        return age;
//    }






    @GetMapping("ok")
    public String ok() {

        return "hello";
    }

}
