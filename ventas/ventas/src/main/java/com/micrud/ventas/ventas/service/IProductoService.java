package com.micrud.ventas.ventas.service;

import com.micrud.ventas.ventas.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> listAllProducts();
    public Producto findOneProduct(Long id);
    public Producto updateProduct(Producto product);
    public void deleteProduct(Long id);
    //public void sellProduct(Long id);
}
