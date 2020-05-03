package com.imnu.SchoolBus.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class IndexConfig {
    
 @EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {
        System.out.println("项目部署完毕........启动浏览器");
        // 启动后访问地址
//        String url = "http://localhost:8080/schoolbus/regist.html";
//        Runtime runtime = Runtime.getRuntime();
//        try {
//            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
