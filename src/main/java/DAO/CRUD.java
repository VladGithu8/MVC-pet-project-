package DAO;

import java.sql.SQLException;
import java.util.List;

public interface CRUD<T> {

    public T findById(int id) throws SQLException;
    public T save(T t);
    public T update(T t);
    public T  delete(T t);
    public List<T> findAll() throws SQLException;
}
