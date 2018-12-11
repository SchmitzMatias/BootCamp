package carritoPackage.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import carritoPackage.interfaces.CarritoInterface;
import carritoPackage.models.*;

import org.springframework.stereotype.Service; //¿que hace?

@Service
public class CarritoServiceInMem implements CarritoInterface {

	private Map<Long, Carrito> carritos = new HashMap<>();
	private AtomicLong sequence = new AtomicLong(0L);
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public Boolean addCarrito(Carrito carrito) {
		if (carrito == null) {
			//throw new RuntimeException("invalid cart: null");
			return false;
		}

		if (carrito.getIdCarrito() == null) {
			carrito.setIdCarrito(sequence.addAndGet(1));
		}

		lock.writeLock().lock();
		try {
			carritos.put(sequence.get(), carrito);
		} finally {
			lock.writeLock().unlock();
		}
		return true;
	}

	public Carrito getCarrito(long idCarrito) {
		lock.readLock().lock();
		try {
			return carritos.get(idCarrito);
		} finally {
			lock.readLock().unlock();
		}
	}

	public void removeCarrito(long idCarrito) {
		lock.writeLock().lock();
		try {
			carritos.remove(idCarrito);
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
			Carrito carrito = carritos.get(idCarrito);
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
		Carrito carrito = carritos.get(idCarrito);
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

	@Override
	public HashMap<Long,Carrito> getCarritos() {
		lock.readLock().lock();
		try {
			return (HashMap<Long, Carrito>) carritos;
		} finally {
			lock.readLock().unlock();
		}
	}

}