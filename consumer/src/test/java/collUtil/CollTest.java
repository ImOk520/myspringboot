package collUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class CollTest {

    @Test
    public void removeDuplication() {
        List<Map<String, Object>> resultList = CollUtil.resultList();
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> map : resultList) {
            if (!list.contains(map)) {
                list.add(map);
            }
        }
        System.out.println(list);
    }


}
