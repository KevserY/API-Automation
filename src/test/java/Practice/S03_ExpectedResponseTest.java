package Practice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S03_ExpectedResponseTest {

/*    http://dummy.restapiexample.com/api/v1/update/21 url'ine asagidaki
      body'ye sahip bir PUT request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

        Request Body
        {
            "status":"success",
            "data":{
                    "name":"Ahmet",
                    "salary":"1230",
                    "age":"44",
                    "id":40
                    }
        }

        Response Body
        {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                    "name":"Ahmet",
                    "salary":"1230",
                    "age":"44",
                    "id":40
                    }
                    },
            "message":"Successfully! Record has been updated."
         }
             */

    @Test
    public void test01(){
        // request body oluştuma:
        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject reqBody = new JSONObject();
        JSONObject innerdata = new JSONObject();

        innerdata.put("name","Ahmet");
        innerdata.put("salary","1230");
        innerdata.put("age","44");
        innerdata.put("id",40);

        reqBody.put("status" , "success");
        reqBody.put("data",innerdata);

        // Expected Body oluşturma:
        JSONObject expData = new JSONObject();
        expData.put("status","success");
        expData.put("data",reqBody); // expected datanın bu kısmı, request ile aynı olduğu için onu direk aldık.
        expData.put("message","Successfully! Record has been updated.");

        // response'u kaydedelim:

        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        // Assertion yapalım:
        // innerdata daki verilere ulaşabilmemiz gerekiyor
        // bunun için JSONpath objesine cast yapmamız lazım.
        // önce bir JsonPath objesi oluşturup, assertion yaparken expData daki veriyi, JsonPath objesinden nasıl çekeriz, bunu yapacağız

        JsonPath resJsonPath = response.jsonPath();

        assertEquals(expData.get("status"),resJsonPath.get("status"));
        assertEquals(expData.get("message"),resJsonPath.get("message"));
        assertEquals(expData.getJSONObject("data").getJSONObject("data").get("name"), resJsonPath.get("data.data.name"));
        assertEquals(expData.getJSONObject("data").getJSONObject("data").get("id"), resJsonPath.get("data.data.id"));
        assertEquals(expData.getJSONObject("data").getJSONObject("data").get("salary"), resJsonPath.get("data.data.salary"));
        assertEquals(expData.getJSONObject("data").getJSONObject("data").get("age"), resJsonPath.get("data.data.age"));
        assertEquals(expData.getJSONObject("data").get("status"), resJsonPath.get("data.status"));






    }
}
