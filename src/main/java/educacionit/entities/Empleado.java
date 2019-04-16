package educacionit.entities;

import javax.persistence.*;

@Entity
// @DiscriminatorValue("EM")
@Table(name="empleados")
public class Empleado extends Persona {
    @Column(name="salario")
    private Float salario;

    public Empleado() {
    }

    public Empleado(String id, String nombre, Float salario) {
        super(id, nombre);
        this.salario = salario;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + '}' +
               "Empleado{" + "salario=" + salario + '}';
    }

    
    
    
    
    
}
