package com.micrud.ventas.ventas.dao;

import com.micrud.ventas.ventas.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasDAO extends JpaRepository<Ventas, Long >{
}
