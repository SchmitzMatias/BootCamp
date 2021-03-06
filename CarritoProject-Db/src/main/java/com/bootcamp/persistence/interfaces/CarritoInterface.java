package com.bootcamp.persistence.interfaces;

import java.util.List;

import com.bootcamp.persistence.models.Carrito;
import com.bootcamp.persistence.models.Producto;


public interface CarritoInterface {

    public Carrito addCarrito(Carrito carrito);
    
    public void removeCarrito(long idCarrito);

	public Carrito getCarrito(long idCarrito);

	public List<Carrito> getCarritos();

	public Carrito addProducto(long idCarrito, Producto producto);

	public Carrito removeProducto(long idCarrito, Producto producto);

}