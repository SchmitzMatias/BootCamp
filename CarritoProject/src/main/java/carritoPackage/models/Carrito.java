package carritoPackage.models;

import java.util.HashMap;

public class Carrito {
	private Long idCarrito;
	private String user;
	private HashMap<Producto, Integer> productos; //producto, unidades del mismo
	
	public Carrito() {
		productos= new HashMap<>();
	}

	public Carrito(HashMap<Producto,Integer> productos){ //TODO usado para el mock ?
		this.setProductos(productos);
	}

	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public String getUser(){
		return user;
	}

	public void setUser(String user){
		this.user= user;
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
	
	/*public Double getTotalAPagar() { al ser el que va a la BD, no hace falta que calcule algo que va a ir a la vista, eso lo hace en dto
		Double temporal=0.0;
		for(Map.Entry<Producto, Integer> entry: productos.entrySet()) {
			temporal+=entry.getKey().getCosto()*entry.getValue();
		}
		return temporal;
	}*/
}
