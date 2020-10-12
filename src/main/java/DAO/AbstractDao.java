package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

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
    public T findById(int id) throws SQLException {
        return null;
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public T save(T entity) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.save(entity);
            t1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public T delete(T entity) {
        getCurrentSession().delete(entity);
        return entity;
    }


    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
