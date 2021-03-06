package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "GGS" and last name is "FINCH"
     */
    @Test
    public void get01(){
        // 1. step; Set the Url
        //asagidaki gibi filtreleme yapacagik
        // https://restful-booker.herokuapp.com/booking?firstname=Aaron&lastname=Chen

        spec.pathParam("first", "booking").
                queryParams("firstname", "GGS", "lastname", "FINCH");

        // 2. step ; Set the expected data
        // 3. step; Set the request and get response

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4. Step: Do Assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));

    }
}
