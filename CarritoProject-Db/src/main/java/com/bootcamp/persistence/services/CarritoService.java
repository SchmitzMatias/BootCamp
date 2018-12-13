package com.bootcamp.persistence.services;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.bootcamp.persistence.dao.CarritoDao;
import com.bootcamp.persistence.interfaces.CarritoInterface;
import com.bootcamp.persistence.models.Carrito;
import com.bootcamp.persistence.models.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; //¿que hace?

@Service
public class CarritoService implements CarritoInterface {

	//private Map<Long, Carrito> carritos = new HashMap<>();
	//private AtomicLong sequence = new AtomicLong(0L);
	@Autowired
	private CarritoDao carritos;
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public Carrito addCarrito(Carrito carrito) {
		if (carrito == null) {
			//throw new RuntimeException("invalid cart: null");
			throw new RuntimeException("Carrito can't be null.");
		}
		/*
		if (carrito.getIdCarrito() == null) {
			carrito.setIdCarrito(sequence.addAndGet(1));
		}*/

		lock.writeLock().lock();
		try {
			carritos.save(carrito);
		} finally {
			lock.writeLock().unlock();
		}
		return carrito;
	}

	public Carrito getCarrito(long idCarrito) {
		lock.readLock().lock();
		try {
			return carritos.getOne(idCarrito);
		} finally {
			lock.readLock().unlock();
		}
	}

	public void removeCarrito(long idCarrito) {
		lock.writeLock().lock();
		try {
			carritos.deleteById(idCarrito);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public Carrito addProducto(long idCarrito, Producto producto) {
		if (producto == null) {
			throw new RuntimeException("invalid product. PRODUCT=" + producto);
		}

		lock.writeLock().lock();
		try {
			Carrito carrito = carritos.getOne(idCarrito);
			if (carrito == null) {
				throw new RuntimeException("cart does not exists. CART_ID=" + idCarrito);
			}
			carrito.addProducto(producto);
			return carrito;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public Carrito removeProducto(long idCarrito, Producto producto) {
		Carrito carrito = carritos.getOne(idCarrito);
		if (carrito == null) {
			return null;
		}
		lock.writeLock().lock();
		try {
            if(carrito.getitems()!= null){
                carrito.removeProducto(producto);
            }
            return carrito;
		} finally {
			lock.writeLock().unlock();
		}
	}

	/*
	@Override
	public HashMap<Long,Carrito> getCarritos() {
		lock.readLock().lock();
		try {
			return (HashMap<Long, Carrito>) carritos;
		} finally {
			lock.readLock().unlock();
		}
	}*/

}