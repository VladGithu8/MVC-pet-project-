package Services;

import DAO.AbstractDao;
import org.hibernate.DuplicateMappingException;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;


public abstract class AbstractService<K,T extends AbstractDao<K>> implements Service<K> {

    protected T entity;

    protected AbstractService(T entity) {
        this.entity = entity;
    }

    @Override
    public K save(K k) throws ConstraintViolationException, DuplicateMappingException, SQLException {
             return entity
                .save(k)
                .orElseGet(() -> { return (K) new Object();}
                );
    }

    @Override
    public K findById(Integer id) throws Throwable {
        if (entity.findById(id) == null) {
            System.exit(0);
        }
            return entity.findById(id)
                    .orElseThrow(() -> {
                        return new NullPointerException("Not found anything on id: " + id).getCause();
                    });
        }

    @Override
    public K update(K k) {
        return  entity.update(k).orElseThrow(() -> new EntityNotFoundException("Nothing to update"));
    }

    @Override
    public K delete(K k) {
        return entity.delete(k).orElseThrow(() -> new EntityNotFoundException("Nothing to delete"));
    }

    @Override
    public List<K> findAll() {
        return entity.findAll();
    }
}

