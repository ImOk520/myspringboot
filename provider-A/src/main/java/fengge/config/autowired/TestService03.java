package fengge.config.autowired;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Feng, Ge 2021/5/17 0017 10:44
 */
@Service
@ToString
public class TestService03 {

    @Resource
    private TestDAO testDAO;

}
