package fengge.test;

import cn.hutool.core.lang.Console;
import fengge.test.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Modifier;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class TestDemo {

    @Autowired
    User user;

    @Test
    public void testConfigurationProperties(){
       System.out.println("[===========]" + user);
    }

    @Test
    public void testModifier(){
        Console.log(Modifier.isStatic(1));
    }

}