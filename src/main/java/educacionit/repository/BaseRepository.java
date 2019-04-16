package educacionit.repository;

import educacionit.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseRepository<T> {
    protected SessionFactory sessionFactory;
    private Class<T> type;

    public BaseRepository(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }
    
    public void save(T obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        }
        catch (RuntimeException ex) {
            System.out.println("exception al intentar save !!!! ");
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
    
    public void update(T obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }
        catch (RuntimeException ex) {
            System.out.println("exception al intentar update !!!");
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
    
    public void delete(T obj) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }
        catch (RuntimeException ex) {
            System.out.println("exception al intentar update !!!");
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
    public T obtener(String id) {
        Session session = sessionFactory.openSession();
        T u = session.get(this.type, id);
        session.close();
        return u;
    }
}
