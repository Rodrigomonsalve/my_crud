package com.micrud.ventas.ventas.dao;

import com.micrud.ventas.ventas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductosDAO extends JpaRepository<Producto, Long> {


}
