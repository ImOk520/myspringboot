package fengge.config.autowired;

import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * Feng, Ge 2021/5/17 0017 10:44
 */
@Service
@ToString
public class TestService04 {

    @Inject
    private TestDAO testDAO;

}
