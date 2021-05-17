package fengge.config.autowired;

import cn.hutool.core.lang.Console;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Feng, Ge 2021/5/17 0017 10:44
 */
@Service
@ToString
public class TestService {

    @Autowired
    private TestDAO testDAO02;
}
