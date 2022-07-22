package put_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponseBodyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {

    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
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
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    /*
    Given
        https://dummy.restapiexample.com/api/v1/update/21
        {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
    When
        User send PUT Request to Url
    Then
        Status code is 200
    And
        Response body should be like the following
        {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }

     */

    @Test
    public void put01(){

        //1. step; set the Url

        spec.pathParams("first", "update", "second", 21);

        // 2. step; set the expected Data

        DummyDataPojo dummyDataPojo=new DummyDataPojo("Tom Hanks",111111, 23,"Perfect image" );

        DummyResponseBodyPojo expectedData=new DummyResponseBodyPojo("success", dummyDataPojo,"Successfully! Record has been updated.");

        // 3. step; send the put request and get the response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(dummyDataPojo).put("/{first}/{second}");
        response.prettyPrint();

        // 4. step; Do assertion

        DummyResponseBodyPojo actualData= JsonUtil.convertJsonToJavaObject(response.asString(), DummyResponseBodyPojo.class);

        assertEquals(expectedData.getMessage(), actualData.getMessage());
        assertEquals(expectedData.getStatus(), actualData.getStatus());

        assertEquals(dummyDataPojo.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(dummyDataPojo.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(dummyDataPojo.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(dummyDataPojo.getProfile_image(), actualData.getData().getProfile_image());
    }
}
