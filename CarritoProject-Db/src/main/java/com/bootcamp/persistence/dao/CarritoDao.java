package com.bootcamp.persistence.dao;

import com.bootcamp.persistence.models.Carrito;

//import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoDao /*extends JpaRepository<Carrito,Long>*/{

    Carrito getCarrito(Long idCarrito);
    Long saveCarrito(Carrito carrito);
    void updateCarrito(Carrito carrito);
    void removeCarrito(Long idCarrito);
}