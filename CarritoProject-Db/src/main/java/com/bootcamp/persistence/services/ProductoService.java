package com.bootcamp.persistence.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.bootcamp.persistence.dao.ProductoDao;
import com.bootcamp.persistence.interfaces.ProductoInterface;
import com.bootcamp.persistence.models.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

@Service
public class ProductoService implements ProductoInterface {

	@Autowired
	private ProductoDao productos;
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public Producto add(Producto producto) {
		if (producto == null) {
			throw new RuntimeException("product can't be null.");
		}

		lock.writeLock().lock();
		try {
			productos.save(producto);
			return producto;
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public void remove(long id) {
		lock.writeLock().lock();
		try {
			productos.deleteById(id);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public Producto get(long id) {
		lock.readLock().lock();
		try {
			return productos.getOne(id);
		} finally {
			lock.readLock().unlock();
		}
	}

	public List<Producto> getAll() {
		lock.readLock().lock();
		try {
			return new ArrayList<>(productos.findAll());
		} finally {
			lock.readLock().unlock();
		}
	}
}