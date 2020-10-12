package DAO;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T findById(int id) throws SQLException;

    T save(T t) throws SQLException;

    T update(T t) throws SQLException;

    T delete(T t) throws SQLException;

    List<T> findAll() throws SQLException;
}
