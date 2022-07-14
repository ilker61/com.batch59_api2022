package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users/2965
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
    "meta": null,
    "data": {
        "id": 2965,
        "name": "Mr. Gita Menon",
        "email": "gita_menon_mr@bayer.com",
        "gender": "female",
        "status": "inactive"
    }
}
     */

    @Test
    public void get01(){

        // 1 step; Set the Url

        spec.pathParams("first", "users", "second", 2965);

        // 2. step; Set the expected Data

        Map<String, String> dataKeyMap=new HashMap<>();

        dataKeyMap.put("name", "Mr. Gita Menon");
        dataKeyMap.put("email", "gita_menon_mr@bayer.com");
        dataKeyMap.put("gender", "female");
        dataKeyMap.put("status", "inactive");

        Map<String, Object> expectedDataMap=new HashMap<>();

        expectedDataMap.put("meta", null);
        expectedDataMap.put("data", dataKeyMap);

        System.out.println(expectedDataMap);

        // 3. step ; send the request get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        // 4. step; Do Assertion

        assertEquals(expectedDataMap.get("meta"), actualDataMap.get("meta"));

        assertEquals(dataKeyMap.get("name"), ((Map)actualDataMap.get("data")).get("name"));
        assertEquals(dataKeyMap.get("email"), ((Map)actualDataMap.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"), ((Map)actualDataMap.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"), ((Map)actualDataMap.get("data")).get("status"));

    }


}
