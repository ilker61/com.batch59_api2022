package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;
import pojos.JsonPlaceHolderPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {
    /*
    Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                {
    "firstname": "Oliver",
    "lastname": "Smith",
    "totalprice": 100,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-07-18",
        "checkout": "2022-07-19"
    },
    "additionalneeds": "Breakfast"
}
     */

@Test
    public void get01(){

    // 1. step; set the Url

    spec.pathParams("first", "booking", "second", 22);

    // 2. step; set the expected data

    String expectedData= "{\n" +
            "    \"firstname\": \"Oliver\",\n" +
            "    \"lastname\": \"Smith\",\n" +
            "    \"totalprice\": 100,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2022-07-18\",\n" +
            "        \"checkout\": \"2022-07-19\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";

    BookingPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, BookingPojo.class);

    // 3. step; send the get request and get the response

    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    // 4. step do assertion
    BookingPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), BookingPojo.class);
    assertEquals(200, response.getStatusCode());

    assertEquals(expectedDataPojo.getFirstname(), actualDataPojo.getFirstname());
    assertEquals(expectedDataPojo.getLastname(), actualDataPojo.getLastname());
    assertEquals(expectedDataPojo.getTotalprice(), actualDataPojo.getTotalprice());
    assertEquals(expectedDataPojo.getDepositpaid(), actualDataPojo.getDepositpaid());
    assertEquals(expectedDataPojo.getAdditinalneeds(), actualDataPojo.getAdditinalneeds());

    assertEquals(expectedDataPojo.getBookingdates().getCheckin(), actualDataPojo.getBookingdates().getCheckin());
    assertEquals(expectedDataPojo.getBookingdates().getCheckout(), actualDataPojo.getBookingdates().getCheckout());




}

}
