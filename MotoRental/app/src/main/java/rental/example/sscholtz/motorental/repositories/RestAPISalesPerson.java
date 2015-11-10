package rental.example.sscholtz.motorental.repositories;

import rental.example.sscholtz.motorental.model.SalesPerson;

import java.util.List;

/**
 * Created by sscholtz on 2015/09/25.
*/
public interface RestAPISalesPerson {

    List<SalesPerson> getAllSalespersons();
}
