package waiterless;

import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;

public class ApiTest {



    @Test
    public void testUserFetchesSuccess() {
    	given().when().get("http://localhost:8080/api/v1/restaurant")
        .then()
        .statusCode(200);
    }

}
