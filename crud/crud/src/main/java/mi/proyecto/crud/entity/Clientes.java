package mi.proyecto.crud.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients_crud")
public class Clientes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int id_clients;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String telefono;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "clients_address_intermediate", joinColumns = @JoinColumn(name="client_id"), inverseJoinColumns=@JoinColumn(name="address_id"))
    private List<Domicilio> domicilio=new ArrayList<Domicilio>();

    public int getId_clients() {
        return id_clients;
    }

    public void setid_clients(int id) {
        this.id_clients = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Domicilio> getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(List<Domicilio> domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
