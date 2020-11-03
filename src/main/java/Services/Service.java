package Services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Service<K> {

    Optional<K> findById(Integer id) throws Throwable;

    Optional<K> save(K k) throws SQLException;

    Optional<K> update(K k) throws SQLException;

    Optional<K> delete(K k) throws SQLException;

    List<K> findAll() throws SQLException;
}

