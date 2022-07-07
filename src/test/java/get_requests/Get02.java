package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/1005
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */
    @Test
    public void get01(){
        // 1. step: Set theURL

        String url="https://restful-booker.herokuapp.com/booking/1005";

        // 2.step: Set the expected data(Post - Put - Patch)

        // 3.step: Type code to send request

        Response response= given().when().get(url);
        response.prettyPrint();

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // Response body de bulunan spesifik bir veri nasil assert edilir
        assertTrue(response.asString().contains("Not Found"));

        // Response body TechProEd icermemeli

        assertFalse(response.asString().contains("TechProEd"));

        // Server is "Cowboy"

        assertEquals("Cowboy",response.header("Server") );

    }

}
