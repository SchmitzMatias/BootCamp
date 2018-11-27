package clases;

import java.util.HashMap;
import java.util.Map;

public class CarritoDeCompras {
	private int idCarrito;
	private HashMap<Producto, Integer> productos; //producto, unidades del mismo
	
	public CarritoDeCompras() {
		productos= new HashMap<>();
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public HashMap<Producto,Integer> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Producto,Integer> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto p) {
		if (productos.containsKey(p))
			productos.replace(p, productos.get(p)+1); //si el producto ya estaba, la cantidad de unidades del mismo se incrementa en 1
		else
			productos.put(p, 1);
	}
	
	public void removeProducto(Producto p) {
		if (productos.containsKey(p))
			productos.remove(p);
	}
	
	public String listarProductos() {
		return productos.toString();
	}
	
	public Double getTotalAPagar() {
		Double temporal=0.0;
		for(Map.Entry<Producto, Integer> entry: productos.entrySet()) {
			temporal+=entry.getKey().getCosto()*entry.getValue();
		}
		return temporal;
	}
}
