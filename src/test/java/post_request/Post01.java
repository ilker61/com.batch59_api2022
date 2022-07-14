package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_Data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {

/*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01(){
        // 1. step; set the Url
        spec.pathParam("first", "todos");

        // 2. step; set the expected Data

        JsonPlaceHolderTestData expectedData= new JsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap = expectedData.expectedDataWithAllKeys(55, "Tidy your room",false );

        // 3. step; send post request and get response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
        response.prettyPrint();


        // 4. step; Do Assertion

        Map<String, Object> actualMap=response.as(HashMap.class);
        assertEquals(expectedDataMap.get("userId"), actualMap.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualMap.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualMap.get("completed"));

    }

}
