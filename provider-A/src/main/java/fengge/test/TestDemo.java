package fengge.test;

import fengge.test.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class TestDemo {

    @Autowired
    User user;

    @Test
    public void testConfigurationProperties(){
       System.out.println("[===========]" + user);
    }

}