package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;
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
    public void get05(){

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

    @Test
    public void get06(){
         /*
    Given
            https://restful-booker.herokuapp.com/booking/101
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "Andrew",
            "lastname": "Anderson",
            "totalprice": 163,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2022-10-03",
                "checkout": "2022-10-11"
            },
            "additionalneeds": "lunch"
        }
     */

        // 1. step; set the Url

        spec.pathParams("first", "booking", "second", 101);

        // 2. step; set the expected data
        // 3. step; send thr request get thr respons

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. step; Do Assertion
        // 1. yol

        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Andrew") ,"lastname", equalTo("Anderson"),
                        "totalprice", equalTo(163),"depositpaid", equalTo(false),
                        "bookingdates.checkin" , equalTo("2022-10-03"),
                        "bookingdates.checkout", equalTo("2022-10-11"),"additionalneeds", equalTo("lunch") );
    }
}
