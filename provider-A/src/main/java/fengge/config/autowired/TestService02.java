package fengge.config.autowired;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Feng, Ge 2021/5/17 0017 10:44
 */
@Service
@ToString
public class TestService02 {

    @Qualifier("testDAO02")
    @Autowired
    private TestDAO testDAO;

}
