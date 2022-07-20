package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestResponsePojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
    /*
    Given
            https://gorest.co.in/public/v1/users/2316
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            {
    "meta": null,
    "data": {
        "id": 2314,
        "name": "Opalina Varrier",
        "email": "varrier_opalina@simonis.biz",
        "gender": "male",
        "status": "inactive"
    }
}
     */

    @Test
    public void getPojo01(){

        //1. step set the url

        spec.pathParams("first","users", "second", 2314) ;

        // 2. step set the expected data

        GoRestDataPojo goRestDataPojo= new GoRestDataPojo(2314, "Opalina Varrier", "varrier_opalina@simonis.biz","male", "inactive" );
        GoRestResponsePojo goRestResponsePojo= new GoRestResponsePojo(null,goRestDataPojo);

        // 3. step; send the get request get the response

        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. step do assertion

        GoRestResponsePojo actualPojo = response.as(GoRestResponsePojo.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(goRestResponsePojo.getMeta(), actualPojo.getMeta());

        assertEquals(goRestDataPojo.getId(), actualPojo.getData().getId());
        assertEquals(goRestDataPojo.getName(), actualPojo.getData().getName());
        assertEquals(goRestDataPojo.getEmail(), actualPojo.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(), actualPojo.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(), actualPojo.getData().getStatus());


    }

}
