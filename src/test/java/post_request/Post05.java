package post_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponseBodyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post05 extends DummyRestApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
    "status": "success",
    "data": {
        "employee_name": "Tom Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image",
        "id": 3952
                              },
                          "message": "Successfully! Record has been added."
                   }
     */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/create
        {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
    When
        User send POST Request to Url
    Then
        Status code is 200
    And
        {
    "status": "success",
    "data": {
        "employee_name": "Tom Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image",
        "id": 3952
                              },
    "message": "Successfully! Record has been added."
    }

     */

    @Test
    public void post01(){

        // 1. step; set the Url

        spec.pathParam("first", "create");

        // 2. step; set the expected Data

        DummyDataPojo dummyDataPojo=new DummyDataPojo("Tom Hanks",111111, 23,"Perfect image" );

        DummyResponseBodyPojo expectedData=new DummyResponseBodyPojo("success", dummyDataPojo,"Successfully! Record has been added.");

        // 3. step; send the Post request and get the response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(dummyDataPojo).post("/{first}");
        response.prettyPrint();

        // 4. step; Do Assertion

        DummyResponseBodyPojo actualData= JsonUtil.convertJsonToJavaObject(response.asString(), DummyResponseBodyPojo.class);

        assertEquals(expectedData.getMessage(), actualData.getMessage());
        assertEquals(expectedData.getStatus(), actualData.getStatus());

        assertEquals(dummyDataPojo.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(dummyDataPojo.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(dummyDataPojo.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(dummyDataPojo.getProfile_image(), actualData.getData().getProfile_image());

    }
}
