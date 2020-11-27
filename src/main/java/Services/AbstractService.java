package Services;

import DAO.AbstractDao;

import org.hibernate.HibernateException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<K,T extends AbstractDao<K>> implements Service<K> {

    protected T entity;

    protected AbstractService(T entity) {
        this.entity = entity;
    }

    @Override
    public Optional<K> save(K k) throws SQLException {
        return entity.save(k);
    }

    @Override
    public Optional<K> findById(Integer id)  {
        Optional<K> byId = entity.findById(id);
        if(byId.isPresent()){
            return byId;
        } else {
            System.out.println("Nothing on id: " + id);
            return null ;
        }
    }

    @Override
    public Optional<K> update(K k) throws HibernateException {
        return entity.update(k);
    }

    @Override
    public Optional<K> delete(K k) throws SQLException {
        return entity.delete(k);
    }

    @Override
    public List<K> findAll() throws SQLException {
        return entity.findAll();
    }
}

