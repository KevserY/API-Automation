package Practice;

import baseUrl.BaseUrlJsonPlaceUrl;
import org.junit.Test;

public class MapKullanimi extends BaseUrlJsonPlaceUrl {

         /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir """_PUT_""" request yolladigimizda
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
        }

         */
    @Test
    public void mapTest_01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");



    }


}
