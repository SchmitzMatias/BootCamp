package com.bootcamp.persistence.controllers;

import com.bootcamp.persistence.dto.CarritoDto;
import com.bootcamp.persistence.dto.Mapper;
import com.bootcamp.persistence.interfaces.CarritoInterface;
import com.bootcamp.persistence.interfaces.ProductoInterface;
import com.bootcamp.persistence.models.Carrito;
import com.bootcamp.persistence.models.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CarritoController{

    @Autowired
    private ProductoInterface productos;

    @Autowired
    private CarritoInterface carritos;

    /*@PostMapping("/carritos") TODO preguntar si este formato o el de abajo
    public ResponseEntity<?> addCarrito(@RequestBody(required=true) CarritoDto carrito){
        if(carrito==null)
            return new ResponseEntity<>("Carrito cannot be null ", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(carritos.addCarrito(Mapper.convert(carrito)), HttpStatus.OK);
    } */
    @PostMapping("/carritos")
    public ResponseEntity<?> addCarrito(@RequestParam(required=true) String user){
        //if(user==null)
        //    return new ResponseEntity<>("Carrito cannot be null ", HttpStatus.BAD_REQUEST);
        CarritoDto temporal= new CarritoDto();
        temporal.setUser(user);
        return new ResponseEntity<>(carritos.addCarrito(Mapper.convert(temporal)), HttpStatus.OK);
    }

    @GetMapping("/carritos/{carrito_id}")
    public ResponseEntity<?> getCarrito(@PathVariable(name="carrito_id", required=true)long carritoId){
        if(carritos.getCarrito(carritoId)==null)
            return new ResponseEntity<>("Invalid Id", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(Mapper.convert(carritos.getCarrito(carritoId)), HttpStatus.OK);
    } 

    @DeleteMapping("/carritos/{carrito_id}")
    public ResponseEntity<?> removeCarrito(@PathVariable(name="carrito_id", required=true)long carritoId){
        if(carritos.getCarrito(carritoId)==null)
            return new ResponseEntity<>("Carrito not found, Nothing to delete", HttpStatus.ACCEPTED);
        carritos.removeCarrito(carritoId);
        return new ResponseEntity<>("Carrito succesfully removed",HttpStatus.OK);
    }

    
    @GetMapping("/carritos")
    public ResponseEntity<?> getAllCarritos(){
        int aux= carritos.getCarritos().size();
        if(aux==0)
            return new ResponseEntity<>("There are no Carritos to show",HttpStatus.ACCEPTED);
        return new ResponseEntity<>((carritos.getCarritos()), HttpStatus.OK); //TODO mapper para que devuelva dtos?
    }

    @PutMapping("/carritos/{carrito_id}/productos/{producto_id}")
    public ResponseEntity<?> addProducto(@PathVariable(name="carrito_id", required=true)long carritoId, @PathVariable(name="producto_id", required=true) long productoId){
        if (carritos.getCarrito(carritoId)==null)
            return new ResponseEntity<>("Invalid Carrito Id", HttpStatus.BAD_REQUEST);
        Producto producto= productos.get(productoId);
        Carrito carrito= carritos.getCarrito(carritoId);
        carritos.addProducto(carrito.getIdCarrito(), producto);
        return new ResponseEntity<>("agregado con exito", HttpStatus.OK);
    }

    @DeleteMapping("/carritos/{carrito_id}/productos/{producto_id}")
    public ResponseEntity<?> removeProducto(@PathVariable(name="carrito_id", required=true)long carritoId, @PathVariable(name="producto_id", required=true) long productoId){
        if (carritos.getCarrito(carritoId)==null)
            return new ResponseEntity<>("Invalid Carrito Id", HttpStatus.BAD_REQUEST);
        if(productos.get(productoId)==null)
            return new ResponseEntity<>("producto not found, Nothing to delete", HttpStatus.ACCEPTED);
        Producto producto= productos.get(productoId);
        carritos.removeProducto(carritoId, producto);
        System.out.println("borrado" + carritos.getCarrito(carritoId).toString());
        return new ResponseEntity<>("Producto succesfully removed",HttpStatus.OK);
    }

}
