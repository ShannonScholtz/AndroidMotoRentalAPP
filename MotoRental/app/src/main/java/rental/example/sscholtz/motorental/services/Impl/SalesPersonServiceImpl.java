package rental.example.sscholtz.motorental.services.Impl;

import rental.example.sscholtz.motorental.model.SalesPerson;
import rental.example.sscholtz.motorental.repositories.RestAPISalesPerson;
import rental.example.sscholtz.motorental.repositories.rest.RestSalesPersonAPI;

import java.util.List;

/**
 * Created by sscholtz on 2015/09/25.
 */
public class SalesPersonServiceImpl implements SalesPersonService {

    final RestAPISalesPerson rest = new RestSalesPersonAPI();

    public List<SalesPerson> getAllSalespersons() {

        return rest.getAllSalespersons();
    }
}
