package get_requests;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;
import pojos.BookingDatesPojo;

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


    }


}
