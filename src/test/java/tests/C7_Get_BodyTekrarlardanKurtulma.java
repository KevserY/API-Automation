package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C7_Get_BodyTekrarlardanKurtulma {
     /*
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        content type'inin application/json,
     ve response body'sindeki
        "firstname"in, "Susan",
        "lastname"in, "Jackson",
        "totalprice"in, 612,
        "depositpaid"in, false,
        "additionalneeds"in, "Breakfast" oldugunu test edin
        NOT: veriler değişiyor, Postman'de kontrol edin!
 */

    @Test
    public void bodyTekrarindanKurtulma(){
        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", Matchers.equalTo("Eric"))
                .body("lastname", Matchers.equalTo("Ericsson"))
                .body("totalprice", Matchers.equalTo(252))
                .body("depositpaid", Matchers.equalTo(true))
                .body("additionalneeds", Matchers.equalTo("Breakfast"));


    }
}
