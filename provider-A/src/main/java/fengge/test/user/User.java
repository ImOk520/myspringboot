package fengge.test.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@PropertySource(value = "classpath:user.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "user")
@Setter
@Getter
@ToString
public class User {

    private String userName;
    private boolean isAdmin;
    private Date regTime;
    private Long isOnline;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Address address;

}
