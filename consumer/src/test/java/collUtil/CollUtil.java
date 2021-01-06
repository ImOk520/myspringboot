package collUtil;

import java.util.*;

/**
 * Feng, Ge 2020-11-12 14:21
 */
public class CollUtil {

    public static List<Map<String, Object>> resultList(){
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("orgType", "社区医院");
        map1.put("orgTypeCode", "510");
        map1.put("orgName", "二份子乡中心卫生院");
        map1.put("districtCode", "150125");
        map1.put("city", "呼和浩特市");
        map1.put("district", "武川县");
        map1.put("updator", "5848636a04ff41c58d412a802827078c");
        map1.put("creditsCount", 91);
        map1.put("userName", "管某某");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("orgType", "社区医院");
        map2.put("orgTypeCode", "510");
        map2.put("orgName", "二份子乡中心卫生院");
        map2.put("districtCode", "150125");
        map2.put("city", "呼和浩特市");
        map2.put("district", "武川县");
        map2.put("updator", "5848636a04ff41c58d412a802827078c");
        map2.put("creditsCount", 91);
        map2.put("userName", "管某某");
        Map<String, Object> map3 = new HashMap<>();
        map3.put("orgType", "社区医院");
        map3.put("orgTypeCode", "510");
        map3.put("orgName", "二份子乡中心卫生院");
        map3.put("districtCode", "150125");
        map3.put("city", "呼和浩特市");
        map3.put("district", "武川县");
        map3.put("updator", "5848636a04ff41c58d412a802827078c");
        map3.put("creditsCount", 91);
        map3.put("userName", "管某某1");
        resultList.add(map1);
        resultList.add(map2);
        resultList.add(map3);
        return resultList;
    }

}
