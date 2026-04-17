import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class APITest {
    public static void main(String[] args){
        String URL = "https://jsonplaceholder.typicode.com";
        {
            Response response = given().header("Content-Type","application/json")
                    .when().get(URL+"/posts/1")
                    .then().statusCode(200)
                    .extract().response();
            System.out.print("GET method Response : ");
            System.out.println(response.asString());
        }
        {
            Response response = given().header("Content-Type","application/json").body("{\"title\" : \"Testing POST Method Using REST Assured\",\"id\" : \"101\"}")
                    .when().post(URL+"/posts")
                    .then().statusCode(201)
                    .extract().response();
            System.out.print("POST method Response : ");
            System.out.println(response.asString());

        }
        {
            Response response = given().header("Content-Type","application/json").body("{\"title\" : \"Testing PUT Method Using REST Assured\",\"id\" : \"1\"}")
                    .when().put(URL+"/posts/1")
                    .then().statusCode(200)
                    .extract().response();
            System.out.print("PUT method Response : ");
            System.out.println(response.asString());

        }
        {
            Response response = given().header("Content-Type","application/json")
                    .when().delete(URL +"/posts/1")
                    .then().statusCode(200)
                    .extract().response();
            System.out.print("DELETE method Response : ");
            System.out.println(response.asString());
        }
    }
}
