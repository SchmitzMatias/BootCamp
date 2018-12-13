package com.bootcamp.persistence.controllers;

//import com.bootcamp.persistence.dao.ProductoDao;
import com.bootcamp.persistence.dto.Mapper;
import com.bootcamp.persistence.dto.ProductoDto;
import com.bootcamp.persistence.interfaces.ProductoInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/producto")
public class ProductoController{

    /*@Autowired
    private ProductoDao productoDao;

    @PostMapping("/addProducto")
    public ResponseEntity<?> addProducto(@RequestBody(required=true) ProductoDto producto){
        if(producto==null)
            return new ResponseEntity<>("Producto cannot be null", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(productoDao.saveProducto(Mapper.convert(producto)), HttpStatus.OK);
    }

    @GetMapping("/getProducto/{producto_id}")
    public ResponseEntity<?> getProducto(@PathVariable(name="producto_id", required=true)long productoId){
        if(productoDao.getProducto(productoId)==null)
            return new ResponseEntity<>("Invalid Id",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(Mapper.convert(productoDao.getProducto(productoId)),HttpStatus.OK);
    }

    @GetMapping("/getAllProductos")
    public ResponseEntity<?> getAllProductos(){
        if(productoDao.findAll().size()==0 || productoDao.findAll()==null)
            return new ResponseEntity<>("There are no Productos to show",HttpStatus.ACCEPTED);
        return new ResponseEntity<>((productoDao.findAll()),HttpStatus.OK);//TODO mapper para que devuelva dtos?
    }

    @DeleteMapping("/removeProducto/{producto_id}")
    public ResponseEntity<?> removeProducto(@PathVariable(name="producto_id", required=true) long productoId){
        if(productoDao.getProducto(productoId)==null)
            return new ResponseEntity<>("Producto not found, Nothing to delete", HttpStatus.ACCEPTED);
        productoDao.removeProducto(productoId);
        return new ResponseEntity<>("Producto succesfully removed",HttpStatus.OK);
    }*/


    @Autowired
    private ProductoInterface productos;

    @PostMapping("/addProducto")
    public ResponseEntity<?> addProducto(@RequestBody(required=true) ProductoDto producto){
        if(producto==null)
            return new ResponseEntity<>("Producto cannot be null", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(productos.add(Mapper.convert(producto)), HttpStatus.OK);
    }

    @GetMapping("/getProducto/{producto_id}")
    public ResponseEntity<?> getProducto(@PathVariable(name="producto_id", required=true)long productoId){
        if(productos.get(productoId)==null)
            return new ResponseEntity<>("Invalid Id",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(Mapper.convert(productos.get(productoId)),HttpStatus.OK);
    }

    @DeleteMapping("/removeProducto/{producto_id}")
    public ResponseEntity<?> removeProducto(@PathVariable(name="producto_id", required=true) long productoId){
        if(productos.get(productoId)==null)
            return new ResponseEntity<>("Producto not found, Nothing to delete", HttpStatus.ACCEPTED);
        productos.remove(productoId);
        return new ResponseEntity<>("Producto succesfully removed",HttpStatus.OK);
    }

    @GetMapping("/getAllProductos")
    public ResponseEntity<?> getAllProductos(){
        if(productos.getAll().size()==0 || productos.getAll()==null)
            return new ResponseEntity<>("There are no Productos to show",HttpStatus.ACCEPTED);
        return new ResponseEntity<>((productos.getAll()),HttpStatus.OK);//TODO mapper para que devuelva dtos?
    }
}