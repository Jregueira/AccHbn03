package educacionit.entities;

import javax.persistence.*;

@Entity
@Table(name="persona")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// @DiscriminatorColumn(name="disc")
// @DiscriminatorValue("PE")
public class Persona {
    @Id
    @Column(name="id")
    protected String id;
    @Column(name="nombre")
    protected String nombre;

    public Persona() {
    }

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
