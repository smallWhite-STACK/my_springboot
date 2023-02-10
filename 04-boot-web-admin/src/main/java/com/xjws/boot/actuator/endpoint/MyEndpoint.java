package com.xjws.boot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author xujian
 * @create 2023-02-07 19:16
 */
@Component
@Endpoint(id = "xjendpoint")
public class MyEndpoint {

    @ReadOperation
    public Map getDockerInfo(){
        return Collections.singletonMap("myDocker", "Docker正在启动中...");
    }

    @WriteOperation
    public void  stopDocker(){
        System.out.println("Docker Stop。。。");
    }
}
