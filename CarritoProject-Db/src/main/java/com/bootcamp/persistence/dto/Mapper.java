package com.bootcamp.persistence.dto;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.persistence.models.Carrito;
import com.bootcamp.persistence.models.Item;
import com.bootcamp.persistence.models.Producto;

public class Mapper {

	public static CarritoDto convert(Carrito carrito) {
		return carrito.getitems()==null ? new CarritoDto(carrito.getIdCarrito(), carrito.getUser(),new ArrayList<Item>())  
			: new CarritoDto(carrito.getIdCarrito(), carrito.getUser(),carrito.getitems());
	}

	public static Carrito convert(CarritoDto carrito) {
		List<Item> items= carrito.getItems() == null ? new ArrayList<>()
			: carrito.getItems();
		Carrito salida = new Carrito();
		salida.setIdCarrito(carrito.getId());
		salida.setUser(carrito.getUser());
		salida.setitems(items);
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