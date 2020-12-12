package RedisUtil;

import com.feng.consumer.util.RedisUtil;
import entity.A;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test() {
        A a = new A("ImOK");
        redisUtil.set("name", a);
    }

}
