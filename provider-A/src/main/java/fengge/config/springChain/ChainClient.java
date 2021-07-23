package fengge.config.springChain;

import cn.hutool.core.lang.Console;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Feng, Ge 2021/7/23 0023 10:18
 */
@SpringBootTest
public class ChainClient {

   @Autowired
   private ValidHandlerChain validHandlerChain;

   @Test
   public void test(){
       List<Object> handle = validHandlerChain.handle(Lists.newArrayList("ok", "hello"));
       Console.log(handle);
   }

}
