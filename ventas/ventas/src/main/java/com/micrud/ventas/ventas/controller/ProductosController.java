package com.micrud.ventas.ventas.controller;

import com.micrud.ventas.ventas.entity.Producto;
import com.micrud.ventas.ventas.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductosController {

    @Autowired
    IProductoService productoService;

    @GetMapping("/listProducts")
    public List<Producto> listAllProducts(){

        return productoService.listAllProducts();
    }

    @GetMapping("/{idProduct}")
    public Producto findOneProduct(@PathVariable("idProduct") Long id){

        return productoService.findOneProduct(id);

    }

    @PostMapping("/updateProduct")
    public Producto updateProduct(@RequestBody Producto producto){

        return productoService.updateProduct(producto);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(Long id){

        productoService.deleteProduct(id);
    }


}
