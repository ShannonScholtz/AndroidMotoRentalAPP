package rental.example.sscholtz.motorental.repositories;

import java.util.List;

/**
 * Created by Shannon on 2015-09-24.
 */
public interface RestAPI<S, ID> {
    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}

