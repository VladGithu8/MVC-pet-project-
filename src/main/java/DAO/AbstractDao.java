package DAO;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
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

    public AbstractDao(SessionFactory sessionFactory, Class<T> clazz) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<T> findById(Integer id) {
        T t = null;
        Transaction t1 = null;
        try (Session session = sessionFactory.openSession()) {
            t = session.find(clazz, id);
            t1 = session.beginTransaction();
            Hibernate.initialize(t);
            t1.commit();
            return Optional.ofNullable(t);
        } catch (HibernateException hE) {
            if (t1 != null) {
                t1.rollback();
            }
            System.err.println("FindById exception message" );
            hE.printStackTrace();
            return Optional.ofNullable(t);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = sessionFactory.openSession()) {
            List<T> allToList = session.createQuery("FROM " + clazz.getSimpleName()).list();
            Transaction t1 = session.beginTransaction();
            Hibernate.initialize(allToList);
            t1.commit();
            session.close();
            return allToList;
        } catch (RuntimeException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
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

        @Override
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

        @Override
        public Optional<T> delete (T entity){
            try (Session session = sessionFactory.openSession()) {
                Transaction t1 = session.beginTransaction();
                if (entity != null) {
                    session.delete(entity);
                }
                t1.commit();
            } catch (HibernateException hE) {
                SQLException cause = (SQLException) hE.getCause();
                System.out.println(cause.getMessage());
                }
            return Optional.ofNullable(entity);
    }
}


