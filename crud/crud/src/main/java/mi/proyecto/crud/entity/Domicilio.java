package mi.proyecto.crud.entity;

import jakarta.persistence.*;
import org.springframework.aot.generate.GeneratedTypeReference;

@Entity
@Table(name = "address_crud")
public class Domicilio {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id_domicilio;

    @Column
    private String calle;

    @Column
    private String colonia;

    @Column
    private String alcaldia;

    @Column
    private String entidad;

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getAlcaldia() {
        return alcaldia;
    }

    public void setAlcaldia(String alcaldia) {
        this.alcaldia = alcaldia;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        return
                "Calle: " + calle +
                ", Colonia: " + colonia +
                ", Alcaldia: " + alcaldia +
                ", Entidad: " + entidad ;
    }
}
