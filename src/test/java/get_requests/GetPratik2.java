package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetPratik2 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "GGS" and last name is "Chen"
     */

    @Test
    public void get01(){

        //1. step; set the url
        //asagidaki gibi filtreleme yapacagik. bunun icin queryParams() methodu kullanilacak
        // https://restful-booker.herokuapp.com/booking?firstname=Aaron&lastname=Chen

        spec.when().pathParam("first", "booking").
                queryParams("firdtname", "GGS", "lastname", "FINCH");

        // 2. step ; Set the expected data
        // 3. step; Set the request and get response

        Response response= given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. step; do assertions

        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));


    }

}
