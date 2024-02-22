package Practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class S01_ResponseBodyTestEtme {

 /*  https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
     Json formatindaki body ile bir PUT request gonderdigimizde
           {
           "title":"Elif",
           "body":"Merhaba dünya",
           "userId":10,
           "id":70
           }
       donen Response'un,
       status code'unun 200,
       ve content type'inin application/json; charset=utf-8,
       ve Server isimli Header'in degerinin cloudflare,
       ve status Line'in HTTP/1.1 200 OK
       ve title'in "Elif"
       ve body attribute'unun "Merhaba dünya"
       ve userId'nin 10 oldugunu test edin
 */

    @Test
    public void put01(){
        // 1- Endpoint hazırlama ve Request Body
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title" , "Elif");
        reqBody.put("body" , "Merhaba dünya");
        reqBody.put("userId" , 10);
        reqBody.put("id" , 70);

        // 2- İstebdiyse Expected body hazırla

        // 3- Request'i gönder ve dönen Response'u kaydet
        Response response = given().contentType(ContentType.JSON)
                                   .when().body(reqBody.toString()).put(url);

        response.prettyPrint();

        // 4- Assertion yapıyoruz
        response.then().assertThat().contentType("application/json; charset=utf-8")
                                    .header("Server","cloudflare")
                                    .statusLine("HTTP/1.1 200 OK")
                                    .statusCode(200)
                                    .body("title", equalTo("Elif"))
                                    .body("id", equalTo(70));

    }

}
