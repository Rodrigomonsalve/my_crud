package com.micrud.ventas.ventas.service;

import com.micrud.ventas.ventas.dao.IProductosDAO;
import com.micrud.ventas.ventas.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService{


    private final IProductosDAO productosDAO;

    @Autowired
    public ProductoServiceImpl(IProductosDAO productosDAO){
        this.productosDAO=productosDAO;
    }

    @Override
    public List<Producto> listAllProducts() {

        return productosDAO.findAll();
    }

    @Override
    public Producto findOneProduct(Long id) {

        Optional<Producto> productoOptional=productosDAO.findById(id);
        return productoOptional.get();
    }

    @Override
    public Producto updateProduct(Producto producto) {

       Producto productoExistente=findOneProduct(producto.getId_producto());
       productoExistente.setName(producto.getName());
       productoExistente.setSku(producto.getSku());
       productoExistente.setPrice(producto.getPrice());
       productoExistente.setStock(producto.getStock());

       return productoExistente;
    }

    @Override
    public void deleteProduct(Long id) {

        productosDAO.deleteById(id);

    }



}
