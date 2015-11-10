package rental.example.sscholtz.motorental.repositories.rest;

import rental.example.sscholtz.motorental.model.Customer;
import rental.example.sscholtz.motorental.repositories.RestAPI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sscholtz on 2015/09/23.
 */
public class RestCustomerDetailsAPI implements RestAPI<Customer,Long> {

    final String BASE_URL = "http://motorental-lefty93.rhcloud.com/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Customer get(Long id) {
        final String url = BASE_URL+"customer/"+id.toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(requestHeaders);
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Customer.class);
        Customer subject = responseEntity.getBody();
        return subject;
    }

    @Override
    public String post(Customer entity) {
        final String url = BASE_URL+"customer/create";
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Customer entity) {
        final String url = BASE_URL+"customer/update/"+entity.getId().toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Customer entity) {
        final String url = BASE_URL+"customer/delete/"+entity.getId().toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> subjects = new ArrayList<>();
        final String url = BASE_URL+"customers";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Customer[].class);
        Customer[] results = responseEntity.getBody();

        for (Customer subject : results) {
            subjects.add(subject);
        }
        return subjects;
    }
}

