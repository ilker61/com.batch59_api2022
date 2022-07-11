package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class Get03 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void get01(){

        //1.step; Set the Url

        // String url="https://jsonplaceholder.typicode.com/todos/23";

        spec.pathParams("first", "todos", "second", 23);

        // 2.step; Set the expected data

        // 3. step: Set the Request and get the Response

        Response response=given().spec(spec).when().get("/{first}/{second}");

        // 4. step; Do Assertion

        // 1. yoll

        response.then().assertThat().statusCode(200).contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));

        // 2. yoll
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit") , "completed", equalTo(false), "userId", equalTo(2));

    }

    /*
        1-Assertion yaparken Java calismayi durudurdugunda hata sonrasi kodlar calismaz. boylece hata sonrasi
    assertionlar hakkinda bilgi sahibi olamayiz. hata oncesi assertionlar gecer, sonrasini bilemeyiz.
    Hatayi gorunce durur. bu hard assertiondur.
        2-Eger kodumuzu hata noktasinda duracak sekilde yazarsak bu hard assertiondur
        3-Eger kodumuzu hata noktasinda durmacak sekilde yazarsak bu soft assertiondur
        4-Eger coklu body() icinde assertion yaparsak hard assertion yapmis oluruz, Eger tek body() icinde
        assertion yaparsak soft assertion yapmis oluruz,
     */

}
