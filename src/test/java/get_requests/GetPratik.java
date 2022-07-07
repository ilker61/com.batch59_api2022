package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetPratik {
    /*
    1-Postman manuel API testi icin kullanilir
    2-API otomasyon testi icin Rest_Assured Library kullaniyoruz
    3-Otomasyon kodlarinin yazimi icin su adimlari izliyoruz
        a- Gereksinimleri anlama
        b- Test Case yazma
            i- Test Case yazimi icin Gherkin Lenguage kullaniyoruz
            Given (On kosullar), When(aksiyonlar), Then(Donutler), And(Coklu islemler icin kullanilir)
        c- Test kodunun yazimi
            i- Set the URL (URL kurulacak)
            ii- Set the expected data( POST- PUT- PATCH)
            iii- Type code to sedn request
            iv- Do Assertion
     */

    /*
    Given
            https://restful-booker.herokuapp.com/booking/554
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get1(){
        String url="https://restful-booker.herokuapp.com/booking/64";
        Response response=given().when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusLine("HTTP/1.1 200 OK").statusCode(200).contentType("application/json");
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.statusLine());
        System.out.println(response.headers());
        System.out.println(response.getTime());
    }
}
