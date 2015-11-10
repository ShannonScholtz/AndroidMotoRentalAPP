package rental.example.sscholtz.motorental.repositories.rest;

import rental.example.sscholtz.motorental.model.MotorCycle;
import rental.example.sscholtz.motorental.repositories.RestAPI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shannon on 2015-09-24.
 */
public class RestMotorCycleRentalAPI implements RestAPI<MotorCycle,Long> {

    final String BASE_URL="http://motorental-lefty93.rhcloud.com/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public MotorCycle get(Long id) {
        final String url = BASE_URL+"motorcycle/"+id.toString();
        HttpEntity<MotorCycle> requestEntity = new HttpEntity<MotorCycle>(requestHeaders);
        ResponseEntity<MotorCycle> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MotorCycle.class);
        MotorCycle subject = responseEntity.getBody();
        return subject;
    }

    @Override
    public String post(MotorCycle entity) {
        final String url = BASE_URL+"motorcycle/create";
        HttpEntity<MotorCycle> requestEntity = new HttpEntity<MotorCycle>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(MotorCycle entity) {
        final String url = BASE_URL+"motorcycle/update/"+entity.getId().toString();
        HttpEntity<MotorCycle> requestEntity = new HttpEntity<MotorCycle>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(MotorCycle entity) {
        final String url = BASE_URL+"motorcycle/delete/"+entity.getId().toString();
        HttpEntity<MotorCycle> requestEntity = new HttpEntity<MotorCycle>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<MotorCycle> getAll() {
        List<MotorCycle> subjects = new ArrayList<>();
        final String url = BASE_URL+"motorcycles/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<MotorCycle[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MotorCycle[].class);
        MotorCycle[] results = responseEntity.getBody();

        for (MotorCycle subject : results) {
            subjects.add(subject);
        }

        return subjects;
    }
}
