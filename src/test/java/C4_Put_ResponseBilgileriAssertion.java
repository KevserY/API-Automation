import org.junit.Test;

public class C4_Put_ResponseBilgileriAssertion {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki Json formatindaki body ile
        bir PUT request gonderdigimizde
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
        donen Response'un,
        status code'unun 200,
        ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin cloudflare,
        ve status Line'in HTTP/1.1 200 OK olduğunu assert ediniz.
     */

    @Test
    public void put01() {
        // 1-Endpoint belirlenerek hazırlanır
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        // 2-Gerekli ise Expected Data hazırlanır
        
        // 3-Actual Data kaydedilir
        // 4-Assertion İşlemi Yapılır
    }
}
