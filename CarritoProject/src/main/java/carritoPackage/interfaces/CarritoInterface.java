package carritoPackage.interfaces;


import java.util.List;

import carritoPackage.models.*;

public interface CarritoInterface {

    public Boolean addCarrito(Carrito carrito);
    
    public void removeCarrito(long idCarrito);

	public Carrito getCarrito(long idCarrito);

	public List<Carrito> getCarritos();

	public Carrito addProducto(long idCarrito, Producto producto);

	public Carrito removeProducto(long idCarrito, Producto producto);

}