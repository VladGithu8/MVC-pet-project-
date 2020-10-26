package DAO;

import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(Integer id) throws SQLException;

    Optional<T> save(T t) throws SQLException, ConstraintViolationException;

    Optional<T> update(T t) throws SQLException;

    Optional<T> delete(T t) throws SQLException;

    List<T> findAll() throws SQLException;
}

