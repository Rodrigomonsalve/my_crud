package com.micrud.ventas.ventas.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id_ventas;

    @Column
    private int total;

    @Column
    private int taxes;

    @Column
    @OneToMany
    @JoinColumn(name="fk_ventas")
    private List<Producto> soldProducts;

    public Long getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(Long id_ventas) {
        this.id_ventas = id_ventas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTaxes() {
        return taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public List<Producto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<Producto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
