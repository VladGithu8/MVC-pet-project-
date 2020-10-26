package Services;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {

    T findById(Integer id) throws SQLException;

    T save(T t) throws SQLException;

    T update(T t);

    T delete(T t);

    List<T> findAll();
}

