package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){

        // 1. step; set the Url

        spec.pathParams("first", "todos", "second", 198);

        // 2. step; set the expected data
        Map<String, Object> expectedData= new HashMap<>();

        // 3. step; send the delete request get response

        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        // 4. step; do assertion

        // 1. yol

        Map<String, Object> actualMap = response.as(HashMap.class);

        response.then().assertThat().statusCode(200);
        assertEquals(expectedData, actualMap);

        // 2. yol
        assertTrue(actualMap.size()==0);
        assertTrue(actualMap.isEmpty()); // tavsiye edilen




    }

}
