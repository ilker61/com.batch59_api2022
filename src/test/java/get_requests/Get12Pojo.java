package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12Pojo extends HerOkuAppBaseUrl {

    /*
    Given
            https://restful-booker.herokuapp.com/booking/22
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {{
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void getPojo(){
        //1. step; set the Url
        spec.pathParams("first", "booking", "second", 23);

        // 2. step; set the expected data

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2013-02-23","2014-10-23" );
        BookingPojo bookingPojo=new BookingPojo("Sally","Brown", 111, true,bookingDatesPojo,"Breakfast" );

        // 3. step; send get request get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. step; do assertion

        BookingPojo actualPojo = response.as(BookingPojo.class);

        assertEquals(200, response.getStatusCode());

        assertEquals(bookingPojo.getFirstname(), actualPojo.getFirstname());
        assertEquals(bookingPojo.getLastname(), actualPojo.getLastname());
        assertEquals(bookingPojo.getTotalprice(), actualPojo.getTotalprice());
        assertEquals(bookingPojo.getDepositpaid(), actualPojo.getDepositpaid());


        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBookingdates().getCheckout());

       assertEquals(bookingPojo.getAdditinalneeds(), actualPojo.getAdditinalneeds());



    }


}
