package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get14ObjectMapper extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get01ObjectMapper(){

        //1. step; set the Url

        spec.pathParams("first", "todos", "second", 198);

        //2. step; set the expected data

        String expectedData = "{\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "    \"completed\": true\n" +
                "  }";

        HashMap<String, Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        // 3. step; send the get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        // 4. step; do assertion

        HashMap<String, Object> actualData = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"), actualData.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualData.get("completed"));

    }

    // 2. YOLLLLLLLLLLLLLLLLLLLLLLLLLLLLL

    // en iyi yontem


    @Test
    public void get02ObjectMapper(){
        //1. step; set the Url

        spec.pathParams("first", "todos", "second", 198);

        //2. step; set the expected data

        String expectedData = "{\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "    \"completed\": true\n" +
                "  }";

        JsonPlaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);

        // 3. step; send the get request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        // 4. step do assertion

        JsonPlaceHolderPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), JsonPlaceHolderPojo.class);

        assertEquals(200, response.getStatusCode());

        assertEquals(expectedDataPojo.getUserId(), actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(), actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(), actualDataPojo.getCompleted());

    }
}
