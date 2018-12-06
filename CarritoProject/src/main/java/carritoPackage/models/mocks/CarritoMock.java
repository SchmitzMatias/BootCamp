package carritoPackage.models.mocks;

import java.util.HashMap;

import carritoPackage.models.Carrito;
import carritoPackage.models.Producto;

public class CarritoMock {
    private HashMap<Producto, Integer> productos=new HashMap<>();
    private Producto producto= new ProductoMock().getProductoMock(); 
    
    public Carrito getCarritoMock(){
        productos.put(producto, 1);
        return new Carrito(productos);
    }
}