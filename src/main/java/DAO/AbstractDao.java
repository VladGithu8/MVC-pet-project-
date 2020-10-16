package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {

    private Class<T> clazz;

    private final SessionFactory sessionFactory;

    protected AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setClazz(Class< T > clazzToSet){
        this.clazz = clazzToSet;
    }

    ///todo:imp
    @Override
    public Optional<T> findById(int id) throws SQLException {
        return null;
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public Optional<T> save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.save(entity);
            t1.commit();
            return Optional.of(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(entity);
        }
    }

    public Optional<T> update(T entity) {
        return (Optional<T>) getCurrentSession().merge(entity);
    }

    public Optional<T> delete(T entity) {
        getCurrentSession().delete(entity);
        return Optional.of(entity);
    }


    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
