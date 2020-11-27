package DAO;

import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(Integer id) throws SQLException, HibernateException;

    Optional<T> save(T t) throws SQLException, HibernateException;

    Optional<T> update(T t) throws SQLException, HibernateException;

    Optional<T> delete(T t) throws SQLException, HibernateException;

    List<T> findAll () throws SQLException, HibernateException;
}

