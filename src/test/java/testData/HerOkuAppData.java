package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HerOkuAppData {
  /*  Request body
            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" :

             {   "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"   },

             "additionalneeds" : "wi-fi"
             }

*/

    public static JSONObject JsonReqBodyOlustur() {

        JSONObject innerData = new JSONObject();
        innerData.put("checkin", "2021-06-01");
        innerData.put("checkout", "2021-06-10");

        JSONObject reqData = new JSONObject();
        reqData.put("firstname", "Ahmet");
        reqData.put("lastname", "Bulut");
        reqData.put("totalprice", 500);
        reqData.put("depositpaid", false);
        reqData.put("additionalneeds", "wi-fi");
        reqData.put("bookingdates", innerData);

        return reqData;
    }

    public static JSONObject JsonexpBodyOlustur() {

        JSONObject expData = new JSONObject();

        JSONObject booking = JsonReqBodyOlustur();

        expData.put("bookingid", 24);
        expData.put("booking", booking);

        return expData;
    }

    /*
    {
                            "firstname" : "Ahmet",
                            "lastname" : “Bulut",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                     "checkin" : "2021-06-01",
                                     "checkout" : "2021-06-10"
                                              },
                            "additionalneeds" : "wi-fi"
                        }
     */

    public static Map<String,Object> reqBodyOlustur(){

        Map<String,Object> reqBodyMap=new HashMap<>();
        Map<String,Object> bookingdatesBodyMap=new HashMap<>();
        bookingdatesBodyMap.put("checkin" , "2021-06-01");
        bookingdatesBodyMap.put("checkout" , "2021-06-10");

        reqBodyMap.put("firstname" , "Ahmet");
        reqBodyMap.put("lastname" , "Bulut");
        reqBodyMap.put("totalprice" , 500.0);
        reqBodyMap.put("depositpaid" , false);
        reqBodyMap.put("bookingdates",bookingdatesBodyMap);
        reqBodyMap.put("additionalneeds" , "wi-fi");

        return reqBodyMap;
    }

        /*
        {
                        "bookingid":24,
                        "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                "checkin":"2021-06-01",
                                "checkout":"2021-06-10",
                            "additionalneeds":"wi-fi"
                        }
         */

    public static Map<String,Object> expBodyOlustur() {
        Map<String,Object> expdataMap=new HashMap<>();

        expdataMap.put("bookingid",24);
        expdataMap.put("booking",reqBodyOlustur());


        return expdataMap;


    }

}

