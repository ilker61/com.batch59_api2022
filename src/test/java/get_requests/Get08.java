package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    //================  ###########   =====================

    //De-Serialization: JSON formatından Java objesine çevirme.
    //Serialization: Java objesini JSON formatına çevirme.
    // De-Serialization ve Serialization iki türlü yapılır:
    //Gson: Goole tarafından üretiliştir.
    //Object Mapper: Daha popüler ***

    @Test
    public void get01(){

        // 1. step; Set the Url

        spec.pathParams("first", "todos", "second", 2);

        // 2. step; set the expected data
        Map<String, Object> expectedData=new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("title" , "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        expectedData.put("Status code", 200);
        expectedData.put("Via" , "1.1 vegur");
        expectedData.put("Server" , "cloudflare");

        // 3. step; send thr request get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualDAta=response.as(HashMap.class);

        //4. step ; Do assertion

        assertEquals(expectedData.get("userId"),actualDAta.get("userId"));
        assertEquals(expectedData.get("title"),actualDAta.get("title"));
        assertEquals(expectedData.get("completed"),actualDAta.get("completed"));
        assertEquals(expectedData.get("Status code"),response.getStatusCode());
        assertEquals(expectedData.get("Via"),response.getHeader("Via"));
        assertEquals(expectedData.get("Server"),response.getHeader("Server"));

    }

}
