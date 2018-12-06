package carritoPackage.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import carritoPackage.interfaces.ProductoInterface;
import carritoPackage.models.Producto;

import org.springframework.stereotype.Service; 

@Service
public class ProductoServiceInMem implements ProductoInterface {

	private Map<Long, Producto> productos = new HashMap<>(); //<IdProducto, Producto>
	private AtomicLong sequence = new AtomicLong(0L);
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public Producto add(Producto producto) {
		if (producto == null) {
			throw new RuntimeException("product can't be null.");
		}

		if (producto.getId() == null) {
			producto.setId(sequence.incrementAndGet());
        }

		lock.writeLock().lock();
		try {
			productos.put(producto.getId(), producto);
			return producto;
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public void remove(long id) { //TODO hacer el check de qué pasa si no pudo eliminarlo
		lock.writeLock().lock();
		try {
			productos.remove(id);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public Producto get(long id) {
		lock.readLock().lock();
		try {
			return productos.get(id); //TODO hacer el check de qué pasa si no lo encontró
		} finally {
			lock.readLock().unlock();
		}
	}

	public List<Producto> getAll() {
		lock.readLock().lock();
		try {
			return new ArrayList<>(productos.values()); //protege el encapsulamiento al no retornar la lista original
		} finally {
			lock.readLock().unlock();
		}
	}

}