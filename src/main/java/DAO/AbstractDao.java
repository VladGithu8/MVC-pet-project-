package DAO;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {

    protected final Class<T> clazz;

    protected SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public AbstractDao(SessionFactory sessionFactory, Class<T> clazz) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    public Optional<T> findById(Integer id) throws SQLException {
        T t = null;
        try (Session session = sessionFactory.openSession()) {
            t = session.find(clazz, id);
            Transaction t1 = session.beginTransaction();
            Hibernate.initialize(t);
            t1.commit();
        } catch (EntityNotFoundException hE) {
            throw new RuntimeException(hE);
        }
            return Optional.ofNullable(t);
    }

    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        List<T> allToList = session.createQuery("FROM " + clazz.getSimpleName()).list();
        return allToList;
    }

    public Optional<T> save(T entity) throws JDBCException, SQLException {
        try (Session session = sessionFactory.openSession()) {
            Transaction t1 = session.beginTransaction();
            session.save(entity);
            t1.commit();
        } catch (JDBCException je) {
            SQLException cause = (SQLException) je.getCause();
            System.out.println(cause.getMessage());
            }
            return Optional.ofNullable(entity);
        }

        public Optional<T> update (T entity) {
            try (Session session = sessionFactory.openSession()) {
                Transaction t1 = session.beginTransaction();
                session.update(entity);
                t1.commit();
            } catch(RuntimeException hE) {
                throw new EntityNotFoundException();
                }
            return Optional.ofNullable(entity);
        }

        public Optional<T> delete (T entity){
            try (Session session = sessionFactory.openSession()) {
                Transaction t1 = session.beginTransaction();
                if (entity != null) {
                    session.delete(entity);
                }
                t1.commit();
            } catch (HibernateException hE) {
                ObjectNotFoundException cause =(ObjectNotFoundException) hE.getCause();
                System.out.println(cause.getMessage());
                }
            return Optional.ofNullable(entity);
    }
}


