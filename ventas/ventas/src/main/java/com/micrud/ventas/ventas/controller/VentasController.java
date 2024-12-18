package com.micrud.ventas.ventas.controller;

import com.micrud.ventas.ventas.entity.Producto;
import com.micrud.ventas.ventas.entity.Ventas;
import com.micrud.ventas.ventas.service.IProductoService;
import com.micrud.ventas.ventas.service.IVentasService;
import org.apache.commons.logging.LogFactory;
import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
public class VentasController {


    private static final Logger log = LoggerFactory.getLogger(VentasController.class);
    private final IVentasService ventasService;

    private final IProductoService productoService;

    @Autowired
    public VentasController(IVentasService ventasService, IProductoService productoService){

        this.ventasService=ventasService;
        this.productoService=productoService;
    }

    @GetMapping("/listVentas")
    public ResponseEntity<?> listAllVentas(){

        List<Ventas> ventasExistentes=ventasService.listAllVentas();

        if(!ventasExistentes.isEmpty()){

            try {
                return ResponseEntity.status(HttpStatus.OK).body(ventasService.listAllVentas());

            } catch(Exception e){

                log.error("Problema al intentar ver las ventas",e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problema al intentar ver las ventas");
            }


        }else {
            log.info("La lista de ventas está vacía");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista de ventas está vacía");
        }



    }

    @GetMapping("/findVenta")
    public ResponseEntity<?> findOneVenta (@RequestParam("idVenta") String id){

        try{
            Long longId=Long.parseLong(id);
            if(longId>0){
               return ResponseEntity.status(HttpStatus.OK).body(ventasService.findVenta(longId));
            }else{

                log.error("El id debe ser mayor que 0");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id debe ser mayor que 0");

            }
        }catch(NumberFormatException e){

           log.error("El valor para poder encontrar una venta, debe ser un número.");
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El valor para poder encontrar una venta, debe ser un número.");
        }
        //Long londId=Long.parseLong(id);

    }

    @DeleteMapping("/eliminarVenta/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable("id") String id){

        try{
            Long idLong=Long.parseLong(id);
            Ventas ventaExistente=ventasService.findVenta(idLong);
            if(idLong>0&ventaExistente!=null){
                ventasService.deleteVenta(idLong);
                return ResponseEntity.status(HttpStatus.OK).body("Eliminación realizada con exito");
            }else{
                log.error("Registro no encontrado. Verificar número de venta");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registro no encontrado. Verificar número de venta");
            }
        }catch (Exception e){
                log.error("Este es el error:",e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debes ingresar un número");
        }

    }

    @PostMapping("/generarVenta")
    public Ventas generateVenta(@RequestBody Ventas venta){


        List<Producto> productoList=venta.getSoldProducts();

        for(int i=1;i<=productoList.size();i++){
            int currentStock=productoList.get(i).getStock();
            currentStock--;
            productoList.get(i).setStock(currentStock);

            if(productoList.get(i).getStock()==0){
                productoList.get(i).setExistence(false);
            }

        }
        return ventasService.generateVenta(venta);


    }

    @ExceptionHandler
    public VentasError exceptionMethod(Exception e){

        VentasError ventasError=new VentasError();

        ventasError.setMessage(e.getMessage());
        ventasError.setTimeStamp(System.currentTimeMillis());
        ventasError.setStatus(HttpStatus.BAD_REQUEST.value());

        return ventasError;


    }



}
