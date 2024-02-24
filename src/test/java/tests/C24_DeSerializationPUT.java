package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class C24_DeSerializationPUT extends BaseUrlJsonPlaceUrl {

/*  https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
        Expected Response Body:
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }     */

    @Test
    public void test01(){
        // 1- endpoint hazırla ve varsa request body hazırla
        specJsonPlaceHolder.pathParams("pp1", "posts", "pp2","70");

        Map<String , Object> reqBodyMAP = JsonPlaceData.bodyOlustur();

        // 2- Expected data oluştur:
        Map<String,Object> expBodyMAP = JsonPlaceData.bodyOlustur();
        System.out.println("expBodyMAP= " + expBodyMAP);

        // 3- Response kaydet:
        Response response = given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                                    .when()
                                    .body(reqBodyMAP)
                                    .put("{pp1}/{pp2}");

        // 4- Assertion İşlemi:

        // expected body <------> response
        //      MAP      <------> response
        // Assertion işlemi yapabilmek için dönen response MAP'e çevrilmelidir. Buna ""De-serialisation"" denir.

        Map<String,Object> resMAP = response.as(HashMap.class);

        Assert.assertEquals(expBodyMAP.get("title"), reqBodyMAP.get("title"));
        Assert.assertEquals(expBodyMAP.get("body"), reqBodyMAP.get("body"));
        Assert.assertEquals(expBodyMAP.get("userId"), reqBodyMAP.get("userId"));
        Assert.assertEquals(expBodyMAP.get("id"), reqBodyMAP.get("id"));



















    }

}
