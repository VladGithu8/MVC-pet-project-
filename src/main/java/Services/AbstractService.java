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
            return entity
                    .save(t)
                    .orElseGet(() -> { return (K) new Object();}
                    );
    }

    @Override
    public K findById(Integer id) throws SQLException {
        return (K) entity.findById(id);
    }

    @Override
    public K update(K k) {
        if(k == null){
            System.out.println("Nothing to update");
        }
        return (K) entity.update(k);
    }

    @Override
    public K delete(K k) {
        if(k == null){
            System.out.println("Nothing to delete");
        }
        return (K) entity.delete(k);
    }

    @Override
    public List<K> findAll() {
        return entity.findAll();
    }
}
