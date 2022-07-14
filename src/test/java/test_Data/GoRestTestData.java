package test_Data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {

    public Map<String, String> dataKeyMap(String name, String email, String gender, String status){

        Map<String, String> dataKeyMap=new HashMap<>();

        dataKeyMap.put("name", "Mr. Gita Menon");
        dataKeyMap.put("email", "gita_menon_mr@bayer.com");
        dataKeyMap.put("gender", "female");
        dataKeyMap.put("status", "inactive");

        return dataKeyMap;
    }

    public Map<String, Object> expectedDataMap(Object meta, Map<String, String> data){

        Map<String, Object> expectedDataMap=new HashMap<>();
        expectedDataMap.put("meta", meta);
        expectedDataMap.put("data", data);


        return expectedDataMap;
    }


}
