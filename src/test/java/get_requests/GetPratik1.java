package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GetPratik1 extends JsonPlaceHolderBaseUrl {
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

    @Test
    public void get03(){
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

        //1. step; set the url

        spec.pathParams("first","todos", "second", 23);

        // 2. step; set the expected data
        // 3. step; Set the Request and get the Response

        Response response=given().spec(spec).when().get("/{first}/{second}");

        // 4. do assertion

        // 1. yol  ===> her assertion icin farkli body ler kullanilir

        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).body("userId", equalTo(2));

        //2. yol ===> tek bir body nin icerisine yazilabilir

        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),"userId", equalTo(2) );
    }

    @Test
    public void get04(){
        /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

        //1. step set the Url
        spec.pathParam("first", "todos");
        // 2. step set the expected data
        // 3. step; Set the Request and get the Response

       Response response= given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
       response.prettyPrint();

       response.then().
               assertThat().
               statusCode(200).
               contentType(ContentType.JSON).
               body("id", hasSize(200), "title", hasItem("quis eius est sint explicabo"), "userId", hasItems(2,7,9));

    }

    @Test
    public void get07() {

        /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

        // 1. step; set the Url

        spec.pathParam("first", "todos");

        // 2. step; set the expected Data

        // 3. step; send the request get the response

        Response response = given().spec(spec).when().get("/{first}");

        // 4. step; Do Assertion

        response.then().assertThat().statusCode(200);

        //Print all ids greater than 190 on the console

        JsonPath json= response.jsonPath();

        List<String> idList=json.getList("findAll{it.id>190}.id");
        System.out.println(idList);

        assertEquals(10,idList.size());

        //Print all userIds whose ids are less than 5 on the console
        //Assert that the number of userIds whose ids are less than 5 is 4

        List<String> userIdList=json.getList("findAll{it.id<5}.userId");
        System.out.println(userIdList);

        assertEquals(4, userIdList.size());

        //Print all titles whose ids are less than 5
        //Assert that "delectus aut autem" is one of the titles whose id is less than 5

        List<String> titles=json.getList("findAll{it.id<5}.title");
        System.out.println(titles);

        assertTrue(titles.contains("delectus aut autem"));
    }

    @Test
    public void get08(){

        /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    }

}
