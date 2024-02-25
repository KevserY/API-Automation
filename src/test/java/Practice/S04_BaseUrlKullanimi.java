package Practice;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class S04_BaseUrlKullanimi extends BaseUrlJsonPlaceUrl {
//Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine
            GET request gonderdigimizde donen response'un - status code'unun 200 oldugunu
            ve Response'ta ("title" degerlerinin) 100 kayit oldugunu test edin.(response'da 100 adet kayıt var)
        */
    @Test
    public void getTesti_01() {
        // endpoint belirle:
        specJsonPlaceHolder.pathParam("pp1","posts");
        //response kaydet:
        Response response = given().spec(specJsonPlaceHolder).when().get("{pp1}");
        // Assertion yapalım:
        response.then().assertThat().statusCode(200).body("title", Matchers.hasSize(100));

    }

    /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response'un status code'unun 200 oldugunu
            ve "title" degerinin "optio dolor molestias sit" oldugunu test edin
         */
    @Test
    public void getTesti_02(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","44");

        Response response = given().spec(specJsonPlaceHolder).when().get("{pp1}/{pp2}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("title", Matchers.equalTo("optio dolor molestias sit"));
    }

     /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response'un status code'unun 200 oldugunu ve
            response body'sinin null oldugunu test edin
         */
    @Test
    public void deleteTesti_01(){
        specJsonPlaceHolder.pathParams("pp1", "posts","pp2","44");

        Response response = given().spec(specJsonPlaceHolder).when().delete("{pp1}/{pp2}");

        response.then().assertThat().statusCode(200).body("title", Matchers.nullValue());

    }



}
