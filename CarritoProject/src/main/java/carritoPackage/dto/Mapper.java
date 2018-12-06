package carritoPackage.dto;

import java.util.HashMap;
import java.util.Map;

import carritoPackage.models.*;

public class Mapper {

	public static HashMap<ProductoDto,Integer> convert(HashMap<Producto,Integer> mapa){
		HashMap<ProductoDto,Integer> nuevo= new HashMap<>();
		for(Map.Entry<Producto, Integer> entry: mapa.entrySet()) {
			nuevo.put(Mapper.convert(entry.getKey()),entry.getValue());
		}
		return null;
	}

	public static HashMap<Producto,Integer> convert2(HashMap<ProductoDto,Integer> mapa){
		HashMap<Producto,Integer> nuevo= new HashMap<>();
		for(Map.Entry<ProductoDto, Integer> entry: mapa.entrySet()) {
			nuevo.put(Mapper.convert(entry.getKey()),entry.getValue());
		}
		return null;
	}

	public static CarritoDto convert(Carrito carrito) {
		return carrito.getProductos()==null ? new CarritoDto(carrito.getIdCarrito(), carrito.getUser(),new HashMap<ProductoDto,Integer>())  
			: new CarritoDto(carrito.getIdCarrito(), carrito.getUser(),Mapper.convert(carrito.getProductos()));
	}

	public static Carrito convert(CarritoDto carrito) {
		HashMap<Producto,Integer> productos= carrito.getProductos() == null ? new HashMap<>()
			: Mapper.convert2(carrito.getProductos());
		Carrito salida = new Carrito();
		salida.setIdCarrito(carrito.getId());
		salida.setUser(carrito.getUser());
		salida.setProductos(productos);
		return salida;
	}

	public static ProductoDto convert(Producto producto) {
		return new ProductoDto(producto.getId(), producto.getNombre(), producto.getCosto());
	}

	public static Producto convert(ProductoDto producto) {
		Producto result = new Producto();
		result.setId(producto.getId());
		result.setNombre(producto.getNombre());
		result.setCosto(producto.getCosto());
		return result;
	}

}