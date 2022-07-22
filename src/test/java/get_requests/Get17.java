package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponseBodyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get17 extends DummyRestApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/employee/1
       HTTP Request Method: GET Request
       Test Case: Type by using Gherkin Language
       Assert: 	i) Status code is 200
               ii) "employee_name" is "Tiger Nixon"
              iii) "employee_salary" is 320800
               iv)  "employee_age" is 61
                v) "status" is "success"
               vi)  "message" is "Successfully! Record has been fetched."
     */

    /*
    Given
        https://dummy.restapiexample.com/api/v1/employee/1
    When
        User send GET Request to Url
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
        "employee_salary" is 320800
    And
        "employee_age" is 61
    And
        "status" is "success"
    And
        "message" is "Successfully! Record has been fetched."
     */

    @Test
    public void get01(){

    // 1. step; set the Url

    spec.pathParams("first", "employee", "second", 1);

    // 2. step; set the expected Data
        DummyDataPojo dataPojo = new DummyDataPojo("Tiger Nixon", 320800, 61, "");
        DummyResponseBodyPojo responseBodyPojo = new DummyResponseBodyPojo("success", dataPojo,"Successfully! Record has been fetched." );

    // 3. step; send the get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);


        DummyResponseBodyPojo responseBody = JsonUtil.convertJsonToJavaObject(response.asString(),DummyResponseBodyPojo.class);
        System.out.println(responseBody);
        DummyDataPojo dummyApiDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(),DummyDataPojo.class);

        assertEquals(responseBodyPojo.getStatus(),responseBody.getStatus());
        assertEquals(responseBodyPojo.getMessage(),responseBody.getMessage());

//    assertEquals(responseBodyPojo.getData().getEmployeeSalary(), responseBody.getData().getEmployeeSalary());
//    assertEquals(responseBodyPojo.getData().getEmployeeAge(), responseBody.getData().getEmployeeAge());
//    assertEquals(responseBodyPojo.getData().getProfileImage(), responseBody.getData().getProfileImage());











    }


}
