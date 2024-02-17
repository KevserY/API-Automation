import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C5_Get_ResponseBodyTesti {
    /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda donen Response'in:
    - status code'unun 200,
    - content type'inin application/json; charset=utf-8,
    - response body'sinde bulunan userId'nin 5,
    - response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.
    */

    @Test
    public void responseBodyTesti() {
    // Endpoint hazırlanır:
        String url = "https://jsonplaceholder.typicode.com/posts/44";
        // soruda verilmişse expected data hazırlanır. soruda ... olduğunu test edin
        //Expected Data hazırlanır

        //Actual Data hazırlanır.
        Response response = given().when().put(url);
        response.prettyPrint();

        // Assertion yapılır
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", Matchers.equalTo(null))
                .body("title", Matchers.equalTo(null));


    }
}
