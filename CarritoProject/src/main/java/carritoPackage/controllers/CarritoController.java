package carritoPackage.controllers;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carritoPackage.dto.CarritoDto;
import carritoPackage.dto.Mapper;
import carritoPackage.dto.ProductoDto;
import carritoPackage.interfaces.CarritoInterface;
import carritoPackage.interfaces.ProductoInterface;
import carritoPackage.models.Producto;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController{

    @Autowired
    private ProductoInterface productos;
    @Autowired
    private CarritoInterface carritos;

    @PostMapping("/addCarrito")
    public ResponseEntity<?> addCarrito(@RequestBody(required=true) CarritoDto carrito){
        if(carrito==null)
            return new ResponseEntity<>("Carrito cannot be null ", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(carritos.addCarrito(Mapper.convert(carrito)), HttpStatus.OK);
    } 

    @GetMapping("/getCarrito/{carrito_id}")
    public ResponseEntity<?> getCarrito(@PathVariable(name="carrito_id", required=true)long carritoId){/*
        CarritoDto carritoTest=new CarritoDto();
        carritoTest.setId(20L);
        carritoTest.setUser("eze");
        HashMap<ProductoDto,Integer> productos= new HashMap<>();
        ProductoDto p = new ProductoDto();
        p.setId(20L);
        p.setNombre("papa");
        p.setCosto(20D);
        productos.put(p, 1000);
        carritoTest.setProductos(productos);
        JSONObject json= new JSONObject(productos);
        System.out.println(json);*/

        if(carritos.getCarrito(carritoId)==null)
            return new ResponseEntity<>("Invalid Id", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(Mapper.convert(carritos.getCarrito(carritoId)), HttpStatus.OK);
    } 

}
