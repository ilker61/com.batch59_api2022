package test_Data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object> expectedDataWithAllKeys(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedData=new HashMap<>();
        expectedData.put("userId", userId);
        expectedData.put("title", title);
        expectedData.put("completed", completed);
        return expectedData;
    }

    public Map<String, Object> expectedDataWithMissingKeys(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedData=new HashMap<>();
        if (userId!=null){
            expectedData.put("userId", userId);
        }
        if (title!=null){
            expectedData.put("title", title);
        }
        if (completed!=null){
            expectedData.put("completed", completed);
        }
        return expectedData;
    }

    // asagidaki json formati stringr ceviren method yazacagiz

    /*
    {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    public String expectedDataInString(Integer userId, String title, Boolean completed){

        String expectedData = "{\n" +
                "   \"userId\": "+userId+"  ,\n" +
                "   \"title\": \""+title+"\",\n" +
                "   \"completed\": "+completed+"\n" +
                "  }";
        return expectedData;
    }




}
