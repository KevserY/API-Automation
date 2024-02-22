package Practice;

import org.json.JSONObject;
import org.junit.Test;

public class S02_JSONObject_JSONPath_Kullanimi {

 /*     Verilen bilgileri türüne göre gruplayarak yazdirma islemi yapacagiz.
        Asagidaki gibi response elde edecegiz:
{
"firstName":"Harika",
"lastName":"Wise",
"address":
       { "streetAddress":"Susam Sokagi",
         "city":"Ankara",
         "postalCode":"06100"
        },
"age":23,
"phoneNumbers":
   [
      { "number":"532-555 55 55",
      "type":"cep" },

      { "number":"0312-123 4567",
      "type":"ev " }
     ]
}


     */

    @Test
    public void test01(){
        // 1- Önce gerekli bilgileri olulturalım:
        JSONObject kisiBilgileri = new JSONObject();

        JSONObject adresBilgileri = new JSONObject();


        JSONObject telBilgileri = new JSONObject();

        // adres bilgilerini response olarak yazdırmak için adresBilgileri objesine tanımlayalım:
        adresBilgileri.put("streetAddress" , "Susam Sokagi");
        adresBilgileri.put("city" , "Ankara");
        adresBilgileri.put("postalCode" , "06100");

        // Telefon Bilgileri için Array oluşturalım:








    }


}
