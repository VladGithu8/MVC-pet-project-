package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {

    private List<T> list = new LinkedList<>();

    protected final Class<T> clazz;

    protected SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public AbstractDao(SessionFactory sessionFactory, Class<T> clazz){
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<T> findById(Integer id) throws SQLException {
        Session session = sessionFactory.openSession();
        return Optional.ofNullable(session.get(clazz,id));
    }

    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        List allToList = session.createQuery("FROM " + clazz.getSimpleName()).list();
        return allToList;
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
        try (Session session = sessionFactory.openSession()) {
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.update(entity);
            t1.commit();
            return Optional.of(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(entity);
        }
    }

    public Optional<T> delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.delete(entity);
            t1.commit();
            return Optional.of(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(entity);
        }
    }
}

