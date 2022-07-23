package delete_request;

import base_urls.DummyRestApiBaseUrl;
import org.junit.Test;

public class Delete02 extends DummyRestApiBaseUrl {
    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
   HTTP Request Method: DELETE Request
   Test Case: Type by using Gherkin Language
   Assert:     i) Status code is 200
           ii) "status" is "success"
          iii) "data" is "2"
           iv) "message" is "Successfully! Record has been deleted"
 */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/delete/2
    When
        User send Delete Request to Url
    Then
        Status code is 200
    And
        "status" is "success"
    And
          "data" is "2"
    And
          "message" is "Successfully! Record has been deleted"

     */

    @Test
    public void delete01(){





    }
}
