package carritoPackage.models.mocks;

//import java.util.HashMap;

import carritoPackage.models.Producto;

public class ProductoMock {
    private String nombre="pepa";
	private long id=123;
	//private Double costo=20.2;
    //private HashMap<String, Object> cualidades= new HashMap();
    
    public Producto getProductoMock(){
        Producto producto= new Producto();
        producto.setId(this.id);
        producto.setNombre(this.nombre);
        return producto;
    }
}