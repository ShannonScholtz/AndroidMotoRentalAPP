package rental.example.sscholtz.motorental.services.Impl;

import rental.example.sscholtz.motorental.model.MotorCycle;
import rental.example.sscholtz.motorental.repositories.RestAPI;
import rental.example.sscholtz.motorental.repositories.rest.RestMotorCycleRentalAPI;

import java.util.List;

/**
 * Created by Shannon on 2015-09-24.
 */
public class MotorCycleServiceImpl implements MotorCycleService {

    final RestAPI<MotorCycle,Long> rest = new RestMotorCycleRentalAPI();
    @Override
    public MotorCycle findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(MotorCycle entity) {

        return rest.post(entity);
    }

    @Override
    public String update(MotorCycle entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(MotorCycle entity) {
        return rest.delete(entity);

    }

    @Override
    public List<MotorCycle> findAll() {
        return rest.getAll();
    }
}

