package com.micrud.ventas.ventas.service;

import com.micrud.ventas.ventas.entity.Ventas;

import java.util.List;

public interface IVentasService {

    public List<Ventas> listAllVentas();
    public Ventas findVenta(Long id);
    public void deleteVenta(Long id);
    public Ventas generateVenta(Ventas venta);


}
