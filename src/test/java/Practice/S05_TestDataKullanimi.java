package Practice;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S05_TestDataKullanimi extends BaseUrlJsonPlaceUrl {
    /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
        request yolladigimizda donen response'un :
        - status kodunun 200 ve
        - response body'sinin asagida verilen ile ayni oldugunu test ediniz
            Response body :
            {
                "userId":3,
                "id":22,
                "title":"dolor sint quo a velit explicabo quia nam",
                "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                       um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
            }        */

    @Test
    public void test_01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");
        // soruda response body verilmiş, dönen cevabın bunun gibi olduğunu test edin diyor.
        // soruda verilen response body'yi expected data olarak kullanabiliriz.

                                    // TEST DATA KULLANIMI na geçiyoruz. --> JSONPlaceHolderTestData class'ında verileri oluşturuyoruz.
        // expected body methodla oluşturuyoruz.yukarıda class da yapmıştık.

        JSONObject expData = JsonPlaceHolderTestData.expectedBodyOlusturJSON();

        //response kaydedelim:
        Response response = given().spec(specJsonPlaceHolder).when().get("{pp1}/{pp2}");

        JsonPath resJPath = response.jsonPath();

        // status code doğrulama:
        assertEquals(JsonPlaceHolderTestData.basariliStatusCode, response.getStatusCode());
        // body doğrulama:
        assertEquals(expData.getInt("userId"), resJPath.getInt("userId"));
        assertEquals(expData.getInt("id"), resJPath.getInt("id"));
        assertEquals(expData.getString("title"), resJPath.getString("title"));
        assertEquals(expData.getString("body"), resJPath.getString("body"));

    }
}
