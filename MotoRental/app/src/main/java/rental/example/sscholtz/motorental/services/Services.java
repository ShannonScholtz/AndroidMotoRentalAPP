package rental.example.sscholtz.motorental.services;

/**
 * Created by sscholtz on 2015/09/23.
 */

import java.util.List;

public interface Services<S, ID> {
    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
