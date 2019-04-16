package educacionit;

import educacionit.repository.UsuarioRepository;
import educacionit.entities.*;
import educacionit.configuration.HibernateConfiguration;
import educacionit.entities.Usuario;
import educacionit.repository.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void ejemploBaseRepository(SessionFactory sessFac) {
        UsuarioRepository usuRepo = 
                new UsuarioRepository(sessFac);
        
        Usuario usu = new Usuario(
                java.util.UUID.randomUUID().toString(),
                "Pablo",
                "Vaz"
        );
        
        usuRepo.save(usu);
        
        for (DosCampos dc : usuRepo.obtenerCuenta()) {
            System.out.println(dc.cuenta);
            System.out.println(dc.nombre);
        }
        
        System.out.println(usuRepo.obtenerValorUnico());
        
        sessFac.close();
    }
    public static void ejemploNamedQueries(SessionFactory sessFac) {
        UsuarioRepository usuRepo = 
                new UsuarioRepository(sessFac);
        
        usuRepo.ejecutarNamedQuery();
    }
    public static void pruebaPersisitirPersona(SessionFactory sessFac) {
        BaseRepository<Persona> personaRepo = 
                new BaseRepository<Persona>(sessFac, Persona.class);
        
        Persona p = new Cliente(java.util.UUID.randomUUID().toString(),
                                "Julio", 200.0f);
        
        personaRepo.save(p);
    }
    public static void main( String[] args )
    {
        HibernateConfiguration hibernateConfiguration = new 
            HibernateConfiguration();
        
        SessionFactory sessFac = hibernateConfiguration.configure();
        
        pruebaPersisitirPersona(sessFac);
    }
}
