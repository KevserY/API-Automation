package testData;

import org.json.JSONObject;

public class JsonPlaceHolderTestData {
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

    public static int basariliStatusCode = 200;

    //body'deki verileri oluşturacağımız bir method oluşturuyoruz:

    //bize dönecek olan objenin data türünü de method'da belirtiyoruz. --> JSONObject
    public static JSONObject expectedBodyOlusturJSON(){

        JSONObject expBodyJSON = new JSONObject();
        expBodyJSON.put("userId",3);
        expBodyJSON.put("id",22);
        expBodyJSON.put("title","dolor sint quo a velit explicabo quia nam");
        expBodyJSON.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

        return expBodyJSON;
    }



}
