package educacionit.repository;

import educacionit.entities.DosCampos;
import educacionit.entities.Usuario;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UsuarioRepository extends BaseRepository<Usuario> {
    
    public UsuarioRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Usuario.class);
    }
    
    public List<Usuario> obtenerTodosLosUsuarios() {
        // from Usuario
        // from Usuario u where u.nombre = 'Marcos'
        // from Usuario u order by nombre
        
        Session sess = sessionFactory.openSession();
        Query q = sess.createQuery("from Usuario u order by nombre desc");
        List<Usuario> ret = q.list();
        sess.close();
        return ret;
    }
    public List<Object[]> obtenerSoloAlgunasColumnas() {
        // select count(*), nombre from Usuario u group by u.nombre
        // select new com.arteysoft.hbn.DosCampos(count(*) as cuenta, u.nombre) from usuario u
        Session sess = sessionFactory.openSession();
        Query q = sess.createQuery("select count(*), nombre from Usuario u group by u.nombre");
        List<Object[]> ret = q.list();
        sess.close();
        return ret;
    }
    public List<DosCampos> obtenerCuenta() {
        // select new com.arteysoft.hbn.DosCampos(count(*) as cuenta, u.nombre) 
        // from usuario u
        Session sess = sessionFactory.openSession();
        Query q = sess.createQuery("select new educacionit.entities.DosCampos(count(*) as cuenta, u.nombre) from Usuario u group by u.nombre");
        List<DosCampos> ret = q.list();
        sess.close();
        return ret;
    }
    public String obtenerValorUnico() {
        Session sess = sessionFactory.openSession();
        Query q = sess.createQuery("select count(*) from Usuario u");
        Object ret = q.uniqueResult();
        sess.close();
        return ret.toString();
    }
    public void ejecutarNamedQuery() {
        Session sess = sessionFactory.openSession();
        Query q = sess.getNamedQuery("todosLosUsuariosOrdenadosXNombreDesc");
        List<Usuario> usuarios = q.list();
        
        usuarios.stream().forEach(usu -> System.out.println(usu));
        
        sess.close();
    }
}
