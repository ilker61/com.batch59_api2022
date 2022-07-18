package put_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_Data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class PutPratik1 extends JsonPlaceHolderBaseUrl {

     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */

    @Test
    public void put01(){

        //1. step; set the Url
        spec.pathParams("first" , "todos", "second", 198);

        // 2. step; set teh expected data

        JsonPlaceHolderTestData expectdeData= new JsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap=expectdeData.expectedDataWithAllKeys(21, "Wash the dishes", false);

        // 3. step; send the put request get response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).put("/{first}/{second}");
        response.prettyPrint();

        // 4. step; do assertion;

        Map<String, Object>actualDataMap=response.as(HashMap.class);

        assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));

    }
}
