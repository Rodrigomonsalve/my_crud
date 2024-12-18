package com.micrud.ventas.ventas.service;

import com.micrud.ventas.ventas.dao.IVentasDAO;
import com.micrud.ventas.ventas.entity.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasServiceImpl implements IVentasService{

    @Autowired
    IVentasDAO ventasDAO;

    @Override
    public List<Ventas> listAllVentas() {
        return ventasDAO.findAll();
    }

    @Override
    public Ventas findVenta(Long id) {

        Optional<Ventas> ventasOptional=ventasDAO.findById(id);

            if(ventasOptional.isEmpty()){

                Ventas ventaNull=null;
                return ventaNull;


            }else{
                return ventasOptional.get();


            }


        }

    @Override
    public void deleteVenta(Long id) {

       Optional<Ventas> ventasOptional= ventasDAO.findById(id);

       if(ventasOptional.isEmpty()){
           new Ventas();
       }else{
           Ventas ventaExistente =ventasOptional.get();
           ventasDAO.delete(ventaExistente);
       }


    }

    @Override
    public Ventas generateVenta(Ventas venta) {

      return  ventasDAO.save(venta);

    }

}

