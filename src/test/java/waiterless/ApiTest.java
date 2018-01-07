package waiterless;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class ApiTest {

	@BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/api/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }
	



    @Test
    public void testRestaurant() {
    	given().when().get("/v1/restaurant")
        .then()
        .statusCode(200).body(containsString("[]"));
    
    	given().when().get("/v1/restaurant/asd3")
        .then()
        .statusCode(404);
    
    	given().
    		accept(ContentType.JSON).
    		contentType(ContentType.JSON).
    		body("{\"id\":\"asd3\",\"name\":\"asd\",\"address\":{\"streetAddress\":\"12450 asd Road\",\"city\":\"asd\",\"state\":\"CA\",\"zip\":\"12345\"},\"telephone\":\"1234567890\",\"fax\":\"1234567890\",\"email\":\"asdasd@gmail.com\"}")
    	.when().post("/v1/restaurant").then()
        .statusCode(201).body(containsString("{\"id\":\"asd3\",\"name\":\"asd\",\"address\":{\"streetAddress\":\"12450 asd Road\",\"city\":\"asd\",\"state\":\"CA\",\"zip\":\"12345\",\"country\":null,\"timeZone\":null},\"restaurantPic\":null,\"telephone\":\"1234567890\",\"fax\":\"1234567890\",\"email\":\"asdasd@gmail.com\",\"menuBook\":null}"));

    
    	given().when().get("/v1/restaurant")
        .then()
        .statusCode(200).body(containsString("[{\"id\":\"asd3\",\"name\":\"asd\",\"address\":{\"streetAddress\":\"12450 asd Road\",\"city\":\"asd\",\"state\":\"CA\",\"zip\":\"12345\",\"country\":null,\"timeZone\":null},\"restaurantPic\":null,\"telephone\":\"1234567890\",\"fax\":\"1234567890\",\"email\":\"asdasd@gmail.com\",\"menuBook\":null}]"));
    
    	
    	given().when().get("/v1/restaurant/asd3")
        .then()
        .statusCode(200).body(containsString("{\"id\":\"asd3\",\"name\":\"asd\",\"address\":{\"streetAddress\":\"12450 asd Road\",\"city\":\"asd\",\"state\":\"CA\",\"zip\":\"12345\",\"country\":null,\"timeZone\":null},\"restaurantPic\":null,\"telephone\":\"1234567890\",\"fax\":\"1234567890\",\"email\":\"asdasd@gmail.com\",\"menuBook\":null}"));
    	
    	given().when().delete("/v1/restaurant/asd3")
    	.then()
    	.statusCode(204);
    	
    	given().when().get("/v1/restaurant")
        .then()
        .statusCode(200).body(containsString("[]"));
    
    	given().when().get("/v1/restaurant/asd3")
        .then()
        .statusCode(404);
    }
    
    
    

}
