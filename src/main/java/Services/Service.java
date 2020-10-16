package Services;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {
    T findById(int id);

    T save(T t);

    T update(T t);

    T delete(T t);

    List<T> findAll();
}
