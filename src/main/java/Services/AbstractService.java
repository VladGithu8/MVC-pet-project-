package Services;

import DAO.AbstractDao;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractService<K,T extends AbstractDao<K>> implements Service<K> {

    protected final T entity;

    protected AbstractService(T entity) {
        this.entity = entity;
    }

    @Override
    public K save(K t) {
        try {
            return entity.save(t);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            ///todo: consider to add Option e.g. Java 8
            return null;
        }
    }

    @Override
    public K findById(int id) {
        return null;
    }

    @Override
    public K update(K k) {
        return null;
    }

    @Override
    public K delete(K k) {
        return null;
    }

    @Override
    public List<K> findAll() {
        return null;
    }
}
