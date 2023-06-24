package pl.pjatk.lightingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.lightingservice.model.Kurs;


@Service
public class LightingService {

    private static final String Kurs_SERVICE_URL = "http://localhost:8080/kurses";

    private final RestTemplate restTemplate;

    @Autowired
    public LightingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Kurs getKurs(Long id) {
        String url = Kurs_SERVICE_URL + "/" + id;
        ResponseEntity<Kurs> response = restTemplate.exchange(url, HttpMethod.GET, null, Kurs.class);
        return response.getBody();
    }

}
