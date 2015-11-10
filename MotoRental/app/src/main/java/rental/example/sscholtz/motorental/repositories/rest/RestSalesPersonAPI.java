package rental.example.sscholtz.motorental.repositories.rest;

import rental.example.sscholtz.motorental.model.SalesPerson;
import rental.example.sscholtz.motorental.repositories.RestAPISalesPerson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sscholtz on 2015/09/25.
 */
public class RestSalesPersonAPI implements RestAPISalesPerson {

    final String BASE_URL="http://motorental-lefty93.rhcloud.com/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();


    public List<SalesPerson> getAllSalespersons() {

        final String url = BASE_URL + "salespersons/";

        List<SalesPerson> hardwareList = new ArrayList<>();
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<SalesPerson[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, SalesPerson[].class);
        SalesPerson[] results = responseEntity.getBody();

        for (SalesPerson hardware : results) {

            hardwareList.add(hardware);
        }

        return hardwareList;
    }
}
