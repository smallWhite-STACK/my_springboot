package com.xjws.boot.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author xujian
 * @create 2023-02-07 18:08
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        
        if(1==1){
            builder.up();
            //我们返回一些信息
            map.put("count", 1);
            map.put("ms", 1000);
        }else{
            builder.down();
            //
            map.put("ms", 30000);
            map.put("err", "连接失败");
        }
        builder.withDetail("code",20)
        .withDetails(map);

    }
}
