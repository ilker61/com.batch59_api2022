package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

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

        // 1. step; set the Url

    String strUrl="https://restful-booker.herokuapp.com/booking/554";

        // 2. step; Set the expected data( POST- PUT- PATCH)
        // 3. step; Type code to send request

        Response response= given().when().get(strUrl);

        // 4. step; Do assertion

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");


        // Status code nasil yazdirilir

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // header kismi nassi yazdirilir loo

        System.out.println(response.header("Connection"));
        System.out.println(response.header("Host"));
        System.out.println(response.header("User-Agent"));

        // Tum header ise headers methodu ile yazdirilir

        System.out.println("//////////");

        System.out.println("Tum Headerlar : \n"+response.headers());

        // Time nasil yazdirilibilir loo

        System.out.println("Time Ne LOO: "+response.getTime());

    }

    @Test
    public void get02(){
         /*
        Given
            https://restful-booker.herokuapp.com/booking/10091
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
        // 1. step; set the url

        String url="https://restful-booker.herokuapp.com/booking/10492";

        // 2. step; set the expected data (Post - Put - Petch)
        // 3. step; Type code to send request

        Response response=given().when().get(url);

        // 4. step; do assertion

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // body assertionlari yapacagiz

        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));

        // Text deki son gorev ==>  Server is "Cowboy"
        // bunun icin headers methodunu kullanarak serverin ne oldugunu goruruz

        assertEquals("Cowboy", response.header("Server"));

    }
}
