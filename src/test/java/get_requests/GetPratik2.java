package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utils.JsonUtil;

import java.util.HashMap;

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
    "firstname": "c8997bba-b644-499b-b37c-698018b8ad9c",
    "lastname": "415ecc27-abc6-43f2-9b91-626daaf70bdd",
    "totalprice": 121,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-07-23",
        "checkout": "2022-07-26"
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
                body("firstname",equalTo("c8997bba-b644-499b-b37c-698018b8ad9c") ,"lastname", equalTo("415ecc27-abc6-43f2-9b91-626daaf70bdd"),
                        "totalprice", equalTo(121),"depositpaid", equalTo(true),
                        "bookingdates.checkin" , equalTo("2022-07-23"),
                        "bookingdates.checkout", equalTo("2022-07-26"),"additionalneeds", equalTo("lunch") );
    }

    // get06() icin 2. yol

    @Test
    public void get06Mapper(){

        // 1. step; set the Url

        spec.pathParams("first", "booking", "second", 101);

        // 2. step; set the expected data

        String expectedData="{\n" +
                "    \"firstname\": \"c8997bba-b644-499b-b37c-698018b8ad9c\",\n" +
                "    \"lastname\": \"415ecc27-abc6-43f2-9b91-626daaf70bdd\",\n" +
                "    \"totalprice\": 121,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2022-07-23\",\n" +
                "        \"checkout\": \"2022-07-26\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"lunch\"\n" +
                "}";

        HashMap<String, Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        // 3. step; send the get request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        // 4. step; do assertion

       HashMap<String, Object> actualDataMap = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);

        assertEquals(200, response.getStatusCode());

        assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));

        assertEquals(expectedDataMap.get("checkin"), actualDataMap.get("checkin"));






    }
}
