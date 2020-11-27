package Services;

import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Service<K> {

    Optional<K> findById(Integer id) throws SQLException, HibernateException;

    Optional<K> save(K k) throws SQLException, HibernateException;

    Optional<K> update(K k) throws SQLException, HibernateException;

    Optional<K> delete(K k) throws SQLException, HibernateException;

    List<K> findAll() throws SQLException, HibernateException;
}

