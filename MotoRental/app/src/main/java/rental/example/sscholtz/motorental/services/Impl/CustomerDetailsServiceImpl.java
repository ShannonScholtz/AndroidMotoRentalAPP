package rental.example.sscholtz.motorental.services.Impl;

import rental.example.sscholtz.motorental.model.Customer;
import rental.example.sscholtz.motorental.repositories.RestAPI;
import rental.example.sscholtz.motorental.repositories.rest.RestCustomerDetailsAPI;

import java.util.List;

/**
 * Created by sscholtz on 2015/09/23.
 */
public class CustomerDetailsServiceImpl implements CustomerDetailsService  {
    final RestAPI<Customer,Long> rest = new RestCustomerDetailsAPI();

    @Override
    public Customer findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Customer entity) {

        return rest.post(entity);
    }

    @Override
    public String update(Customer entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Customer entity) {
        return rest.delete(entity);

    }

    @Override
    public List<Customer> findAll() {
        return rest.getAll();
    }
}

