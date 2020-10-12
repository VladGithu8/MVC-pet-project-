package DAO;

import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOImpl extends DAO {

    @Override
    public Object findById(int id) throws SQLException, SessionException {
        return (Object) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(cLass.getName(), id);
    }

    @Override
    public Object save(Object object) throws SessionException {
        Session session = null;
        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {
            session = sessionFactory.openSession();
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.save(object);
            t1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return object;
    }

    @Override
    public Object delete(Object object) {
        Session session = null;
        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {
            session = sessionFactory.openSession();
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.delete(object);
            t1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return object;
    }

    @Override
    public Object update(Object object) {
        Session session = null;
        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {
            session = sessionFactory.openSession();
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.update(object);
            t1.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return object;
    }

    @Override
    public List<Object> findAll() throws SessionException, SQLException {
        List<Object> objects = (List<Object>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From "+cLass.getSimpleName()).list();
        return new LinkedList<>(objects);
    }
}
