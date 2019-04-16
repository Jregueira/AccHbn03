package educacionit.entities;

import javax.persistence.*;

@Entity
// @DiscriminatorValue("CL")
@Table(name="clientes")
public class Cliente extends Persona {
    @Column(name="credito")
    private Float credito;

    public Cliente() {
    }

    public Cliente(String id, String nombre, Float credito) {
        super(id, nombre);
        this.credito = credito;
    }

    public Float getCredito() {
        return credito;
    }

    public void setCredito(Float credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + '}' + "Cliente{" + "credito=" + credito + '}';
    }
    
    
    
    
}
