package Services;

import DAO.AbstractDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class AbstractService<K,T extends AbstractDao<K>> implements Service<K> {

    protected final T entity;

    protected AbstractService(T entity) {
        this.entity = entity;
    }

    @Override
    public K save(K t) {
            return entity
                    .save(t)
                    .orElseGet(() -> { return (K) new Object();});

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
