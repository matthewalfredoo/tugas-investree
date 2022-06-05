package com.investree.tugasinvestree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingController {

    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    public void restTemplateSave(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "\"id_peminjam\":2,\n" +
                "\"id_meminjam\":1,\n" +
                "\"tenor\":\"10\",\n" +
                "\"total_pinjaman\":350000,\n" +
                "\"bunga_persen\":2.5,\n" +
                "\"status\":\"Utang\"\n" +
            "}";
        HttpEntity<String> entity = new HttpEntity<>(bodyTesting, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://localhost:8081/v1/transaksi", HttpMethod.POST, entity, String.class
        );
        assert HttpStatus.OK == exchange.getStatusCode();
        System.out.println("response = " + exchange.getBody());
    }

}
