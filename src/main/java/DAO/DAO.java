package DAO;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class DAO <T> implements CRUD {

    public Class<T> cLass;
    public void setClass(Class<T> cLassToSet) {
        this.cLass = cLassToSet;
    }

    public T findById(int id) throws SQLException {
        return (T) findById(id);
    }

    public T save(Object t){
     return (T) save(t);
    }

    public T update(Object t){
        return (T) update(t);
    }

    public T  delete(Object t){
        return (T) delete(t);
    }

    public List<T> findAll() throws SQLException {
        return new LinkedList<T>();
    }
}
