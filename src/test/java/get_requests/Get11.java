package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class Get11 extends GoRestBaseUrl {

    /*
    Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Indra Ganaka", "Sarada Mehrotra", "Jagathi Chopra" are among the users
        And
            The female users are more than male users
     */

    @Test
    public void get01(){

        // 1. step: set the Url

        spec.pathParams("first", "users");

        // 2. step: set the expected data

        //3. step: Send the request and get the response

        Response response= given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Step; Do Assertion
        // 1. yol; body methodu ile

        response.
                then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data.id", hasSize(10));


    }


}
