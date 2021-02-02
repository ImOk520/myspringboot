package feng.ge.es.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@RequestMapping("/config-client")
@RestController
public class ConfigClientTestController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getRemoteConfigs")
    public String getRemoteConfigs() {
        log.info("applicationName: {}", applicationName);
        log.info("eurekaServer: {}", eurekaServer);
        log.info("port: {}", port);
        return applicationName+ " " + eurekaServer + "" + port;
    }
}
