package com.bootcamp.persistence.dao;

import com.bootcamp.persistence.models.Carrito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoDao extends JpaRepository<Carrito,Long>{
    
}