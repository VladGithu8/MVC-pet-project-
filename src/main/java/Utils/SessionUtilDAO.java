package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SessionUtilDAO{

    public void save(Object object) {
        Session session = null;
        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {
            session = sessionFactory.openSession();
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.save(object);
            t1.commit();
        } catch (Exception e) {e.printStackTrace();}
        finally {session.close();}
    }
    public void update(Object object) {
        Session session = null;
        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {
            session = sessionFactory.openSession();
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.update(object);
            t1.commit();
        } catch (Exception e){e.printStackTrace();}
        finally {session.close();}
    }
    public void delete(Object object) {
        Session session = null;
        try (SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory()) {
            session = sessionFactory.openSession();
            System.out.println(session);
            Transaction t1 = session.beginTransaction();
            session.delete(object);
            t1.commit();
        } catch (Exception e) {e.printStackTrace();}
        finally {session.close();}
    }
}