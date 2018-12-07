package carritoPackage.models.mocks;

import java.util.List;
import java.util.ArrayList;

import carritoPackage.models.Carrito;
import carritoPackage.models.Item;
import carritoPackage.models.Producto;

public class CarritoMock {
    private List<Item> items=new ArrayList<>();
    private Producto producto= new ProductoMock().getProductoMock(); 
    
    public Carrito getCarritoMock(){
        items.add(new Item(producto,1));
        return new Carrito(items);
    }
}