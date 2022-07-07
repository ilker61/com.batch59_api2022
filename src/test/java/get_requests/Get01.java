package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
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
    public void get01(){
       // i- Set the URL (URL kurulacak)
        String url="https://restful-booker.herokuapp.com/booking/554";

       // ii- Set the expected data( POST- PUT- PATCH)

       // iii- Type code to send request
        Response response=given().when().get(url);
        response.prettyPrint();

        // iv- Do Assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //status code nasil yazdirilir
        System.out.println("Status code ; "+response.statusCode());
        System.out.println("Content type ; "+response.contentType());
        System.out.println("Status Line ; "+response.statusLine());

        // Header nasil yazdirilir
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Host"));
        System.out.println(response.header("User-Agent"));

        // Tum header ise headers methodu ile yazdirilir

        System.out.println("//////////");

        System.out.println("Tum Headerlar : \n"+response.headers());

        // Time nasil yazdirilibilir loo

        System.out.println("Time Ne LOO: "+response.getTime());

    }



}
